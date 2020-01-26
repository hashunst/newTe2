package com.example.newte2.all

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.newte2.MainDb
import com.example.newte2.models_examples.ioThread

class ContactViewModel(app:Application):AndroidViewModel(app){
    val dao = MainDb.get(app).contantDao()

    val allContacts = dao.all().toLiveData(Config(pageSize = 30, enablePlaceholders = true, maxSize = 300))

    fun insert(contact: Contact) = ioThread {
        dao.insert(contact)
    }

    fun insert(contacts:List<Contact>) = ioThread {
        dao.insert(contacts)
    }

    fun remove(contact: Contact) = ioThread {
        dao.delete(contact)
    }

    fun removeAll() = ioThread {
        dao.deleteAll()
    }


}