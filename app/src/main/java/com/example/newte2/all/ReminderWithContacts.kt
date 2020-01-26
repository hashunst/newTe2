package com.example.newte2.all

import androidx.room.Embedded
import androidx.room.Relation

data class ReminderWithContacts(

    @Embedded
    var reminder:Reminder? = null,

    @Relation(parentColumn = "id", entityColumn = "reminder_id")
var contacts:List<Contact> = ArrayList()
) {

}
