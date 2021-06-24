package com.natife.testtask1.ui.descriptionscreen.viewmodel

import com.natife.testtask1.ui.descriptionscreen.DescriptionIntent
import com.natife.testtask1.ui.descriptionscreen.DescriptionState
import com.natife.testtask1.ui.descriptionscreen.interactor.DescriptionInteractorImpl
import com.natife.testtask1.ui.descriptionscreen.reducer.DescriptionReducerImpl

/**
 *@author admin
 */
class DescriptionViewModel(
    private val descInteractor: DescriptionInteractorImpl,
    private val itemId: Int
) : BaseDescriptionViewModel<DescriptionIntent, DescriptionState>(
    reducer = DescriptionReducerImpl(itemId)
) {

    fun fetchItems() {
        send(DescriptionIntent(isLoading = true, itemId = itemId, item = null), descInteractor)
    }

}

