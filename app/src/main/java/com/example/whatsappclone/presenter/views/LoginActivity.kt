package com.example.whatsappclone.presenter.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.whatsappclone.data.model.User
import com.example.whatsappclone.data.repositories.UserRepositoryImpl
import com.example.whatsappclone.databinding.ActivityLoginBinding
import com.example.whatsappclone.domain.usecases.UserUseCaseImpl
import com.example.whatsappclone.presenter.viewmodels.UserViewModel
import com.example.whatsappclone.presenter.viewmodels.providers.CreateUserFactory

class LoginActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityLoginBinding
    lateinit var  viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel =
            ViewModelProvider(this, CreateUserFactory(UserUseCaseImpl(UserRepositoryImpl()))).get(
                UserViewModel::class.java
            )
        viewModel.userLiveData.observe(this, Observer{
            Log.e("activity", "activity 1"   )
            if(!it.isCreated)
                Toast.makeText(this@LoginActivity,it.isErrorMessage,  Toast.LENGTH_SHORT).show()

        })
    }



    fun auth(view: View) {

        viewModel.auth(
            User(
            "",
            binding.authEmail.text.toString(),
            binding.authPassword.text.toString()
        )
        )
    }

    override fun onStart() {
        super.onStart()
        viewModel.isAuth()
        viewModel.userAuthenticatedLiveData.observe(this, Observer{
            Log.e("activity", "activity 1"   )
          if(it.isCreated) navScreenMain()

        })

    }


    fun navScreenRegistration(view: View) {
        val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
        startActivity(intent)
    }

    private fun navScreenMain() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }
}