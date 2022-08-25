package com.example.whatsappclone.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

object Connection {
    private  var  firebaseAuth : FirebaseAuth? = null
    private lateinit var  firebaseDatabase: FirebaseDatabase
    fun firebaseAuth() : FirebaseAuth{
      if (firebaseAuth == null) {
          firebaseAuth = FirebaseAuth.getInstance()
      }
        return firebaseAuth as FirebaseAuth
    }
    fun firebaseDatabase() : FirebaseDatabase {
          if(firebaseDatabase == null) {
              firebaseDatabase = FirebaseDatabase.getInstance()
          }
        return firebaseDatabase
    }

}