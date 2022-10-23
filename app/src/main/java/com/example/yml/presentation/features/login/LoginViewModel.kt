package com.example.yml.presentation.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yml.domain.firebase.login.LoginUseCase
import com.example.yml.domain.firebase.login.LoginUserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun authUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loginUseCase.authUser(LoginUserModel(email = email, password = password))
                .catch { error -> }
        }
    }
}