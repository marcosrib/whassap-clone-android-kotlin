package com.example.whatsappclone.domain.usecases

import com.example.whatsappclone.data.model.User
import com.example.whatsappclone.domain.usecases.model.UserResponse

interface UserUseCase {
    suspend fun createUser(user: User) : UserResponse
    suspend fun auth(user: User): UserResponse
    suspend fun isAuth(): UserResponse
}