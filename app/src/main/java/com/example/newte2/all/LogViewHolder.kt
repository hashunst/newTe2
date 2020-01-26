package com.example.newte2.all

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newte2.R

class LogViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_simple_linear_reminder, parent, false)
) {

    var log: Log? = null
    var example = itemView.findViewById<TextView>(R.id.id_c)

    fun bindTo(log: Log) {
        this.log = log
        example.text = log.id.toString()

    }

}
