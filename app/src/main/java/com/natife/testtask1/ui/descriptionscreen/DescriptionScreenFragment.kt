package com.natife.testtask1.ui.descriptionscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.natife.testtask1.data.Item
import com.natife.testtask1.databinding.FragmentDescriptionScreenBinding
import com.natife.testtask1.ui.descriptionscreen.interactor.DescriptionInteractorImpl
import com.natife.testtask1.ui.descriptionscreen.viewmodel.DescriptionViewModel
import com.natife.testtask1.ui.descriptionscreen.viewmodel.DescriptionViewModelFactory
import com.natife.testtask1.utils.Const

class DescriptionScreenFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionScreenBinding

    private val interactorImpl = DescriptionInteractorImpl()
    private lateinit var viewModel: DescriptionViewModel
    private lateinit var viewModelFactory: DescriptionViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionScreenBinding.inflate(inflater, container, false)

        val idArg = arguments?.getInt(Const.BUNDLE_VAL,Const.DEFAULT_VAL)
        if (idArg != null && idArg != Const.DEFAULT_VAL) {
            viewModelFactory = DescriptionViewModelFactory(
                interactorImpl,
                idArg
            )
            viewModel = ViewModelProvider(this, viewModelFactory).get(DescriptionViewModel::class.java)

        } else {
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      viewModel.state.observe(viewLifecycleOwner){
         handleState(it)
      }
        viewModel.fetchItems()

    }
    private fun handleState(state : DescriptionState){
        if(state.isLoading){
            initView(state.item!!)
        }
    }

    private fun initView(item : Item){
        binding.textId.text = item.id.toString()
        binding.textName.text = item.name
        binding.textDescription.text = item.description
    }
}
