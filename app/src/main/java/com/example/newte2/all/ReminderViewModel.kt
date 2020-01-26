package com.example.newte2.all


import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.newte2.MainDb
import com.example.newte2.models_examples.ioThread
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext

class ReminderViewModel(app: Application) : AndroidViewModel(app) {
    val dao = MainDb.get(app).reminderDao()
    val insertedDb = MutableLiveData<Long>()

    val all = dao.all().toLiveData(Config(pageSize = 30, enablePlaceholders = true, maxSize = 300))
    val allWithContacts = dao.allWithContacts().toLiveData(Config(pageSize = 30, enablePlaceholders = true, maxSize = 300))
//    val allWithContacts = dao.allWithContacts()


    fun insertUpdateId(activity:Activity, reminder: Reminder) = ioThread {
        val id = dao.insert(reminder)
        activity.runOnUiThread {
            insertedDb.value = id
        }
    }

    fun insert(reminder: Reminder) = ioThread {
        dao.insert(reminder)
    }


    fun insert(reminders: List<Reminder>) = ioThread {
        dao.insert(reminders)
    }

    fun remove(reminder: Reminder) = ioThread {
        dao.delete(reminder)
    }

    fun removeAll() = ioThread {
        dao.deleteAll()
    }


}