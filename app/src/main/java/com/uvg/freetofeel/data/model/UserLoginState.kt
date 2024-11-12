package com.uvg.freetofeel.data.model

sealed class UserLoginState {
    object Loading:UserLoginState()
    data class Success(val message:String):UserLoginState()
    data class Error(val message: String):UserLoginState()


}