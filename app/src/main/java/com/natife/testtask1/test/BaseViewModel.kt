package com.natife.testtask1.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *@author admin
 */
abstract class BaseViewModel<Intent, State>(
    private val reducer: Reducer<Intent, State>
) : ViewModel() {

    private val mutableState = MutableLiveData(reducer.initialState)
    val state: LiveData<State> = mutableState

    fun send(intent: Intent, interactor: Interactor<Intent, State>) {
        mutableState.value = reducer.reduce(intent, mutableState.value!!)
        val resultIntent = interactor(intent, mutableState.value!!)
        mutableState.value = reducer.reduce(resultIntent, mutableState.value!!)
    }

}
