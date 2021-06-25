package com.natife.testtask1.ui.mainscreen

import com.natife.testtask1.data.Item

sealed class MainIntent {
    object Nothing : MainIntent()
    object Load : MainIntent()
    object Save : MainIntent()

    data class DataLoaded(val items: List<Item>) : MainIntent()
    data class SaveId(val id: Int) : MainIntent()

}
