package com.uvg.freetofeel.presentation.challengePresenation.challengeHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uvg.freetofeel.data.local.dao.ChallengeDAO
import com.uvg.freetofeel.dependencies.Dependencies
import com.uvg.freetofeel.presentation.sunPresentation.sunFeeling.SunFeelingViewModel
import com.uvg.freetofeel.repositories.ChallengesRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChallengeHomeViewModel(
    private val challengeDAO: ChallengeDAO,
    private val challengesRepository: ChallengesRepository
):ViewModel(){

    private var getDataJob: Job? = null
    private val _state:MutableStateFlow<ChallengeHomeState> = MutableStateFlow(ChallengeHomeState())
    val state =_state.asStateFlow()

init {
    getChallenges()
}

 private fun getChallenges(){
     getDataJob = viewModelScope.launch {
         _state.update { state ->
             state.copy(isLoading = true, isError = false)
         }
         val challenges = challengesRepository.getChallenges()
         _state.update { state -> state.copy(
             isLoading = false,
             challenges= challenges
         )}
     }
 }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                val repositoryDao = Dependencies.provideDatabase(application)
                val repository = Dependencies.provideChallengeRepository(application)
                ChallengeHomeViewModel(repositoryDao.challengeDao(), repository)
            }
        }
    }
}