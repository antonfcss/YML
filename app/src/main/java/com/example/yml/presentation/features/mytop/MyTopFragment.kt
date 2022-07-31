package com.example.yml.presentation.features.mytop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yml.R
import com.example.yml.databinding.FragmentMyTopBinding
import com.example.yml.domain.popular.PopularFilmModel
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory
import com.example.yml.presentation.features.about.AboutMovieFragment
import com.example.yml.presentation.features.mytop.recycler.MyTopAdapter

class MyTopFragment : BaseFragment<MyTopViewModel, FragmentMyTopBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMyTopBinding
        get() = FragmentMyTopBinding::inflate

    private val adapter by lazy { MyTopAdapter() }

    override fun provideViewModel(): MyTopViewModel = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.onItemClick = {
            val bundle = Bundle()
            bundle.putSerializable(AboutMovieFragment.POPULAR_FILM_TAG, it)
            navigateTo(R.id.aboutMovieFragment, bundle)
        }
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerMyTop.layoutManager = layoutManager
        binding.recyclerMyTop.adapter = adapter
        viewModel.getMovieLiveData().observe(viewLifecycleOwner, ::addMovie)
        viewModel.loadMoviesListToLog()
    }

    //Т.к. в MovieViewModel testStringLiveData обсёрвит лист наших моделек List<PopularFilmModel
    //Чтобы наша подписка работала нужно чтобы функция принимала  лист моделек List<PopularFilmModel.
    // Должны быть одинаковые данные, что viewModel возвращает, то функция должна принмать
    private fun addMovie(popularFilmModel: List<PopularFilmModel>) {
        adapter.movies = popularFilmModel
    }
}