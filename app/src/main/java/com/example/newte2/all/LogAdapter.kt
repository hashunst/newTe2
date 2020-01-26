package com.example.newte2.all;

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

class LogAdapter : PagedListAdapter<Log, LogViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LogViewHolder(parent)

    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
        getItem(position)?.let { holder.bindTo(it) }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Log>() {
            override fun areItemsTheSame(oldItem: Log, newItem: Log): Boolean =
                oldItem.id == newItem.id

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: Log, newItem: Log): Boolean =
                oldItem == newItem
        }
    }
}