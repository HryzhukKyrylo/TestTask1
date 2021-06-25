package com.natife.testtask1.ui.mainscreen.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.testtask1.ui.mainscreen.interactor.FetchItemsInteractorImpl
import com.natife.testtask1.ui.mainscreen.interactor.SaveInteractorImpl

class MainViewModelFactory(private val preferences: SharedPreferences) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(FetchItemsInteractorImpl(), SaveInteractorImpl(preferences)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
