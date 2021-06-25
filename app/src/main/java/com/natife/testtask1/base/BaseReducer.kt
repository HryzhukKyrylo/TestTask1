package com.natife.testtask1.base

interface BaseReducer<Intent, State> {

    val initialState: State
    fun reduce(intent: Intent, state: State): State

}
