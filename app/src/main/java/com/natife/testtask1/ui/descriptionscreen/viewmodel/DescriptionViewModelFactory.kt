package com.natife.testtask1.ui.descriptionscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.testtask1.ui.descriptionscreen.interactor.GetItemByIdInteractor

class DescriptionViewModelFactory(
    private val descrInteractor: GetItemByIdInteractor,
    private val itemId: Int
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DescriptionViewModel::class.java)) {
            return DescriptionViewModel(descrInteractor, itemId) as T
        }
        throw IllegalArgumentException("Unknown DescriptionViewModel class")
    }
}
