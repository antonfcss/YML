package com.example.yml.presentation.features.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
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

        val film = arguments?.get(POPULAR_FILM_TAG) as PopularFilmModel
        with(binding) {
            viewModel.isFilmIsPopular(film)
            posterMovie.setImageBitmap(film.poster)
            title.text = film.name
            title.requestFocus()
            releaseDate.text = getString(com.example.yml.R.string.release_date, film.year)
            ratingImdb.text = getString(com.example.yml.R.string.rating_imdb, film.imdb)
            ratingKp.text = getString(com.example.yml.R.string.rating_kp, film.kp)
            shortDescriptions.text = film.description
            movieCountry.text = getString(com.example.yml.R.string.country, film.country)
            movieGenre.text = getString(com.example.yml.R.string.movie_genre, film.genre)
            feesWorldwide.text = validateFeesWorldwideValue(film.feesValue)
            buttonMovieWatch.setOnClickListener {
                navigateTo(
                    com.example.yml.R.id.playTrailerDialog, bundleOf(Pair("trailerUrl", film.url))
                )
            }
            viewModel.getIsFilmInMyTopLiveData().observe(viewLifecycleOwner) {
                isAddButtonVisible(it)
                if (it) {
                    floatingActionButtonDelete.setOnClickListener { view ->
                        isAddButtonVisible(it)
                        viewModel.deleteFromDB(film)
                    }
                } else {
                    floatingActionButton.setOnClickListener { view ->
                        isAddButtonVisible(it.not())
                        viewModel.addToDB(film)
                    }
                }
            }
        }
    }

    private fun isAddButtonVisible(boolean: Boolean) {
        with(binding) {
            floatingActionButton.isVisible = boolean.not()
            floatingActionButtonDelete.isVisible = boolean
        }
    }

    private fun validateFeesWorldwideValue(fees: Long): String {
        return if (fees == 0L) {
            getString(com.example.yml.R.string.error_fees)
        } else {
            getString(com.example.yml.R.string.fees_worldwide, fees)
        }
    }

    companion object {
        const val POPULAR_FILM_TAG = "popularFilm"
    }
}

