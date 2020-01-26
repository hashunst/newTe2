package com.example.newte2.all

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newte2.R
import kotlinx.android.synthetic.main.item_simple_linear_contact.view.*

class ContactViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_simple_linear_contact, parent, false)) {

    var contact: Contact? = null
    var idContact = itemView.findViewById<TextView>(R.id.id_c)
    var reminderContact = itemView.findViewById<TextView>(R.id.reminder_c)
    var contactIdContact = itemView.findViewById<TextView>(R.id.contact_id_c)

    fun bind(contact: Contact){
        this.contact = contact
        idContact.text = contact.id.toString()
        reminderContact.text = contact.reminder_id.toString()
        contactIdContact.text = contact.contant_id


    }

    fun remove(
        adapter: ContactAdapterSimple,
        contacts: ArrayList<Contact>,
        position: Int
    ) {
        itemView.delete.setOnClickListener {
            contacts.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }

}
