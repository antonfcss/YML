package com.example.yml.presentation.features.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yml.databinding.FragmentMovieBinding
import com.example.yml.domain.movie.MovieModel
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class MovieFragment : BaseFragment<MovieViewModel, FragmentMovieBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMovieBinding
        get() = FragmentMovieBinding::inflate

    override fun provideViewModel(): MovieViewModel = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Подписка на лайф дату. ::addMovieToLog - ссылка на функцию fun addMovieToLog
        viewModel.getMovieLiveData().observe(viewLifecycleOwner, ::addMovieToLog)
        binding.addRandomMovie.setOnClickListener {
            viewModel.addRandomMovieToDB()
        }
        binding.getAllMovies.setOnClickListener {
            viewModel.loadMoviesListToLog()
        }
    }
    //Т.к. в MovieViewModel testStringLiveData обсёрвит лист наших моделек List<MovieModel
    //Чтобы наша подписка работала нужно чтобы функция принимала  лист моделек List<MovieModel.
    // Должны быть одинаковые данные, что viewModel возвращает, то функция должна принмать
    private fun addMovieToLog(movieModel: List<MovieModel>) {
        Log.d("movieModelInLogs", movieModel.toString())
    }

}