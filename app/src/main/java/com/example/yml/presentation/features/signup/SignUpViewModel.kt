package com.example.yml.presentation.features.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.firebase.signup.SignUpUseCase
import com.example.yml.domain.firebase.signup.SignUpUserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    private val isSignUpUser = MutableLiveData<Boolean>()
    fun getSignUpUser(toString: String, toString1: String) = isSignUpUser

    fun signupUser(
        email: String,
        password: String,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            if (email.isNotBlank() && password.isNotBlank()) {
                signUpUseCase.signUpUser(SignUpUserModel(email = email, password = password))
                    .catch { error -> Log.d("SignUpViewModel", error.toString()) }
                    .collect { firebaseRegister ->
                        firebaseRegister.addOnCompleteListener { authResult ->
                            isSignUpUser.value = authResult.isSuccessful
                        }
                    }
            }
        }
    }
}