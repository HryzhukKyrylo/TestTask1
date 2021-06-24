package com.natife.testtask1.ui.mainscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.testtask1.ui.mainscreen.interactor.MainInteractorImpl

/**
 *@author admin
 */
class MainViewModelFactory(private val testInteractor: MainInteractorImpl) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(testInteractor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
