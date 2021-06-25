package com.natife.testtask1.ui.descriptionscreen.viewmodel

import com.natife.testtask1.base.BaseViewModel
import com.natife.testtask1.ui.descriptionscreen.DescriptionIntent
import com.natife.testtask1.ui.descriptionscreen.DescriptionState
import com.natife.testtask1.ui.descriptionscreen.interactor.GetItemByIdInteractor
import com.natife.testtask1.ui.descriptionscreen.reducer.DescriptionReducerImpl

class DescriptionViewModel(
    private val descInteractor: GetItemByIdInteractor,
    private val itemId: Int
) : BaseViewModel<DescriptionIntent, DescriptionState>(
    reducer = DescriptionReducerImpl()
) {

    fun fetchItems() {
        send(DescriptionIntent.LoadItem(itemId), descInteractor)
    }
}
