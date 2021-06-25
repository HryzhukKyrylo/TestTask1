package com.natife.testtask1.ui.mainscreen.reducer

import com.natife.testtask1.base.BaseReducer
import com.natife.testtask1.ui.mainscreen.MainIntent
import com.natife.testtask1.ui.mainscreen.MainState

class MainReducerImpl : BaseReducer<MainIntent, MainState> {
    override val initialState: MainState = MainState.Nothing

    override fun reduce(intent: MainIntent, state: MainState): MainState {
        return when (intent) {
            MainIntent.Load -> MainState.Loading
            is MainIntent.SaveId -> {
                MainState.Id(id = intent.id)
            }
            is MainIntent.DataLoaded -> MainState.Data(intent.items)
            else -> state
        }
    }
}
