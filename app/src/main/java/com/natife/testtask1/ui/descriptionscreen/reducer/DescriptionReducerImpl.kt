package com.natife.testtask1.ui.descriptionscreen.reducer

import com.natife.testtask1.base.BaseReducer
import com.natife.testtask1.ui.descriptionscreen.DescriptionIntent
import com.natife.testtask1.ui.descriptionscreen.DescriptionState

class DescriptionReducerImpl ( private val itemId: Int):
    BaseReducer<DescriptionIntent, DescriptionState> {

    override val initialState : DescriptionState = DescriptionState.Nothing

    override fun reduce(intent: DescriptionIntent, state: DescriptionState): DescriptionState {
        return when(intent){
            is DescriptionIntent.FetchItem -> DescriptionState.DataItem(intent.item, itemId)
            else -> state
        }
    }
}
