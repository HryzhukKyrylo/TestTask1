package com.natife.testtask1.test

/**
 *@author admin
 */
interface Reducer<Intent, State> {

    val initialState: State
    fun reduce(intent: Intent, state: State): State

}
