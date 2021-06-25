package com.natife.testtask1.ui.descriptionscreen.reducer

interface DescriptionReducer<Intent, State> {

    val initialState: State
    fun reduce(intent: Intent, state: State): State

}
