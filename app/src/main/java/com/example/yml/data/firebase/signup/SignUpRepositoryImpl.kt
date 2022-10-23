package com.example.yml.data.firebase.signup

import com.example.yml.domain.firebase.signup.SignUpUserModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor() {

    suspend fun signUpNewUser(signUpUserModel: SignUpUserModel): Flow<Task<AuthResult>> =
        flow {
            emit(
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(
                        signUpUserModel.email,
                        signUpUserModel.password
                    )
            )
        }
}