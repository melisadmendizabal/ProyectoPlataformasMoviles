package com.uvg.freetofeel.presentation.challengePresenation.dailyReco

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import com.uvg.freetofeel.dependencies.Dependencies
import com.uvg.freetofeel.repositories.DailyRecoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DailyRecoViewModel (
    private val dailyRecoRepository: DailyRecoRepository,
    savedStateHandle: SavedStateHandle) : ViewModel()
{
        private val dailyscreen = savedStateHandle.toRoute<DailyRecoDESTINATION>()
        private val _state: MutableStateFlow<DailyRecoState> = MutableStateFlow(DailyRecoState())
        val state = _state.asStateFlow()

    init{
        getDailyRecoData()
    }

    private fun getDailyRecoData(){
        viewModelScope.launch {
            viewModelScope.launch {
                _state.update { state ->
                    state.copy(isLoading = true)
                }

                val dailyList = dailyRecoRepository.getDailyRecosByCompleted(dailyscreen.completed)
                val Lista = dailyRecoRepository.getDailyRecos()
                Log.d("DailyRecoViewModel", "Collection size: ${dailyList.size}")
                Log.d("DailyRecoViewModel", "Collection size: ${Lista.size}")
                val daily = dailyRecoRepository.getSingleRandomRecoByCompleted(dailyList.random().completed)

                _state.update { state ->
                    state.copy(
                        data = daily,
                        isLoading = false
                    )
                }
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                val repository = Dependencies.provideDailyRecoRepository(application)
                val savedStateHandle = this.createSavedStateHandle()
                DailyRecoViewModel(repository,savedStateHandle)
            }
        }
    }

    }