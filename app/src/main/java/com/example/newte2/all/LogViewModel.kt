package com.example.newte2.all

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.newte2.MainDb
import com.example.newte2.models_examples.ioThread

class LogViewModel(app: Application) : AndroidViewModel(app) {
    val dao = MainDb.get(app).logDao()

    val all = dao.all().toLiveData(Config(pageSize = 30, enablePlaceholders = true, maxSize = 300))

    fun insert(log: Log) = ioThread {
        dao.insert(log)
    }

    fun insert(logs: List<Log>) = ioThread {
        dao.insert(logs)
    }

    fun remove(log: Log) = ioThread {
        dao.delete(log)
    }

    fun removeAll() = ioThread {
        dao.deleteAll()
    }


}