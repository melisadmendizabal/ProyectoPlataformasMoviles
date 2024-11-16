package com.uvg.freetofeel.presentation.sunPresentation.sunFeeling

import com.uvg.freetofeel.data.model.Feeling

data class SunFeelingState(
    val isLoading: Boolean = true,
    val feelings: List<Feeling> = emptyList(),
    val isError: Boolean = false
)
