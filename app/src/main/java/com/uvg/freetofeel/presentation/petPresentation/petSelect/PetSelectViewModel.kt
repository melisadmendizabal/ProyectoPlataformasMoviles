package com.uvg.freetofeel.presentation.petPresentation.petSelect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.freetofeel.data.source.PetDB
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PetSelectViewModel: ViewModel() {
    private val petDB = PetDB()
    private val _uiState: MutableStateFlow<PetSelectState> = MutableStateFlow(PetSelectState())
    val uiState = _uiState.asStateFlow()

    fun getListPet(){
        viewModelScope.launch {

            val listpet = petDB.getAllPets()
            _uiState.update { state ->
                state.copy(
                    data = listpet
                )

            }
        }
    }
}