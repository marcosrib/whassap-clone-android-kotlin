package com.example.whatsappclone.data.repositories

import com.example.whatsappclone.data.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface UserRepository {
    suspend  fun createUser(user: User) : Task<AuthResult>

}