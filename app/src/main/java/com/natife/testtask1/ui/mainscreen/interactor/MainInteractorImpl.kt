package com.natife.testtask1.ui.mainscreen.interactor

import android.content.SharedPreferences
import com.natife.testtask1.ui.mainscreen.MainIntent
import com.natife.testtask1.ui.mainscreen.MainState
import com.natife.testtask1.utils.ItemHolder
import com.natife.testtask1.utils.PreferenceHelper.id

class MainInteractorImpl : MainInteractor<MainIntent, MainState> {

    override fun invoke(intent: MainIntent, state: MainState): MainIntent {
        return when(intent){
            is MainIntent.Load -> {
                val items = ItemHolder.items
            MainIntent.DataLoaded(items)
            }
            else -> MainIntent.Nothing
        }


//        return if (intent is MainIntent.Load) {
//            val items = ItemHolder.items
//            MainIntent.DataLoaded(items)
//        } else {
//            MainIntent.Nothing
//        }
    }

    override fun saveId(
        intent: MainIntent,
        state: MainState,
        id: Int,
        preferences: SharedPreferences
    ): MainIntent {
        return when(intent){
//            is MainIntent.Load -> {
//                val items = ItemHolder.items
//                MainIntent.DataLoaded(items)
//            }
            is MainIntent.Save -> {
                preferences.id = id
                MainIntent.SaveId(id)
            }
            else -> MainIntent.Nothing
        }    }

}
