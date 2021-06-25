package com.natife.testtask1.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<Intent, State>(
    private val reducer: BaseReducer<Intent, State>
) : ViewModel() {

    private val mutableState = MutableLiveData(reducer.initialState)
    val state: LiveData<State> = mutableState

    fun send(intent: Intent, interactor: BaseInteractor<Intent, State>) {
        mutableState.value = reducer.reduce(intent, mutableState.value!!)
        val resultIntent = interactor.invoke(intent, mutableState.value!!)
        mutableState.value = reducer.reduce(resultIntent, mutableState.value!!)

    }

}
