package com.uvg.freetofeel.presentation.petPresentation.petTalk

import com.uvg.freetofeel.data.model.HistoryPets

data class PetTalkState(
    val data:List<HistoryPets>?=null,
    val data2:HistoryPets?=null
)