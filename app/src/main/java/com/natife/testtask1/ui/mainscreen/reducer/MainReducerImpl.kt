package com.natife.testtask1.ui.mainscreen.reducer

import com.natife.testtask1.ui.mainscreen.MainIntent
import com.natife.testtask1.ui.mainscreen.MainState

/**
 *@author admin
 */
class MainReducerImpl : MainRecuder<MainIntent, MainState> {
    override val initialState: MainState = MainState.Nothing

    override fun reduce(intent: MainIntent, state: MainState): MainState {
        return when(intent) {
            MainIntent.Nothing -> state
            MainIntent.Load -> MainState.Loading
            is MainIntent.DataLoaded -> MainState.Data(intent.items)
        }
    }
}
