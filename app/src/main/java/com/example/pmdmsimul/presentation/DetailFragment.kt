package com.example.pmdmsimul.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.pmdmsimul.databinding.FragmentDetailItemBinding
import com.example.pmdmsimul.databinding.FragmentItemBinding
import com.example.pmdmsimul.domain.Item
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment:Fragment() {
    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ItemDetailViewModel by viewModel()
    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.loadItems(args.iditem)


    }
    fun setupObserver(){
        val itemObserve = Observer<ItemDetailViewModel.UiState> {
            it.item?.let{
                bindData(it)
            }

        }

        viewModel.uiState.observe(viewLifecycleOwner, itemObserve)
    }
    fun bindData(items:Item){
        binding.detailtext.text = items.surname


    }
}