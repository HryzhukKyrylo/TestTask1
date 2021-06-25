package com.natife.testtask1.ui.descriptionscreen.reducer

import com.natife.testtask1.ui.descriptionscreen.DescriptionIntent
import com.natife.testtask1.ui.descriptionscreen.DescriptionState
import com.natife.testtask1.utils.ItemHolder

class DescriptionReducerImpl(private val itemId: Int) :
    DescriptionReducer<DescriptionIntent, DescriptionState> {

    override val initialState = DescriptionState(
        isLoading = false,
        itemId = itemId,
        item = null
    )

    override fun reduce(intent: DescriptionIntent, state: DescriptionState): DescriptionState {
        return when (intent.isLoading){
            true -> {
                val item = ItemHolder.items.firstOrNull { it.id == intent.itemId }

                state.copy(isLoading = true, itemId = itemId, item = item)
            }
            else -> {
                state
            }
        }
    }
}
