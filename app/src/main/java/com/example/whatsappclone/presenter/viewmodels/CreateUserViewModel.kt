package com.example.whatsappclone.presenter.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whatsappclone.data.model.User
import com.example.whatsappclone.domain.usecases.UserUseCase
import com.example.whatsappclone.domain.usecases.model.UserResponse

class CreateUserViewModel constructor(private val userUseCase: UserUseCase) : ViewModel() {
     val userLiveData = MutableLiveData<UserResponse>()
    fun createUser(user: User) {
     userUseCase.createUser(user) {
         userLiveData.postValue(it)
     }

    }
}