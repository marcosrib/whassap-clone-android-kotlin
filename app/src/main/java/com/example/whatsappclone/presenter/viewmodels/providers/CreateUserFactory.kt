package com.example.whatsappclone.presenter.viewmodels.providers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatsappclone.domain.usecases.UserUseCase
import com.example.whatsappclone.presenter.viewmodels.CreateUserViewModel

class CreateUserFactory constructor(private val userUseCase: UserUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CreateUserViewModel::class.java)) {
            CreateUserViewModel(this.userUseCase) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}