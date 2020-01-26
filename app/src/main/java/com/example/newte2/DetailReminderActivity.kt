package com.example.newte2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newte2.all.ContactAdapterSimple
import com.example.newte2.all.Reminder
import com.example.newte2.viewmodels.DetailReminderViewModel
import kotlinx.android.synthetic.main.activity_detail_reminder.*

class DetailReminderActivity : AppCompatActivity() {

    private lateinit var reModel: DetailReminderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_reminder)
        reModel = ViewModelProviders.of(this).get(DetailReminderViewModel::class.java)
        reModel.id.value = intent.getIntExtra("id", -1)

        val cAdapter = ContactAdapterSimple()
        clist.layoutManager = LinearLayoutManager(this)
        clist.adapter = cAdapter

        reModel.reminderWithContacts.observe(this, Observer { itt->

            val it = itt.reminder
            val contacts = itt.contacts

            if (it != null) {
                tv_title.text = it.title
                tv_des.text = it.des
                tv_category.text = it.category.toString()
                tv_olaviat.text = it.olavial.toString()
            }
            cAdapter.submit(contacts)

        })



    }
}
