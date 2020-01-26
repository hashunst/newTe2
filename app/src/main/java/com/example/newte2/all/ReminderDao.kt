package com.example.newte2.all


import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

@Dao
interface ReminderDao {
    /**
     * Room knows how to return a LivePagedListProvider, from which we can get a LiveData and serve
     * it back to UI via ViewModel.
     */
    @Query("SELECT * FROM Reminder")
    fun all(): DataSource.Factory<Int, Reminder>

    @Transaction
    @Query("SELECT * FROM Reminder")
    fun allWithContacts(): DataSource.Factory<Int, ReminderWithContacts>

    @Insert
    fun insert(reminders: List<Reminder>)

//    @Insert
//    fun insert(reminder: Reminder)

    @Insert
    fun insert(reminder: Reminder):Long

    @Delete
    fun delete(reminder: Reminder)

    @Query("Delete from Reminder")
    fun deleteAll()

    @Transaction
    @Query("SELECT * FROM Reminder where id = :id")
    fun byId(id: Int): LiveData<ReminderWithContacts>
}