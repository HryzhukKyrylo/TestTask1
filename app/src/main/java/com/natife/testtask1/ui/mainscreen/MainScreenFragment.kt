package com.natife.testtask1.ui.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.testtask1.R
import com.natife.testtask1.data.Item
import com.natife.testtask1.databinding.FragmentMainScreenBinding
import com.natife.testtask1.ui.mainscreen.adapter.CustomRecyclerAdapter


class MainScreenFragment : Fragment(), CustomRecyclerAdapter.OnItemClickListener {

    private lateinit var binding: FragmentMainScreenBinding
    private val adapter: CustomRecyclerAdapter by lazy { CustomRecyclerAdapter() }
    private var listItems = mutableListOf<Item>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)
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
        for (i in 0..19) {
            listItems.add(
                Item(
                    id = i,
                    name = "name$i",
                    description = "description$i"
                )
            )
        }
    }

    private fun init() {

        binding.recyclerItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerItems.adapter = adapter
        adapter.initListener(this)
    }

    override fun onItemClicked(item: Item) {
        var bundle = bundleOf("item" to item)
        findNavController().navigate(R.id.navigateToDescriptionScreen, bundle)
    }


}
