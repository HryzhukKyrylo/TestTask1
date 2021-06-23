package com.natife.testtask1.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object PreferenceHelper {
    private const val ITEM_ID = "ID"

    fun customPreference(context: Context, name: String): SharedPreferences =
        context.getSharedPreferences(
            name, Context.MODE_PRIVATE
        )

    var SharedPreferences.id
        get() = getInt(ITEM_ID, Const.DEFAULT_VAL)
        set(value) {
            edit {
                this.putInt(ITEM_ID, value)
            }
        }
}
