package com.example.newte2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.toLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newte2.all.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var model: ContactViewModel
    lateinit var remModel: ReminderViewModel

//    private val viewModel by viewModels<ContactViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProviders.of(this).get(ContactViewModel::class.java) as ContactViewModel;
        remModel = ViewModelProviders.of(this).get(ReminderViewModel::class.java);


        //startService(Intent(this, MyService::class.java))

//        AlertDialog.Builder(this).setView(R.layout.dialog_add_session).show()


        clist.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        val adapter = ReminderWithContactsAdapter()
        clist.adapter = adapter


        remModel.allWithContacts.observe(this, Observer {
            adapter.submitList(it)
        })

        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            // enable the items to swipe to the left or right
            override fun getMovementFlags(recyclerView: RecyclerView,
                                          viewHolder: RecyclerView.ViewHolder): Int =
                makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean = false

            // When an item is swiped, remove the item via the view model. The list item will be
            // automatically removed in response, because the adapter is observing the live list.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                (viewHolder as ReminderWithContactsViewHolder).reminder?.let {
                    remModel.remove(it)
                }
            }
        }).attachToRecyclerView(clist)
    }


    fun addReminder(view:View){
        startActivity(Intent(this@MainActivity, InsertReminderActivity::class.java))
    }

}

