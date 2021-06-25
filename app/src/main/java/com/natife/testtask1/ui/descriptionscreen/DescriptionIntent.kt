package com.natife.testtask1.ui.descriptionscreen

import com.natife.testtask1.data.Item

sealed class DescriptionIntent {

    data class FetchItem(val item: Item?, val itemId: Int) : DescriptionIntent()
}
//sealed class MainIntent {
//    object Nothing : MainIntent()
//    object Load : MainIntent()
//
//    data class DataLoaded(val items: List<Item>) : MainIntent()
//    data class SaveId(val id: Int) : MainIntent()
//
//}
