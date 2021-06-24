package com.natife.testtask1.ui.mainscreen

import com.natife.testtask1.data.Item

sealed class MainState {
    object Nothing : MainState()
    object Loading : MainState()
    data class Data(val items: List<Item>) : MainState()
}
