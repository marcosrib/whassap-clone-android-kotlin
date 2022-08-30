package com.example.whatsappclone.domain.usecases

import android.util.Log
import com.example.whatsappclone.data.firebase.Connection
import com.example.whatsappclone.data.model.User
import com.example.whatsappclone.data.repositories.UserRepository
import com.example.whatsappclone.domain.usecases.model.UserResponse
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlin.Exception


class UserUseCaseImpl(private val userRepository: UserRepository) : UserUseCase {
    private val TAG = this::class.java.simpleName

    override suspend fun createUser(user: User): UserResponse {

        Log.e(TAG, "criando usuário" + user.email)
        return try {
            userRepository.createUser(user)
                .await()
            return UserResponse(true, "")
        } catch (e: Exception) {
            Log.e(TAG, validatedErrors(e))
            return UserResponse(false, validatedErrors(e))
        }

    }


    fun validatedErrors(exception: Exception): String {
        return when (exception) {
            is FirebaseAuthWeakPasswordException -> "Digite uma senha mais forte!"
            is FirebaseAuthInvalidCredentialsException -> "Digite um emails válido!"
            is FirebaseAuthEmailException -> "Conta já existe!"
            is FirebaseAuthUserCollisionException -> "Essa conta já foi cadastrada!"
            else -> "Erro ao cadastrar usuário" + exception.localizedMessage
        }
    }
}