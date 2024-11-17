package com.uvg.freetofeel.data.local.entity

import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uvg.freetofeel.data.model.DailyRecoModel


@Entity
data class DailyRecoEntity(
    @PrimaryKey @StringRes val title: Int,
    @StringRes val body: Int,
    val completed: String,
    val points: Int
)

fun DailyRecoEntity.mapToModel(): DailyRecoModel{
    return DailyRecoModel(
        title = this.title,
        body = this.body,
        completed = this.completed,
        points = this.points
    )
}