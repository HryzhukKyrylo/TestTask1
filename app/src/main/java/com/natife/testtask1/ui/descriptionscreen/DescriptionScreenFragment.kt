package com.natife.testtask1.ui.descriptionscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.natife.testtask1.data.Item
import com.natife.testtask1.databinding.FragmentDescriptionScreenBinding

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
        val item = arguments?.getParcelable<Item>("item")
        binding.textId.text = item?.id.toString()
        binding.textName.text = item?.name
        binding.textDescription.text = item?.description
    }

}
