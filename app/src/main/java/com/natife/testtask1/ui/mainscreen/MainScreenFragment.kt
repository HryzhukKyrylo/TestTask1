package com.natife.testtask1.ui.mainscreen

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.testtask1.R
import com.natife.testtask1.data.Item
import com.natife.testtask1.databinding.FragmentMainScreenBinding
import com.natife.testtask1.ui.mainscreen.adapter.CustomRecyclerAdapter
import com.natife.testtask1.utils.Const
import com.natife.testtask1.utils.ItemHolder
import com.natife.testtask1.utils.PreferenceHelper
import com.natife.testtask1.utils.PreferenceHelper.id


class MainScreenFragment : Fragment(), CustomRecyclerAdapter.OnItemClickListener {

    private lateinit var preferences: SharedPreferences
    private lateinit var binding: FragmentMainScreenBinding
    private val adapter: CustomRecyclerAdapter by lazy { CustomRecyclerAdapter() }
    private var listItems = mutableListOf<Item>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        preferences = PreferenceHelper.customPreference(requireContext(),Const.CUSTOM_PREF_NAME)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        generateItems()
        updateListRecycler()
    }

    private fun updateListRecycler() {
        adapter.updateList(listItems)
    }

    private fun generateItems() {
        listItems.addAll(ItemHolder.items)
    }

    private fun init() {
        binding.recyclerItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerItems.adapter = adapter
        adapter.initListener(this)
    }

    override fun onItemClicked(id: Int) {
        preferences.id = id

        val bundle = bundleOf(Const.BUNDLE_VAL to id)
        findNavController().navigate(R.id.navigateToDescriptionScreen, bundle)
    }

}


