package com.uvg.freetofeel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.uvg.freetofeel.data.model.UserLoginState
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.uvg.freetofeel.data.network.SupabaseClient
import com.uvg.freetofeel.utils.SharedPreferencesHelper
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.launch

class SupabaseAuthViewModel:ViewModel() {
    private val _userLoginState = mutableStateOf<UserLoginState>(UserLoginState.Loading)
    val userState: State<UserLoginState> = _userLoginState

    fun signUp(
        context: Context,
        userEmail: String,
        userPassword: String
    ) {
        viewModelScope.launch {
            _userLoginState.value = UserLoginState.Loading
            try {
                val response = SupabaseClient.client.gotrue.signUpWith(Email) {
                    email = userEmail
                    password = userPassword
                }
                if (response != null) {
                    saveToken(context)
                    _userLoginState.value = UserLoginState.Success("Registered user successfully")
                }
            } catch (e: Exception) {
                _userLoginState.value = UserLoginState.Error("Sign up error: ${e.localizedMessage}")
                Log.e("SupabaseAuth", "Sign up failed: ${e.localizedMessage}", e)
            }
        }
    }


    private fun saveToken(context: Context){
        viewModelScope.launch {
            val accessToken= SupabaseClient.client.gotrue.currentAccessTokenOrNull()
            val sharedPref = SharedPreferencesHelper(context)
            sharedPref.saveStringData("accessToken",accessToken)
        }
    }

    private fun getToken(context: Context):String?{
        val sharedPref = SharedPreferencesHelper(context)
        return sharedPref.getStringData("accessToken")
    }

    fun login(
        context: Context,
        userEmail:String,
        userPassword:String
    ){
        viewModelScope.launch {
            _userLoginState.value = UserLoginState.Loading

            try {
                SupabaseClient.client.gotrue.loginWith(Email) {
                    email=userEmail
                    password=userPassword
                }
                saveToken(context)
                _userLoginState.value = UserLoginState.Success("Login successfully")
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("Login error on: ${e.message}")

            }
        }
    }

    fun logout(context: Context){
        val sharedPreferencesHelper = SharedPreferencesHelper(context)
        viewModelScope.launch {
            _userLoginState.value = UserLoginState.Loading

            try {
                SupabaseClient.client.gotrue.logout()
                val sharedPreferencesHelper = SharedPreferencesHelper(context)
                sharedPreferencesHelper.clearPreferences()
                _userLoginState.value = UserLoginState.Loading
                isUserLoggedIn(context)
            } catch (e: Exception) {
                _userLoginState.value = UserLoginState.Error("Logout error: ${e.message}")
            }
        }
    }


    fun isUserLoggedIn(
        context: Context
    ){
        viewModelScope.launch {
            try {
                val token = getToken(context)
                if(token.isNullOrEmpty()){
                    _userLoginState.value = UserLoginState.Error("User is not logged in")
                }
                else{
                    SupabaseClient.client.gotrue.retrieveUser(token)
                    SupabaseClient.client.gotrue.refreshCurrentSession()
                    saveToken(context)
                    _userLoginState.value=UserLoginState.Success("User is already logged in")
                }
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("CheckLogin error in: ${e.message}")

            }
        }
    }
}