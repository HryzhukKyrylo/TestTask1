package com.natife.testtask1.ui.descriptionscreen.reducer

import com.natife.testtask1.ui.descriptionscreen.DescriptionState

/**
 *@author admin
 */
interface DescriptionReducer<Intent, State> {

    val initialState: State
    fun reduce(intent: Intent, state: State): State

}
