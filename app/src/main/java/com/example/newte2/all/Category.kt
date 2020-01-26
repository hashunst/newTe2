package com.example.newte2.all;

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(@PrimaryKey(autoGenerate = true) var id: Int,
                    var title: String,
                    var des: String)