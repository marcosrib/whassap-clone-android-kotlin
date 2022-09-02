package com.example.whatsappclone.presenter.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsappclone.data.model.User
import com.example.whatsappclone.domain.usecases.UserUseCase
import com.example.whatsappclone.domain.usecases.model.UserResponse

import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch

class UserViewModel constructor(private val userUseCase: UserUseCase) : ViewModel() {
    val userLiveData = MutableLiveData<UserResponse>()
    fun createUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userLiveData.postValue(userUseCase.createUser(user))
        }
    }

    fun auth(user: User) {
        viewModelScope.launch {
            userLiveData.postValue(userUseCase.auth(user))
        }
    }
}