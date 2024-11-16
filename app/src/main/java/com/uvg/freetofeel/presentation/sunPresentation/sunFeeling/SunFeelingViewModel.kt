package com.uvg.freetofeel.presentation.sunPresentation.sunFeeling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uvg.freetofeel.data.local.dao.FeelingDAO
import com.uvg.freetofeel.data.local.entity.mapToModel
import com.uvg.freetofeel.dependencies.Dependencies
import com.uvg.freetofeel.repositories.FeelingsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SunFeelingViewModel(
    private val feelingDAO: FeelingDAO,
    private val feelingsRepository: FeelingsRepository
): ViewModel() {
    val feelings =
        feelingDAO.getAllFeelings().map { entities -> entities.map { it.mapToModel() } }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    private var getDataJob: Job?= null
    private val _state: MutableStateFlow<SunFeelingState> = MutableStateFlow(SunFeelingState())
    val state = _state.asStateFlow()

    init {
        getFeelings()
    }

    fun onEvent(event: SunFeelingEvent) {
        when (event) {

            SunFeelingEvent.ForceError -> {
                getDataJob?.cancel()
                _state.update { state ->
                    state.copy(
                        isLoading = false,
                        isError = true
                    )
                }
            }
            SunFeelingEvent.RetryClick -> {
                getFeelings()
            }
        }
    }



    private fun getFeelings() {

        getDataJob = viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    isLoading = true,
                    isError = false
                )
            }

            val feelings = feelingsRepository.getFeelings()

            _state.update { state ->
                state.copy(
                    isLoading = false,
                    feelings = feelings
                )
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                val repositoryDao = Dependencies.provideDatabase(application)
                val repository = Dependencies.provideFeelingRepository(application)
                SunFeelingViewModel(repositoryDao.feelingDao(), repository)
            }
        }
    }
}
