package com.natife.testtask1.ui.descriptionscreen.reducer

import com.natife.testtask1.base.BaseReducer
import com.natife.testtask1.ui.descriptionscreen.DescriptionIntent
import com.natife.testtask1.ui.descriptionscreen.DescriptionState

class DescriptionReducerImpl :
    BaseReducer<DescriptionIntent, DescriptionState> {

    override val initialState : DescriptionState = DescriptionState.Nothing

    override fun reduce(intent: DescriptionIntent, state: DescriptionState): DescriptionState {
        return when(intent){
            is DescriptionIntent.LoadItem -> DescriptionState.Loading
            is DescriptionIntent.FetchItem -> DescriptionState.DataItem(item = intent.item)
        }
    }
}
