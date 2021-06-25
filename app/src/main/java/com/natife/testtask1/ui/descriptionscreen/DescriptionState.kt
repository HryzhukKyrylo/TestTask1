package com.natife.testtask1.ui.descriptionscreen

import com.natife.testtask1.data.Item

sealed class DescriptionState {
    object Nothing : DescriptionState()
    data class DataItem(val item: Item?, val itemId : Int?) : DescriptionState()
}
