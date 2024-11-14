package com.uvg.freetofeel.data.local.entity

import androidx.annotation.StringRes
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uvg.freetofeel.data.model.Feeling

@Entity
data class FeelingEntity(
    @PrimaryKey @StringRes val title: Int,
    @StringRes val body: Int,
    val emotion: String
)

fun FeelingEntity.mapToModel():Feeling{
    return Feeling(
        title = this.title,
        body = this.body,
        emotion = this.emotion
    )
}