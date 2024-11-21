package com.uvg.freetofeel.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PetStories(
    val id:Double?=null,
    val lazy:Int?=null,
    val hedge:Int?=null,
    val jelly:Int?=null,
    val bee:Int?=null,
    )