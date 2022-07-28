package com.example.yml.presentation.features.about

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
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

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,backPressedCallback)
        val film = arguments?.get("popularFilm") as PopularFilmModel
        with(binding) {
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
            floatingActionButton.setOnClickListener {
                viewModel.addToDB(film)
            }
            /*    floatingActionButton.setOnLongClickListener {
                    Toast.makeText(requireContext(), "test", Toast.LENGTH_LONG).show()
                    return@setOnLongClickListener true
                }

             */
            buttonMovieWatch.setOnClickListener {
                navigateTo(com.example.yml.R.id.playTrailerDialog, bundleOf(Pair("trailerUrl", film.url)))
            }
        }
    }

    private fun validateFeesWorldwideValue(fees: Long): String {
        return if (fees == 0L) {
            getString(com.example.yml.R.string.error_fees)
        } else {
            getString(com.example.yml.R.string.fees_worldwide, fees)
        }
    }
    private val backPressedCallback by lazy {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
    }
}

