package com.example.yml.presentation.features.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.yml.databinding.FragmentLoginBinding
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding
        get() = FragmentLoginBinding::inflate

    override fun provideViewModel(): LoginViewModel = getViewModelFromFactory()


}