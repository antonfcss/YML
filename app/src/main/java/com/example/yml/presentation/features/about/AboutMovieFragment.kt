package com.example.yml.presentation.features.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.yml.R
import com.example.yml.databinding.FragmentAboutMovieBinding
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class AboutMovieFragment : BaseFragment<AboutMovieViewModel, FragmentAboutMovieBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAboutMovieBinding
        get() = FragmentAboutMovieBinding::inflate

    override fun provideViewModel(): AboutMovieViewModel = getViewModelFromFactory()

    private fun testFun(testString: String) {
        Toast.makeText(requireContext(), testString, Toast.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            navigateTo(R.id.action_aboutMovieFragment_to_blankFragment)
        }
        viewModel.getTestLiveData().observe(viewLifecycleOwner, ::testFun)
        viewModel.test()
    }
}
