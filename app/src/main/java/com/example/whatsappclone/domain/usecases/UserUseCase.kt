package com.example.whatsappclone.domain.usecases

import com.example.whatsappclone.data.model.User
import com.example.whatsappclone.domain.usecases.model.UserResponse

interface UserUseCase {
    fun createUser(user: User, callback: (userResponse: UserResponse) -> Unit )
}