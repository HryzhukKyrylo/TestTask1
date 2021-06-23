package com.natife.testtask1.test

import com.natife.testtask1.utils.ItemHolder

/**
 *@author admin
 */
class TestInteractor : Interactor<TestIntent, TestState> {

    override fun invoke(intent: TestIntent, state: TestState): TestIntent {
        return if (intent is TestIntent.Load) {
            val items = ItemHolder.items
            TestIntent.DataLoaded(items)
        } else {
            TestIntent.Idle
        }
    }

}
