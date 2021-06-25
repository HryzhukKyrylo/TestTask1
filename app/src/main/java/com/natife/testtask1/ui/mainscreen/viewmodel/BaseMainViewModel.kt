package com.natife.testtask1.ui.mainscreen.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natife.testtask1.ui.mainscreen.interactor.MainInteractor
import com.natife.testtask1.ui.mainscreen.reducer.MainRecuder

abstract class BaseMainViewModel<Intent, State>(
    private val reducer: MainRecuder<Intent, State>
) : ViewModel() {

    private val mutableState = MutableLiveData(reducer.initialState)
    val state: LiveData<State> = mutableState

    fun send(intent: Intent, interactor: MainInteractor<Intent, State>) {
        mutableState.value = reducer.reduce(intent, mutableState.value!!)
        val resultIntent = interactor.invoke(intent, mutableState.value!!)
        mutableState.value = reducer.reduce(resultIntent, mutableState.value!!)

    }

    fun save(
        intent: Intent,
        interactor: MainInteractor<Intent, State>,
        id: Int,
        preferences: SharedPreferences
    ) {
        mutableState.value = reducer.reduce(intent, mutableState.value!!)
        val resultIntent = interactor.saveId(intent, mutableState.value!!, id, preferences)
        mutableState.value = reducer.reduce(resultIntent, mutableState.value!!)
    }
}
