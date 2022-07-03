package com.example.yml.presentation.features.mytop

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.yml.databinding.FragmentMyTopBinding
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class MyTopFragment:BaseFragment<MyTopViewModel,FragmentMyTopBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMyTopBinding
        get() = FragmentMyTopBinding::inflate

    override fun provideViewModel(): MyTopViewModel  = getViewModelFromFactory()
}