package com.natife.testtask1.ui.descriptionscreen

import com.natife.testtask1.data.Item

sealed class DescriptionIntent {

    data class FetchItem(val item: Item?) : DescriptionIntent()
    data class LoadItem(val itemId: Int) : DescriptionIntent()
}
