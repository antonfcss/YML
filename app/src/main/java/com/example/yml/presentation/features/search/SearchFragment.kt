package com.example.yml.presentation.features.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.yml.databinding.FragmentSearchBinding
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun provideViewModel(): SearchViewModel = getViewModelFromFactory()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            private var searchFor = ""

            override fun onQueryTextSubmit(p0: String?): Boolean {
                val searchText = p0.toString()
                if (searchText == searchFor) {
                    return
                }
                searchFor = searchText
                viewModel.searchForMovie(searchText)

            }

            override fun onQueryTextChange(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
    }
}