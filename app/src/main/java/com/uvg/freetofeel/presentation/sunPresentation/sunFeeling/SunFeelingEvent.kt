package com.uvg.freetofeel.presentation.sunPresentation.sunFeeling

sealed interface SunFeelingEvent {
    data object ForceError: SunFeelingEvent
    data object RetryClick: SunFeelingEvent
}