package com.uvg.freetofeel.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val id: Double?=null,
    val name:String?="",
    val points:Int?=null,
    @SerialName("lastLogin")
    val lastLogin:String?=null
)
