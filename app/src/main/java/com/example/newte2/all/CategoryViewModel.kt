package com.example.newte2.all

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.newte2.MainDb
import com.example.newte2.models_examples.ioThread

class CategoryViewModel(app: Application) : AndroidViewModel(app) {
    val dao = MainDb.get(app).categoryDao()

    val all = dao.all().toLiveData(Config(pageSize = 30, enablePlaceholders = true, maxSize = 300))

    fun insert(category: Category) = ioThread {
        dao.insert(category)
    }

    fun insert(categorys: List<Category>) = ioThread {
        dao.insert(categorys)
    }

    fun remove(category: Category) = ioThread {
        dao.delete(category)
    }

    fun removeAll() = ioThread {
        dao.deleteAll()
    }


}