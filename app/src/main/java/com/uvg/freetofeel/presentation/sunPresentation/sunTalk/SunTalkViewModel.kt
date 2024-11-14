package com.uvg.freetofeel.presentation.sunPresentation.sunTalk

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import coil.transition.Transition
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.data.local.entity.mapToModel
import com.uvg.freetofeel.dependencies.Dependencies
import com.uvg.freetofeel.repositories.FeelingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SunTalkViewModel (
    private val feelingsRepository: FeelingsRepository,
    savedStateHandle: SavedStateHandle) : ViewModel()
{
        private  val sunTalk = savedStateHandle.toRoute<SunTalkDESTINATION>()
        private  val _state: MutableStateFlow<SunTalkState> = MutableStateFlow(SunTalkState())
        val state = _state.asStateFlow()

        init {
            getFeelingData()
        }

        private fun getFeelingData(){
            viewModelScope.launch {
                viewModelScope.launch {
                    _state.update { state ->
                        state.copy(isLoading = true)
                    }
                    val feelingList = feelingsRepository.getFeelingsByEmotion(sunTalk.emotion)
                    val feeling = feelingsRepository.getSingleRandomFeelingByEmotion(feelingList)

                    _state.update { state ->
                        state.copy(
                            data = feeling,
                            isLoading = false
                        )
                    }

                }

            }
        }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application= checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                val repository = Dependencies.provideFeelingRepository(application)
                val savedStateHandle = this.createSavedStateHandle()
                SunTalkViewModel(repository,savedStateHandle)
            }
        }
    }
    }
