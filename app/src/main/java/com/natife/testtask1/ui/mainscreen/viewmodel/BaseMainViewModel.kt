package com.natife.testtask1.ui.mainscreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natife.testtask1.ui.mainscreen.interactor.MainInteractor
import com.natife.testtask1.ui.mainscreen.reducer.MainRecuder

/**
 *@author admin
 */

abstract class BaseMainViewModel<Intent, State>(
    private val reducer: MainRecuder<Intent, State>
) : ViewModel() {

    private val mutableState = MutableLiveData(reducer.initialState)
    val state: LiveData<State> = mutableState

    fun send(intent: Intent, interactor: MainInteractor<Intent, State>) {
        mutableState.value = reducer.reduce(intent, mutableState.value!!)
        val resultIntent = interactor(intent, mutableState.value!!)
        mutableState.value = reducer.reduce(resultIntent, mutableState.value!!)
    }

}
