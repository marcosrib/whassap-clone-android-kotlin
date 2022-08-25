package com.example.whatsappclone.domain.usecases

import android.util.Log
import com.example.whatsappclone.data.model.User
import com.example.whatsappclone.data.repositories.UserRepository
import com.example.whatsappclone.domain.usecases.model.UserResponse
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*
import kotlin.Exception


class UserUseCaseImpl(private val userRepository: UserRepository) : UserUseCase {

    override fun createUser(user: User, callback: (userResponse: UserResponse) -> Unit) {
        userRepository.createUser(user)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback.invoke(UserResponse(true, ""))
                }
            }.addOnFailureListener {
                val errorMessage = validatedErrors(it)
                callback.invoke(UserResponse(false, errorMessage))
            }
    }


    fun validatedErrors(exception: Exception): String {
        return try {
            throw  exception
        } catch (e: FirebaseAuthWeakPasswordException) {
            return "Digite uma senha mais forte!"
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            return "Digite um emails válido!"
        } catch (e: FirebaseAuthEmailException) {
            return "Conta já existe!"
        } catch (e: FirebaseAuthUserCollisionException) {
            return "Essa conta já foi cadastrada!"
        } catch (e: Exception) {
            return "Erro ao cadastrar usuário" + e.localizedMessage
        }
    }
}