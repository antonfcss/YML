package com.example.yml.presentation.features.about

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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
        Log.d("asdfg", film.toString())
//        Toast.makeText(requireContext(), film.name, Toast.LENGTH_LONG).show()
        with(binding) {
            posterMovie.setImageBitmap(film.poster)
            title.text = film.name
            releaseDate.text = getString(R.string.release_date, film.year)
            ratingImdb.text = getString(R.string.rating_imdb, film.imdb)
            ratingKp.text = getString(R.string.rating_kp, film.kp)
            shortDescriptions.text = film.description
            movieCountry.text = getString(R.string.country, film.country)
            movieGenre.text = getString(R.string.movie_genre, film.genre)
//            feesWorldwide.text = getString(R.string.fees_worldwide, film.value)
            floatingActionButton.setOnClickListener {
                navigateTo(R.id.action_aboutMovieFragment_to_blankFragment)
            }
            buttonMovieWatch.setOnClickListener {
                navigateTo(R.id.playTrailerDialog, bundleOf(Pair("trailerUrl", film.url)))
            }
        }
    }
}

