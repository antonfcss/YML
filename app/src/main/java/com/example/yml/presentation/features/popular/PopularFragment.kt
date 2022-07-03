package com.example.yml.presentation.features.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.yml.databinding.FragmentPopularBinding
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class PopularFragment: BaseFragment<PopularViewModel, FragmentPopularBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPopularBinding
        get() = FragmentPopularBinding::inflate

    override fun provideViewModel(): PopularViewModel = getViewModelFromFactory()
}