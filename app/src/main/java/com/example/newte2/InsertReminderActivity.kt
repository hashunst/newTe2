package com.example.newte2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newte2.all.*
import kotlinx.android.synthetic.main.activity_insert_reminder.*

class InsertReminderActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapterSimple

    lateinit var remModel: ReminderViewModel
    lateinit var conModel: ContactViewModel

    val tempReminder = Reminder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_reminder)

        remModel = ViewModelProviders.of(this).get(ReminderViewModel::class.java);
        conModel = ViewModelProviders.of(this).get(ContactViewModel::class.java);

        adapter = ContactAdapterSimple()
        clist.layoutManager = LinearLayoutManager(this)
        clist.adapter = adapter


        btn_insert.setOnClickListener {
            tempReminder.title = edTitle.text.toString()
            tempReminder.des = edDes.text.toString()
            tempReminder.color = sp_color.selectedItemPosition.toString()
            tempReminder.olavial = sp_Olaviat.selectedItemPosition
            tempReminder.remindType = sp_Type.selectedItemPosition.toString()
            tempReminder.remindNumbers = sp_repeat.selectedItemPosition
            tempReminder.randomShift = 3
//            tempReminder.witchDayOfWeek = sp_
            tempReminder.startTime = sp_startNotification.selectedItemPosition
            tempReminder.endTime = sp_endNotification.selectedItemPosition
            tempReminder.imageUri = ""
            tempReminder.category = sp_Category.selectedItemPosition
            tempReminder.favorited = 1
            remModel.insertUpdateId(this, tempReminder)
        }

        btn_cancel.setOnClickListener { finish() }


        remModel.insertedDb.observe(this, Observer {
            for(contact in adapter.contacts){
                contact.reminder_id = it.toInt()
                conModel.insert(contact)
            }
            finish()
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1-> {
                if(resultCode == RESULT_OK){
                    val contactFetch = fetchContentName(data!!.data!!)
                    adapter.add(Contact(0, contactFetch[0].toString(), 3))
                }
            }
        }
    }

    fun fetchContentName(data: Uri): ArrayList<String> {

        val c = managedQuery(data, null, null, null, null)
        c.moveToNext()
        val name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        val id = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//        toast(this@InsertReminderActivity, c.getInt(c.getColumnIndex(ContactsContract.Contacts._ID)).toString())
        return arrayListOf(id, name)
    }

    fun addContact(view:View){
        val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        startActivityForResult(intent, 1)
    }
}
