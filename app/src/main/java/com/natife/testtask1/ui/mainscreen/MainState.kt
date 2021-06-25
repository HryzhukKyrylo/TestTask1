package com.natife.testtask1.ui.mainscreen

import com.natife.testtask1.data.Item

sealed class MainState {
    object Nothing : MainState()
    object Loading : MainState()

    data class Data(val items: List<Item>) : MainState()
    data class Id(val id: Int) : MainState()
}
//data class DescriptionState(val isLoading: Boolean, val itemId: Int, val item: Item?)

/*class Reducer(itemId: Int) {
    override val initialState = DescriptionState(
    isloading = false,
    itemId = itemId,
    item = null)

    fun reduce(aslfjndflkg) {
        when(intent){
        is Loaded -> state.copy(isLoading = false, item = intent.item)
    }
}
 */

/*
class Interactor {
    fun invoke(intent: Intent, state: DescriptionState): Intent {
        if(intent is Load) {
            state.itemId
        } else {
        }
    }
}

 */
