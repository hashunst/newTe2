package com.example.newte2

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService: Service() {
    val alarm = Alarm()

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        alarm.setAlarm(this)
        return START_STICKY // super.onStartCommand(intent, flags, startId)
    }

    override fun onStart(intent: Intent?, startId: Int) {
        alarm.setAlarm(this)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}
