package com.natife.testtask1.ui.descriptionscreen.interactor

import com.natife.testtask1.base.BaseInteractor
import com.natife.testtask1.ui.descriptionscreen.DescriptionIntent
import com.natife.testtask1.ui.descriptionscreen.DescriptionState
import com.natife.testtask1.utils.ItemHolder

class GetItemByIdInteractor : BaseInteractor<DescriptionIntent, DescriptionState> {
    override fun invoke(intent: DescriptionIntent, state: DescriptionState): DescriptionIntent {
        return when (intent) {
            is DescriptionIntent.FetchItem -> {
                val foundItem = ItemHolder.items.firstOrNull { it.id == intent.itemId }
                DescriptionIntent.FetchItem(item = foundItem, itemId = intent.itemId)
            }
            else -> intent
        }
    }
}
