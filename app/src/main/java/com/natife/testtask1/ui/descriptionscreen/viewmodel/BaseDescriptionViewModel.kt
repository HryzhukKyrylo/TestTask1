package com.natife.testtask1.ui.descriptionscreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natife.testtask1.ui.descriptionscreen.interactor.DescriptionInteractor
import com.natife.testtask1.ui.descriptionscreen.reducer.DescriptionReducer

/**
 *@author admin
 */
abstract class BaseDescriptionViewModel<Intent, State>(
    private val reducer: DescriptionReducer<Intent, State>
) : ViewModel() {

    private val mutableState = MutableLiveData(reducer.initialState)
    val state: LiveData<State> = mutableState

    fun send(intent: Intent, interactor: DescriptionInteractor<Intent, State>) {
        mutableState.value = reducer.reduce(intent, mutableState.value!!)
        val resultIntent = interactor(intent, mutableState.value!!)
        mutableState.value = reducer.reduce(resultIntent, mutableState.value!!)
    }

}
