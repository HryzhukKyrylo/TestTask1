package com.natife.testtask1.test

/**
 *@author admin
 */
class TestReducer : Reducer<TestIntent, TestState> {
    override val initialState: TestState = TestState.Idle

    override fun reduce(intent: TestIntent, state: TestState): TestState {
        return when(intent) {
            TestIntent.Idle -> state
            TestIntent.Load -> TestState.Loading
            is TestIntent.DataLoaded -> TestState.Data(intent.items)
        }
    }
}
