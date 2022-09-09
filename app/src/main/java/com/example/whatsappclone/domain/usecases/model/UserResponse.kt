package com.example.whatsappclone.domain.usecases.model

data class UserResponse(
    var isCreated: Boolean,
    var isLogged: Boolean,
    var isErrorMessage: String
)
