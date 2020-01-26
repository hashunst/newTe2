package com.example.newte2.all

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newte2.R

class ReminderViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_simple_linear_reminder, parent, false)
) {

    var reminder: Reminder? = null
    var example = itemView.findViewById<TextView>(R.id.name)

    fun bindTo(reminder: Reminder) {
        this.reminder = reminder
        example.text = reminder.id.toString()

    }

}
