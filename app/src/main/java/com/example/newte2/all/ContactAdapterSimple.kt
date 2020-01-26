package com.example.newte2.all

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ContactAdapterSimple:RecyclerView.Adapter<ContactViewHolder>() {
    var contacts:ArrayList<Contact> = arrayListOf()

    override fun getItemCount() = contacts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactViewHolder(parent)

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        contacts[position].let { holder.bind(it) }
        holder.remove(this, contacts, position)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Contact>() {
            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean =
                oldItem.id == newItem.id

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean =
                oldItem == newItem
        }
    }

    fun submit(contacts:ArrayList<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }

    fun add(contact: Contact) {
        this.contacts.add(contact)
        notifyDataSetChanged()
    }

    fun submit(contacts: List<Contact>) {
        this.contacts = arrayListOf()
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }
}