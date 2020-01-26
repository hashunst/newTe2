package com.example.newte2.all

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newte2.DetailReminderActivity
import com.example.newte2.R
import kotlinx.android.synthetic.main.item_simple_linear_reminder.view.*

class ReminderWithContactsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_simple_linear_reminder, parent, false)
) {

    var contacts: List<Contact>? = null
    var reminder: Reminder? = null
    var example = itemView.findViewById<TextView>(R.id.name)

    fun bindTo(remWithCons: ReminderWithContacts) {
        this.reminder = remWithCons.reminder
        this.contacts = remWithCons.contacts
        itemView.name.text = reminder?.title

        itemView.setOnClickListener {
            it.context.startActivity(
                Intent(itemView.context, DetailReminderActivity::class.java)
                    .putExtra(
                        "id",
                        reminder?.id
                    )
            )
        }

    }

}
