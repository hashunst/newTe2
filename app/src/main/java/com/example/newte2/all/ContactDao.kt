package com.example.newte2.all

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {
    /**
     * Room knows how to return a LivePagedListProvider, from which we can get a LiveData and serve
     * it back to UI via ViewModel.
     */
    @Query("SELECT * FROM Contact")
    fun all(): DataSource.Factory<Int, Contact>

    @Insert
    fun insert(contacts: List<Contact>)

    @Insert
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)

    @Query("Delete from Contact")
    fun deleteAll()
}