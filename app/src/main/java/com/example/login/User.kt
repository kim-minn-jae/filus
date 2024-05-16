package com.example.login

data class User(
    val name: String,
    val email: String,
    val uid: String
){
    constructor(): this("", "", "")
}
