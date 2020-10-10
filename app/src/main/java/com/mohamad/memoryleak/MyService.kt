package com.mohamad.memoryleak

import android.app.Service
import android.content.Intent
import android.os.IBinder
import leakcanary.AppWatcher

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onDestroy() {
        super.onDestroy()
        AppWatcher.objectWatcher.watch(
            watchedObject = this,
            description = "MyService received Service#onDestroy() callback"
        )
    }
}
