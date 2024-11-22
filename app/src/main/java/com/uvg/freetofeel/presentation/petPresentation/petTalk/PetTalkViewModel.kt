package com.uvg.freetofeel.presentation.petPresentation.petTalk

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import com.uvg.freetofeel.data.local.dao.HistoryDAO
import com.uvg.freetofeel.data.local.entity.mapToModel
import com.uvg.freetofeel.data.model.HistoryPets
import com.uvg.freetofeel.dependencies.Dependencies
import com.uvg.freetofeel.presentation.petPresentation.petHome.PetHomeDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petHome.PetHomeViewModel
import com.uvg.freetofeel.repositories.HistoryRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class PetTalkViewModel (
    private val petStoriesRepository:HistoryRepository,
    petDAO: HistoryDAO,
    petHomeViewModel: PetHomeViewModel
):ViewModel() {
    val foreignVM = petHomeViewModel.uiState.value.showPet
    val dadaw = foreignVM?.name
    val histories =
        petDAO.getAllHistories().map { entities -> entities.map { it.mapToModel() } }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
    private var getDataJob: Job?= null
    private val _state:MutableStateFlow<PetTalkState> = MutableStateFlow(PetTalkState())
    private val _state2:MutableStateFlow<PetTalkState> = MutableStateFlow(PetTalkState())
    val state = _state.asStateFlow()
    val state2 = _state2.asStateFlow()

    init {
        getStories()
        if (dadaw != null) {
            getStory(id =1)
        }
    }

private fun getStories(){

    getDataJob = viewModelScope.launch {
        val stories = petStoriesRepository.getHistories()
        val story = petStoriesRepository.getHistoriesByTipe(foreignVM?.name?:"hedge")
        _state.update {
            state -> state.copy(data = story)
        }
    }

}

    private fun getStory(id:Int){

        getDataJob = viewModelScope.launch {
            val stories = petStoriesRepository.getHistories()
            val story = petStoriesRepository.getHistoriesByTipe(foreignVM?.name?:"hedge")
            val story2 = petStoriesRepository.getSigleHistorybyOrder(id)
            _state2.update {
                state2 -> state2.copy(data2 = story2)
            }
        }

    }

companion object {
    val Factory:ViewModelProvider.Factory = viewModelFactory {
        initializer {
            val application = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
            val repositoryDao =Dependencies.provideDatabase(application)
            val repository = Dependencies.provideHistoryPetsRepository(application)
            PetTalkViewModel(petDAO =  repositoryDao.historyPetsDao(), petStoriesRepository =  repository, petHomeViewModel = PetHomeViewModel(savedStateHandle = createSavedStateHandle()))
        }
    }
}

}