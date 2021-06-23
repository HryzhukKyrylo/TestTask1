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
import com.natife.testtask1.mvp.model.Item
import com.natife.testtask1.databinding.FragmentMainScreenBinding
import com.natife.testtask1.mvp.presenters.MainPresenter
import com.natife.testtask1.mvp.views.MainView
import com.natife.testtask1.ui.mainscreen.adapter.CustomRecyclerAdapter
import com.natife.testtask1.utils.Const
import com.natife.testtask1.utils.PreferenceHelper
import com.natife.testtask1.utils.PreferenceHelper.id

class MainScreenFragment : Fragment(), CustomRecyclerAdapter.OnItemClickListener, MainView {

    private lateinit var preferences: SharedPreferences
    private lateinit var binding: FragmentMainScreenBinding
    private val adapter: CustomRecyclerAdapter by lazy { CustomRecyclerAdapter(this) }

    private val presenter: MainPresenter by lazy { MainPresenter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        preferences = PreferenceHelper.customPreference(requireContext(), Const.CUSTOM_PREF_NAME)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        presenter.attach(this)
        binding.recyclerItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerItems.adapter = adapter
        presenter.requestList()
    }

    override fun onItemClicked(id: Int) {
        preferences.id = id
        presenter.saveId(preferences, id)

        val bundle = bundleOf(Const.BUNDLE_VAL to id)
        findNavController().navigate(R.id.navigateToDescriptionScreen, bundle)
    }

    override fun showList(list: List<Item>) {
        adapter.submitList(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}
