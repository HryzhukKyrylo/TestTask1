package com.natife.testtask1.ui.mainscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.testtask1.ui.mainscreen.interactor.MainInteractorImpl

class MainViewModelFactory(private val mainInteractor: MainInteractorImpl) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(mainInteractor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
