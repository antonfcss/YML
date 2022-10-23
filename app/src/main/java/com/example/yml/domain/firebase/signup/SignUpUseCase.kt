package com.example.yml.domain.firebase.signup

import com.example.yml.data.firebase.signup.SignUpRepositoryImpl
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val signUpRepository: SignUpRepositoryImpl) {

    suspend fun signUpUser(signUpUserModel: SignUpUserModel): Flow<Task<AuthResult>> =
        signUpRepository.signUpNewUser(signUpUserModel)
}