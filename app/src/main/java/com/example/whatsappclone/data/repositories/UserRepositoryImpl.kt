package com.example.whatsappclone.data.repositories

import android.util.Log
import com.example.whatsappclone.data.firebase.Connection
import com.example.whatsappclone.data.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

class UserRepositoryImpl : UserRepository {
    override suspend fun createUser(user: User): Task<AuthResult> {
        val auth = Connection.firebaseAuth()
            return auth.createUserWithEmailAndPassword(user.email, user.password)
    }

    override suspend fun auth(user: User): Task<AuthResult> {
        val connection = Connection.firebaseAuth()
        return  connection.signInWithEmailAndPassword(user.email, user.password)
    }

    override suspend fun isAuth(): FirebaseUser? {
        val auth = Connection.firebaseAuth()
        return auth.currentUser
    }

}