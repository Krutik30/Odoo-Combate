package com.example.oohclient.model

data class UserRegisterLoginModel(
    var userId: String?,
    val name: String?,
    val email: String?,
    val userRole: String?,
    val password: String?,
    val confirmPassword: String?
)
