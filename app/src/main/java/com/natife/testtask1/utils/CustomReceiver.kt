package com.natife.testtask1.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.natife.testtask1.MainActivity
import com.natife.testtask1.utils.PreferenceHelper.id

//"com.natife.testtask1.utils.ITEM_CLICKED"
class CustomReceiver : BroadcastReceiver() {

    private lateinit var preferences: SharedPreferences

    override fun onReceive(context: Context?, intent: Intent?) {
        preferences = PreferenceHelper.customPreference(context!!, Const.CUSTOM_PREF_NAME)

        val intent =
            Intent(context, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra(Const.RECEIVE_VAL, preferences.id)
        context.startActivity(intent)
    }
}