package com.natife.testtask1.test

import com.natife.testtask1.data.Item

/**
 *@author admin
 */
sealed class TestState {
    object Idle : TestState()
    object Loading : TestState()
    data class Data(val items: List<Item>) : TestState()
}
