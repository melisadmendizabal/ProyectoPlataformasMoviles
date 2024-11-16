package com.uvg.freetofeel.presentation.petPresentation.petHome

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.uvg.freetofeel.data.source.PetDB
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class PetHomeViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val petDB = PetDB()
    private val petPerfil = savedStateHandle.toRoute<PetHomeDESTINATION>()
    private val _uiState: MutableStateFlow<PetHomeState> = MutableStateFlow(PetHomeState())
    val uiState = _uiState.asStateFlow()

    fun getPet(){
        viewModelScope.launch {
            val mypet = petDB.getLocationById(petPerfil.id)
            _uiState.update {state ->
                state.copy(
                    showPet = mypet
                )
            }
        }
    }

    fun changePet(){

    }
}