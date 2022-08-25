package com.example.whatsappclone.data.repositories

import android.util.Log
import com.example.whatsappclone.data.firebase.Connection
import com.example.whatsappclone.data.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class UserRepositoryImpl : UserRepository {
    override fun createUser(user: User): Task<AuthResult> {
        val auth = Connection.firebaseAuth()
            return auth.createUserWithEmailAndPassword(user.email, user.password)
    }

}