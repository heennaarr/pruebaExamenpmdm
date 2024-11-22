package com.example.pmdmsimul.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.pmdmsimul.databinding.FragmentItemBinding
import com.example.pmdmsimul.domain.Item
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemFragment :Fragment(){

    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ItemViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.loadItems()
        binding.apply {
            button1.setOnClickListener{
                it.findNavController().navigate(ItemFragmentDirections.actionItemFragmentToItemDetailFragment("1"))
            }
            button2.setOnClickListener{
                it.findNavController().navigate(ItemFragmentDirections.actionItemFragmentToSecondItemFragment())
            }
        }

    }
    fun setupObserver(){
        val itemObserve = Observer<ItemViewModel.UiState> {
            it.items?.let{
                bindData(it)
            }

        }

        viewModel.uiState.observe(viewLifecycleOwner, itemObserve)
    }
    fun bindData(items:List<Item>){
        binding.name.text = items[0].name


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}