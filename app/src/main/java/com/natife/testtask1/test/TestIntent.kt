package com.natife.testtask1.test

import com.natife.testtask1.data.Item

/**
 *@author admin
 */
sealed class TestIntent {
    object Idle : TestIntent()
    object Load : TestIntent()
    data class DataLoaded(val items: List<Item>) : TestIntent()
}
