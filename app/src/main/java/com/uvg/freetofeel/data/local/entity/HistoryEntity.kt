package com.uvg.freetofeel.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.uvg.freetofeel.data.model.HistoryPets

@Entity
data class HistoryEntity(
    @PrimaryKey val idHistory: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    val typePet: String,
    @StringRes val option1: Int,
    val point1: Int,
    @StringRes val option2: Int,
    val point2: Int,
    @StringRes val option3: Int,
    val point3: Int,
    @DrawableRes val back: Int,
    @DrawableRes val pet: Int
)

fun HistoryEntity.mapToModel(): HistoryPets {
    return HistoryPets(
        title = this.title,
        description = this.description,
        typePet = this.typePet,
        idHistory = this.idHistory,
        option1 = this.option1,
        point1 = this.point1,
        option2 = this.option2,
        point2 = this.point2,
        option3 = this.option3,
        point3 = this.point3,
        back = this.back,
        pet = this.pet
    )
}
