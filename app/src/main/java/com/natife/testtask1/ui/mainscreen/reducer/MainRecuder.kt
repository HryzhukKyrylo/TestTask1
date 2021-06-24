package com.natife.testtask1.ui.mainscreen.reducer

import android.content.SharedPreferences


interface MainRecuder<Intent, State> {
    val initialState: State
    fun reduce(intent: Intent, state: State): State
}
