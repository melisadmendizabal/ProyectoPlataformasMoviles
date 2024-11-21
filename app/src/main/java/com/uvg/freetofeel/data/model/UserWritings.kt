package com.uvg.freetofeel.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserWritings(
    val id:Int?=null,
    val userID:Double?=null,
    val title:String?="",
    val body:String?="",
    val type:String?=""
)
