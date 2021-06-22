package com.natife.testtask1.utils

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {
    private const val ITEM_ID = "ID"

    fun customPreference(context: Context, name: String): SharedPreferences =
        context.getSharedPreferences(
            name, Context.MODE_PRIVATE
        )

    private inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.id
        get() = getInt(ITEM_ID, Const.DEFAULT_VAL)
        set(value) {
            editMe {
                it.putInt(ITEM_ID, value)
            }
        }
}