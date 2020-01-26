package com.example.newte2.all;

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDao {
    /**
     * Room knows how to return a LivePagedListProvider, from which we can get a LiveData and serve
     * it back to UI via ViewModel.
     */
    @Query("SELECT * FROM Category")
    fun all(): DataSource.Factory<Int, Category>

    @Insert
    fun insert(categorys: List<Category>)

    @Insert
    fun insert(category: Category)

    @Delete
    fun delete(category: Category)

    @Query("Delete from Category")
    fun deleteAll()
}