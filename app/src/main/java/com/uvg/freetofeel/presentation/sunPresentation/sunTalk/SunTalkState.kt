package com.uvg.freetofeel.presentation.sunPresentation.sunTalk

import com.uvg.freetofeel.data.model.Feeling

data class SunTalkState(
    val data: Feeling? = null,
    val isLoading: Boolean = true
)
