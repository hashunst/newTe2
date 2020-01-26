package com.example.newte2.viewmodels


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.newte2.MainDb
import com.example.newte2.all.Reminder
import com.example.newte2.all.ReminderWithContacts
import com.example.newte2.models_examples.ioThread

class DetailReminderViewModel(app: Application) : AndroidViewModel(app) {
    val dao = MainDb.get(app).reminderDao()

    var id = MutableLiveData<Int>()

    val reminderWithContacts = Transformations.switchMap(id){dao.byId(it)}

    val reminder = Transformations.map(reminderWithContacts){it.reminder}
    val contacts = Transformations.map(reminderWithContacts){it.contacts}

    fun remove(reminder: Reminder) = ioThread {
        dao.delete(reminder)
    }



}