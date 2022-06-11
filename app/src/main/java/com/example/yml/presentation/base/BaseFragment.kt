package com.example.yml.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : ViewModel, VB : ViewBinding> : DaggerFragment() {
    protected lateinit var viewModel: VM

    private var _binding: VB? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    protected val binding: VB
        get() = _binding as VB

    private val backPressedCallback by lazy {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,backPressedCallback)
        _binding = bindingInflater.invoke(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = provideViewModel()
    }

    abstract fun provideViewModel(): VM

    protected fun Fragment.navigateTo(destination: Int) {
        findNavController().navigate(destination)
    }

    protected fun Fragment.navigateTo(destination: Int, bundle: Bundle) {
        findNavController().navigate(destination, bundle)
    }
}

inline fun <F : BaseFragment<VM, *>, reified VM : ViewModel> F.getViewModelFromFactory(): VM {
    return ViewModelProvider(this, viewModelFactory).get(VM::class.java)
}