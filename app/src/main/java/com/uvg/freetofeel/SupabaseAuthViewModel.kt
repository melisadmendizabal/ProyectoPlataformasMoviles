package com.uvg.freetofeel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.uvg.freetofeel.data.model.UserLoginState
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.uvg.freetofeel.data.model.PetStories
import com.uvg.freetofeel.data.model.UserData
import com.uvg.freetofeel.data.model.UserWritings
import com.uvg.freetofeel.data.network.SupabaseClient
import com.uvg.freetofeel.utils.SharedPreferencesHelper
import io.github.jan.supabase.gotrue.authenticatedSupabaseApi
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import java.time.Instant

class SupabaseAuthViewModel:ViewModel() {       //Sé que se llama Auth, pero tambien hace el resto de SupaCosas :)
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


    fun saveUserData(name:String,points:Int){
        viewModelScope.launch {
            try {
                _userLoginState.value = UserLoginState.Loading
                SupabaseClient.client.postgrest["UsersData"].insert(
                    UserData(
                        name =name,
                        points = points,
                        lastLogin = Instant.now().toString()
                    ),
                    upsert = false
                )
                _userLoginState.value = UserLoginState.Success("Nice upload of U-data")
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("Error ${e.message}")
            }
        }
    }

    fun saveUserWritings(title:String,body:String,type:String) {
        viewModelScope.launch {
            try {
                _userLoginState.value = UserLoginState.Loading
                SupabaseClient.client.postgrest["UsersWritings"].insert(
                    UserWritings(
                        title = title,
                        body = body,
                        type = type
                    ),
                    upsert = false
                )
                _userLoginState.value = UserLoginState.Success("Nice upload of U-writings")
            } catch (e: Exception) {
                _userLoginState.value = UserLoginState.Error("Error ${e.message}")
            }
        }
    }

        fun savePetStories(lazy:Int,hedge:Int,jelly:Int,bee:Int){
            viewModelScope.launch {
                try {
                    _userLoginState.value = UserLoginState.Loading
                    SupabaseClient.client.postgrest["PetStories"].insert(
                        PetStories(
                            lazy=lazy,
                            hedge = hedge,
                            jelly = jelly,
                            bee=bee
                        ),
                        upsert = false
                    )
                    _userLoginState.value = UserLoginState.Success("Nice upload of U-storyProgress")
                }
                catch (e:Exception){
                    _userLoginState.value = UserLoginState.Error("Error ${e.message}")
                }
            }
        }

    fun getUserData(){
        viewModelScope.launch {
            try {
                _userLoginState.value = UserLoginState.Loading
                val data = SupabaseClient.client.postgrest["UsersData"]
                    .select().decodeSingle<UserData>()

                _userLoginState.value = UserLoginState.Success("ID:${data.id}, Name:${data.name}, Points: ${data.points}")
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("Error ${e.message}")

            }
        }
    }


    fun getUserWritings(){
        viewModelScope.launch {
            try {
                _userLoginState.value = UserLoginState.Loading
                val data = SupabaseClient.client.postgrest["UsersWritings"]
                    .select().decodeSingle<UserWritings>()
                _userLoginState.value = UserLoginState.Success("Data: ${data.id}") //cambiar a varios?
//                val data2 = SupabaseClient.client.postgrest["UsersWritings"]
//                    .select().decodeList<UserWritings>()
                //Suspend???
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("Error ${e.message}")

            }
        }

    }

    fun getPetStories(){
        viewModelScope.launch {
            try {
                _userLoginState.value = UserLoginState.Loading
                val data = SupabaseClient.client.postgrest["PetStories"]
                    .select().decodeSingle<PetStories>()
                _userLoginState.value = UserLoginState.Success("Data: ${data.id}")
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("Error ${e.message}")

            }
        }
    }

    fun updateUserData(newPoints:Int){
        viewModelScope.launch {
            try {
                _userLoginState.value = UserLoginState.Loading
                SupabaseClient.client.postgrest["UsersData"]
                    .update({
                        UserData::points setTo newPoints
                    }){
                        UserData::id eq SupabaseClient.client.gotrue.currentUserOrNull()?.id
                    }
                _userLoginState.value = UserLoginState.Success("Updated correctly")
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("Error ${e.message}")
            }
        }
    }

    fun updateUserWritings(newTitle:String,newBody:String){
        viewModelScope.launch {
            try {
                _userLoginState.value = UserLoginState.Loading
                SupabaseClient.client.postgrest["UsersWritings"]
                    .update({
                        UserWritings::title setTo newTitle
                        UserWritings::body setTo newBody
                    }){
                        UserWritings::userID eq SupabaseClient.client.gotrue.currentUserOrNull()?.id
                    }
                _userLoginState.value = UserLoginState.Success("Updated correctly")
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("Error ${e.message}")
            }
        }
    }

    fun updatePetStories(newLazy:String,newHedge:String,newJelly:String,newBee:String){
        viewModelScope.launch {
            try {
                _userLoginState.value = UserLoginState.Loading
                SupabaseClient.client.postgrest["PetStories"]
                    .update({
                        PetStories::lazy setTo newLazy
                        PetStories::hedge setTo newHedge
                        PetStories::jelly setTo newJelly
                        PetStories::bee setTo newBee
                    }){
                        PetStories::id eq SupabaseClient.client.gotrue.currentUserOrNull()?.id
                    }
                _userLoginState.value = UserLoginState.Success("Updated correctly")
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("Error ${e.message}")
            }
        }
    }

    fun deleteUserWriting(id:Int){
        viewModelScope.launch {
            try {
                _userLoginState.value = UserLoginState.Loading
                SupabaseClient.client.postgrest["UsersWritings"]
                    .delete {
                        UserWritings::id eq id
                    }
                _userLoginState.value = UserLoginState.Success("Deleted correctly")
            }
            catch (e:Exception){
                _userLoginState.value = UserLoginState.Error("Error ${e.message}")

            }
        }
    }
    }
