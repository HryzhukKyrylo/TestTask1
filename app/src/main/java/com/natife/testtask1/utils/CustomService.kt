package com.natife.testtask1.utils

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.natife.testtask1.MainActivity
import com.natife.testtask1.R
import com.natife.testtask1.ui.mainscreen.MainScreenFragment

class CustomService : Service() {
    val NOTIFICATION_ID = 888
    val CHANNEL_ID = "natification"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()

        val pendingIntent: PendingIntent =
            Intent("com.natife.testtask1.utils.ITEM_CLICKED").let { notificationIntent ->
                notificationIntent.setPackage("com.natife.testtask1")
                PendingIntent.getBroadcast(
                    this,
                    0,
                    notificationIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT
                )
            }

        val notification: Notification = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle(getText(R.string.notification_title))
            .setContentText(getText(R.string.notification_message))
            .setShowWhen(false)
            .setSmallIcon(R.drawable.ic_natification)
            .setContentIntent(pendingIntent)
            .setTicker(getText(R.string.ticker_text))
            .build()

        startForeground(NOTIFICATION_ID, notification)
        return START_NOT_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}