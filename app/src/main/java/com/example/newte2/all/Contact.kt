package com.example.newte2.all

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(@PrimaryKey(autoGenerate = true) var id:Int,
                   var contant_id:String,
                   var reminder_id:Int)