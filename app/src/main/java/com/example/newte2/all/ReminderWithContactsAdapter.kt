package com.example.newte2.all


import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

class ReminderWithContactsAdapter : PagedListAdapter<ReminderWithContacts, ReminderWithContactsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ReminderWithContactsViewHolder(parent)

    override fun onBindViewHolder(holder: ReminderWithContactsViewHolder, position: Int) {
        getItem(position)?.let { holder.bindTo(it) }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ReminderWithContacts>() {
            override fun areItemsTheSame(oldItem: ReminderWithContacts, newItem: ReminderWithContacts): Boolean =
                oldItem.reminder == newItem.reminder

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: ReminderWithContacts, newItem: ReminderWithContacts): Boolean =
                oldItem == newItem
        }
    }
}