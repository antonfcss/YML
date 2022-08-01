package com.example.yml.presentation.features.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yml.R
import com.example.yml.databinding.FragmentSearchBinding
import com.example.yml.domain.popular.PopularFilmModel
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory
import com.example.yml.presentation.features.about.AboutMovieFragment
import com.example.yml.presentation.features.search.recycler.SearchAdapter

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>() {

    private val adapter by lazy { SearchAdapter() }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun provideViewModel(): SearchViewModel = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.onItemClick = {
            val bundle = Bundle()
            bundle.putSerializable(AboutMovieFragment.POPULAR_FILM_TAG, it)
            navigateTo(R.id.aboutMovieFragment, bundle)
        }
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSearch.layoutManager = layoutManager
        binding.recyclerViewSearch.adapter = adapter

        viewModel.getMovieSearchLiveData().observe(viewLifecycleOwner, ::addRecycler)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                viewModel.searchForMovie(p0.toString())
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewModel.searchForMovie(p0.toString())
                return true
            }

        })
    }

    private fun addRecycler(movieModel: List<PopularFilmModel>) {
        movieModel.forEach {
            Log.d("dsadsa", it.toString())
        }
        adapter.movies = movieModel
    }
}