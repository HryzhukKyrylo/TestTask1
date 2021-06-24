package com.natife.testtask1.ui.mainscreen

import com.natife.testtask1.data.Item

/**
 *@author admin
 */
sealed class MainIntent {
    object Nothing : MainIntent()
    object Load : MainIntent()
    data class DataLoaded(val items: List<Item>) : MainIntent()
}
