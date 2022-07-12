package com.example.yml.presentation.features.popular

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.yml.R
import com.example.yml.databinding.FragmentPopularBinding
import com.example.yml.domain.popular.PopularFilmModel
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory
import com.example.yml.presentation.features.popular.recycler.MoviesAdapter

class PopularFragment : BaseFragment<PopularViewModel, FragmentPopularBinding>() {
    // by lazy стандартный делегат, который сам создаст MoviesAdapter при первом его вызове
    private val adapter by lazy { MoviesAdapter() }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPopularBinding
        get() = FragmentPopularBinding::inflate

    override fun provideViewModel(): PopularViewModel = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.onItemClick = {
            val bundle = Bundle()
            bundle.putSerializable("popularFilm", it)
            navigateTo(R.id.aboutMovieFragment, bundle)
        }
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter

        viewModel.getMovieLiveData().observe(viewLifecycleOwner, ::addRecycler)
        viewModel.getData()

    }

    private fun addRecycler(movieModel: List<PopularFilmModel>) {
        movieModel.forEach {
            Log.d("dsadsa", it.toString())
        }
        adapter.movies = movieModel
    }

}