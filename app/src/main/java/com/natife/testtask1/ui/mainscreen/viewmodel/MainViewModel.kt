package com.natife.testtask1.ui.mainscreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natife.testtask1.ui.mainscreen.MainIntent
import com.natife.testtask1.ui.mainscreen.MainState
import com.natife.testtask1.ui.mainscreen.interactor.MainInteractorImpl
import com.natife.testtask1.ui.mainscreen.reducer.MainReducerImpl

/**
 *@author admin
 */
class MainViewModel(
    private val testInteractor: MainInteractorImpl
) : BaseMainViewModel<MainIntent, MainState>(
    reducer = MainReducerImpl()
) {

    fun fetchItems() {
        send(MainIntent.Load, testInteractor)
    }

}

