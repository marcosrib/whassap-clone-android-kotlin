package com.example.whatsappclone.presenter.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.whatsappclone.data.model.User
import com.example.whatsappclone.data.repositories.UserRepository
import com.example.whatsappclone.data.repositories.UserRepositoryImpl
import com.example.whatsappclone.databinding.ActivityRegistrationBinding
import com.example.whatsappclone.domain.usecases.UserUseCase
import com.example.whatsappclone.domain.usecases.UserUseCaseImpl
import com.example.whatsappclone.presenter.viewmodels.CreateUserViewModel
import com.example.whatsappclone.presenter.viewmodels.providers.CreateUserFactory

class RegistrationActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityRegistrationBinding
    lateinit var  viewModel: CreateUserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel =
            ViewModelProvider(this, CreateUserFactory(UserUseCaseImpl(UserRepositoryImpl()))).get(
                CreateUserViewModel::class.java
            )
        viewModel.userLiveData.observe(this, Observer{
            Log.e("ACTIVITY", it.isErrorMessage)
            if(!it.isCreated)
              Toast.makeText(this@RegistrationActivity,it.isErrorMessage,  Toast.LENGTH_SHORT).show()

        })
    }

     fun registration(view: View) {

        viewModel.createUser(User(
                "",
                "marco@gmail.com",
                      "1234567890"
            )
            )


    }
}