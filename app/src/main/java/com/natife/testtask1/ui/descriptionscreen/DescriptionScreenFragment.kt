package com.natife.testtask1.ui.descriptionscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.natife.testtask1.databinding.FragmentDescriptionScreenBinding
import com.natife.testtask1.ui.descriptionscreen.descriptionviewmodel.DescriptionViewModel
import com.natife.testtask1.utils.Const

class DescriptionScreenFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionScreenBinding
    private val viewModel: DescriptionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt(Const.BUNDLE_VAL, Const.DEFAULT_VAL) ?: Const.DEFAULT_VAL

        if (id != Const.DEFAULT_VAL) {
            viewModel.setId(id)
        } else {
            findNavController().popBackStack()
        }

        initObserve()
    }

    private fun initObserve() {
        viewModel.item.observe(viewLifecycleOwner) { item ->
            binding.textId.text = item.id.toString()
            binding.textName.text = item.name
            binding.textDescription.text = item.description
        }
    }
}
