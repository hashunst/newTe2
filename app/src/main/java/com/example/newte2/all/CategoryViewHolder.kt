package com.example.newte2.all

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newte2.R

class CategoryViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_simple_linear_contact, parent, false)
) {

    var category: Category? = null
    var example = itemView.findViewById<TextView>(R.id.id_c)

    fun bindTo(category: Category) {
        this.category = category
        example.text = category.id.toString()

    }

}
