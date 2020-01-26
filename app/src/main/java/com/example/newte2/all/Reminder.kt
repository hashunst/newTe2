package com.example.newte2.all


import androidx.room.*

@Entity
data class Reminder(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var title:String,
    var des:String,
    var color:String,
    var olavial:Int,
    var remindType:String,
    var remindNumbers:Int,
    var randomShift:Int,
    var witchDayOfWeek:String,
    var startTime:Int,
    var endTime:Int,
    var imageUri:String,
    var category:Int,
    var favorited:Int
    ) {
    constructor() : this(0, "", "", "", -1, "", -1, -1, "", -1, -1, "", -1, -1) {

    }
}