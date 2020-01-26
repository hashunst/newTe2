package com.example.newte2.all;

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LogDao {
    /**
     * Room knows how to return a LivePagedListProvider, from which we can get a LiveData and serve
     * it back to UI via ViewModel.
     */
    @Query("SELECT * FROM Log")
    fun all(): DataSource.Factory<Int, Log>

    @Insert
    fun insert(logs: List<Log>)

    @Insert
    fun insert(log: Log)

    @Delete
    fun delete(log: Log)

    @Query("Delete from Log")
    fun deleteAll()
}