package com.uvg.freetofeel.data.local.entity

import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uvg.freetofeel.data.model.Challenge

@Entity
data class ChallengeEntity(
    @PrimaryKey @StringRes val title: Int,
    @StringRes val category: Int,
    @StringRes val body: Int,
    val filter: String,
    val image: String
)

fun ChallengeEntity.mapToModel():Challenge{
    return Challenge(
        title = this.title,
        category = this.category,
        body = this.body,
        filter = this.filter,
        image = this.image
    )
}