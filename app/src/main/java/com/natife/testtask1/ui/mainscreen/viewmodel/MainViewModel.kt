package com.natife.testtask1.ui.mainscreen.viewmodel

import android.content.SharedPreferences
import com.natife.testtask1.ui.mainscreen.MainIntent
import com.natife.testtask1.ui.mainscreen.MainState
import com.natife.testtask1.ui.mainscreen.interactor.MainInteractorImpl
import com.natife.testtask1.ui.mainscreen.reducer.MainReducerImpl

class MainViewModel(
    private val testInteractor: MainInteractorImpl
) : BaseMainViewModel<MainIntent, MainState>(
    reducer = MainReducerImpl()
) {

    fun fetchItems() {
        send(MainIntent.Load, testInteractor)
    }

    fun saveId(id: Int, preferences: SharedPreferences) {
        save(MainIntent.Save, testInteractor, id, preferences)
    }
}
