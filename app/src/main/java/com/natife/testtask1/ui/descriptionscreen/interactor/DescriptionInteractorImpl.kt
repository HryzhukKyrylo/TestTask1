package com.natife.testtask1.ui.descriptionscreen.interactor

import com.natife.testtask1.ui.descriptionscreen.DescriptionIntent
import com.natife.testtask1.ui.descriptionscreen.DescriptionState
import com.natife.testtask1.utils.ItemHolder

class DescriptionInteractorImpl : DescriptionInteractor<DescriptionIntent, DescriptionState> {
    override fun invoke(intent: DescriptionIntent, state: DescriptionState): DescriptionIntent {
        return if (intent.isLoading) {
            intent.copy(isLoading = false, itemId = intent.itemId, item = null)
        } else {
            intent
        }
    }
}
