package com.example.yml.presentation.features.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yml.databinding.FragmentSigUpBinding
import com.example.yml.presentation.base.BaseFragment
import com.example.yml.presentation.base.getViewModelFromFactory

class SignUpFragment : BaseFragment<SignUpViewModel, FragmentSigUpBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSigUpBinding
        get() = FragmentSigUpBinding::inflate

    override fun provideViewModel(): SignUpViewModel = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createButton.setOnClickListener {
            val emailText = binding.emailEditText.text?.toString()
            val passwordText = binding.passwordSignUpEditText.text?.toString()
            viewModel.getSignUpUser(emailText.toString(), passwordText.toString())
                .observe(viewLifecycleOwner) {

                }

        }

    }
}