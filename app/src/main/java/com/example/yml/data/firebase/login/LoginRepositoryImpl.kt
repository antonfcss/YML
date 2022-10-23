package com.example.yml.data.firebase.login

import com.example.yml.domain.firebase.login.LoginRepository
import com.example.yml.domain.firebase.login.LoginUserModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor() : LoginRepository {
    override fun authUser(loginUserModel: LoginUserModel) = flow {
        emit(
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(loginUserModel.email, loginUserModel.password)
        )
    }
}