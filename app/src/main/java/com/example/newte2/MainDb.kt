package com.example.newte2

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.newte2.all.*
import com.example.newte2.models_examples.ioThread

@Database(
    entities = [
        Contact::class,
        Reminder::class,
        Category::class,
        Log::class
    ],
    version = 1)
abstract class MainDb: RoomDatabase() {

    abstract fun contantDao(): ContactDao
    abstract fun reminderDao(): ReminderDao
    abstract fun categoryDao(): CategoryDao
    abstract fun logDao(): LogDao

    companion object {
        private var instance: MainDb? = null
        @Synchronized
        fun get(context: Context): MainDb {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    MainDb::class.java, "CheeseDatabase")
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            fillInDb(context.applicationContext)
                        }
                    }).build()
            }
            return instance!!
        }

        /**
         * fill database with list of cheeses
         */
        private fun fillInDb(context: Context) {
            // inserts in Room are executed on the current thread, so we insert in the background
            ioThread {
//                get(context).contantDao().insert(
//                    CHEESE_DATA.map { Contact(id = 0, "null", -1) })
            }
        }
    }
}
