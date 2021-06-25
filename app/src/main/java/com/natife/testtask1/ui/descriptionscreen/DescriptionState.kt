package com.natife.testtask1.ui.descriptionscreen

import com.natife.testtask1.data.Item

sealed class DescriptionState {
    object Nothing : DescriptionState()
    object Loading : DescriptionState()
    data class DataItem(val item: Item?) : DescriptionState()
}
