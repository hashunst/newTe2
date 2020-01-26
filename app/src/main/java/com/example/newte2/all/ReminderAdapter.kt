package com.example.newte2.all


import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

class ReminderAdapter : PagedListAdapter<Reminder, ReminderViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ReminderViewHolder(parent)

    override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
        getItem(position)?.let { holder.bindTo(it) }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Reminder>() {
            override fun areItemsTheSame(oldItem: Reminder, newItem: Reminder): Boolean =
                oldItem.id == newItem.id

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: Reminder, newItem: Reminder): Boolean =
                oldItem == newItem
        }
    }
}