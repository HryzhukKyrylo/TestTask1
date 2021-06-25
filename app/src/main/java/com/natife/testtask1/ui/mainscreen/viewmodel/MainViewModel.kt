package com.natife.testtask1.ui.mainscreen.viewmodel

import com.natife.testtask1.base.BaseViewModel
import com.natife.testtask1.ui.mainscreen.MainIntent
import com.natife.testtask1.ui.mainscreen.MainState
import com.natife.testtask1.ui.mainscreen.interactor.FetchItemsInteractorImpl
import com.natife.testtask1.ui.mainscreen.interactor.SaveInteractorImpl
import com.natife.testtask1.ui.mainscreen.reducer.MainReducerImpl

class MainViewModel(
    private val testInteractor: FetchItemsInteractorImpl,
    private val saveInteractor: SaveInteractorImpl
) : BaseViewModel<MainIntent, MainState>(
    reducer = MainReducerImpl()
) {

    fun fetchItems() {
        send(MainIntent.Load, testInteractor)
    }

    fun saveId(id: Int) {
        send(MainIntent.SaveId(id), saveInteractor)
    }


}
