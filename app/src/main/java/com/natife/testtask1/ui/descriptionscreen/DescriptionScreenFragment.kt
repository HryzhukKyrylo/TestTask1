package com.natife.testtask1.ui.descriptionscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.natife.testtask1.databinding.FragmentDescriptionScreenBinding
import com.natife.testtask1.utils.Const
import com.natife.testtask1.utils.ItemHolder

class DescriptionScreenFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idArg = arguments?.getInt(Const.BUNDLE_VAL)

        val item = ItemHolder.items.firstOrNull { it.id == idArg }
        if (item != null) {
            binding.textId.text = item.id.toString()
            binding.textName.text = item.name
            binding.textDescription.text = item.description
        } else {
            findNavController().popBackStack()
        }
    }
}