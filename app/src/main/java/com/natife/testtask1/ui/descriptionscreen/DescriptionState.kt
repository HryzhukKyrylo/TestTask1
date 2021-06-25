package com.natife.testtask1.ui.descriptionscreen

import com.natife.testtask1.data.Item

data class DescriptionState(
    val isLoading: Boolean,
    val itemId: Int,
    val item: Item?
)
