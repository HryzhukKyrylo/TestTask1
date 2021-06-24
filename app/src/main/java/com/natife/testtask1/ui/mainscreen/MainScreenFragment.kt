package com.natife.testtask1.ui.mainscreen

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.testtask1.R
import com.natife.testtask1.databinding.FragmentMainScreenBinding
import com.natife.testtask1.ui.mainscreen.adapter.CustomRecyclerAdapter
import com.natife.testtask1.ui.mainscreen.interactor.MainInteractorImpl
import com.natife.testtask1.ui.mainscreen.viewmodel.MainViewModel
import com.natife.testtask1.ui.mainscreen.viewmodel.MainViewModelFactory
import com.natife.testtask1.utils.Const
import com.natife.testtask1.utils.PreferenceHelper

class MainScreenFragment : Fragment(), CustomRecyclerAdapter.OnItemClickListener {

    private lateinit var preferences: SharedPreferences
    private lateinit var binding: FragmentMainScreenBinding
    private val adapter: CustomRecyclerAdapter by lazy { CustomRecyclerAdapter(this) }

    private val interactorImpl = MainInteractorImpl()
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        viewModelFactory = MainViewModelFactory(interactorImpl)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        preferences = PreferenceHelper.customPreference(requireContext(), Const.CUSTOM_PREF_NAME)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()

        viewModel.state.observe(viewLifecycleOwner) {
            handleState(it)
        }

        viewModel.fetchItems()
    }

    private fun handleState(newState: MainState) {
        when (newState) {
            MainState.Nothing -> Toast.makeText(requireContext(), "Nothing", Toast.LENGTH_SHORT)
                .show()
            MainState.Loading -> Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT)
                .show()
//            MainState ->
            is MainState.Data -> adapter.submitList(newState.items)
        }
    }


    private fun initRecycler() {
        binding.recyclerItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerItems.adapter = adapter
    }

    override fun onItemClicked(id: Int) {
        viewModel.saveId(id,preferences)

        val bundle = bundleOf(Const.BUNDLE_VAL to id)
        findNavController().navigate(R.id.navigateToDescriptionScreen, bundle)
    }
}
