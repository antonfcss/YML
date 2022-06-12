package com.example.yml.presentation.features.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yml.databinding.FragmentSearchBinding
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun provideViewModel(): SearchViewModel = getViewModelFromFactory()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Если хотим обратиться к биндингу
        binding.root
        //Если хотим обратиться к viewModel
        viewModel
    }
}