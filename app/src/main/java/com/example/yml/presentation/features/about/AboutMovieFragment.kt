package com.example.yml.presentation.features.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.yml.R
import com.example.yml.databinding.FragmentAboutMovieBinding
import com.example.yml.domain.popular.PopularFilmModel
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class AboutMovieFragment : BaseFragment<AboutMovieViewModel, FragmentAboutMovieBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAboutMovieBinding
        get() = FragmentAboutMovieBinding::inflate

    override fun provideViewModel(): AboutMovieViewModel = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val film = arguments?.get("popularFilm") as PopularFilmModel
        Toast.makeText(requireContext(), film.name, Toast.LENGTH_LONG).show()
        with(binding) {
            posterMovie.setImageBitmap(film.poster)
            posterMovie.setImageBitmap(film.poster)
            title.text = film.name
            releaseDate.text = getString(R.string.release_date, film.year)
            ratingImdb.text = getString(R.string.rating_imdb, film.imdb)
            ratingKp.text = getString(R.string.rating_kp, film.kp)
            shortDescriptions.text = film.description
            floatingActionButton.setOnClickListener {
                navigateTo(R.id.action_aboutMovieFragment_to_blankFragment)
            }
            buttonMovieWatch.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "В разработке из-за Coroutines",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
//        viewModel.getTestLiveData().observe(viewLifecycleOwner, ::addURLtoLog)
//        viewModel.getData()
//        viewModel.getTestLiveData().observe(viewLifecycleOwner, ::testFun)
    }
//
//    private fun addURLtoLog(url: String) {
//    }
//
//    private fun testFun(testString: String) {
//    }
}

