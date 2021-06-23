package com.natife.testtask1.test

/**
 *@author admin
 */
class TestViewModel(
    private val testInteractor: TestInteractor
) : BaseViewModel<TestIntent, TestState>(
    reducer = TestReducer()
) {

    fun fetchItems() {
        send(TestIntent.Load, testInteractor)
    }

}
