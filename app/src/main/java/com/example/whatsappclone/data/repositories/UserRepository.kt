package com.example.whatsappclone.data.repositories

import com.example.whatsappclone.data.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

interface UserRepository {
    suspend  fun createUser(user: User) : Task<AuthResult>
    suspend  fun auth(user: User) : Task<AuthResult>
    suspend  fun isAuth() : FirebaseUser?

}