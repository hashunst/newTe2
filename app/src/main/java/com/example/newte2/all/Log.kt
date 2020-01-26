package com.example.newte2.all;

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Log(@PrimaryKey(autoGenerate = true) var id: Int,
               var title: String,
               var des: String,
               var date:Int,
               var reminder_id:Int
)