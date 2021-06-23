package com.natife.testtask1.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

/**
 *@author admin
 */
class TestFragment : Fragment() {

    private lateinit var viewModel: TestViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) {
            handleState(it)
        }
        viewModel.fetchItems()
    }

    private fun handleState(newState: TestState) {
        when(newState) {
            TestState.Idle -> {}
            TestState.Loading -> { //handleLoad
             }
            is TestState.Data -> {
                //display data
            }
        }
    }

}
