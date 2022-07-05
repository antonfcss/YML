package com.example.yml.presentation.features.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yml.App
import com.example.yml.databinding.FragmentPopularBinding
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory
import com.example.yml.presentation.features.popular.recycler.MoviesAdapter

class PopularFragment : BaseFragment<PopularViewModel, FragmentPopularBinding>() {

    private lateinit var adapter: MoviesAdapter


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPopularBinding
        get() = FragmentPopularBinding::inflate

    override fun provideViewModel(): PopularViewModel = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MoviesAdapter()

        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter
    }

}