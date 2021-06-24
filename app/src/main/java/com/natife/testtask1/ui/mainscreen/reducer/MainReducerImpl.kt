package com.natife.testtask1.ui.mainscreen.reducer

import android.content.SharedPreferences
import com.natife.testtask1.ui.mainscreen.MainIntent
import com.natife.testtask1.ui.mainscreen.MainState
import com.natife.testtask1.utils.PreferenceHelper.id

/**
 *@author admin
 */
class MainReducerImpl : MainRecuder<MainIntent, MainState> {
    override val initialState: MainState = MainState.Nothing

    override fun reduce(intent: MainIntent, state: MainState ): MainState {
        return when (intent) {
            MainIntent.Load -> MainState.Loading
            is MainIntent.SaveId -> {
                MainState.Nothing
            }
            is MainIntent.DataLoaded -> MainState.Data(intent.items)
            else -> state
        }
    }

}
