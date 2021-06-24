package com.natife.testtask1.ui.mainscreen.interactor

import com.natife.testtask1.ui.mainscreen.MainIntent
import com.natife.testtask1.ui.mainscreen.MainState
import com.natife.testtask1.utils.ItemHolder

/**
 *@author admin
 */
class MainInteractorImpl : MainInteractor<MainIntent, MainState> {

    override fun invoke(intent: MainIntent, state: MainState): MainIntent {
        return if (intent is MainIntent.Load) {
            val items = ItemHolder.items
            MainIntent.DataLoaded(items)
        } else {
            MainIntent.Nothing
        }
    }

}
