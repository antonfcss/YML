package com.example.yml.presentation.features.mytop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yml.databinding.FragmentMyTopBinding
import com.example.yml.domain.popular.PopularFilmModel
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class MyTopFragment : BaseFragment<MyTopViewModel, FragmentMyTopBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMyTopBinding
        get() = FragmentMyTopBinding::inflate

    override fun provideViewModel(): MyTopViewModel = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovieLiveData().observe(viewLifecycleOwner, ::addMovieToLog)
        viewModel.loadMoviesListToLog()

    }
    //Т.к. в MovieViewModel testStringLiveData обсёрвит лист наших моделек List<PopularFilmModel
    //Чтобы наша подписка работала нужно чтобы функция принимала  лист моделек List<PopularFilmModel.
    // Должны быть одинаковые данные, что viewModel возвращает, то функция должна принмать
    private fun addMovieToLog(popularFilmModel: List<PopularFilmModel>) {
        Log.d("movieModelInLogs", popularFilmModel.toString())
    }

}