package com.example.yml.domain.firebase.login

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun authUser(loginUserModel: LoginUserModel): Flow<Task<AuthResult>>
}