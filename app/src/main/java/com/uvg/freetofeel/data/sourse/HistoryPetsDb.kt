package com.uvg.freetofeel.data.sourse

import androidx.annotation.StringRes
import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.HistoryPets

class HistoryPetsDb {
    private val pets: List<HistoryPets> = listOf(
        HistoryPets( idHistory = 1, title = R.string.pet_talk_title1, description = R.string.pet_talk_body1,
            option1= R.string.pet_talk_option1A, point1 = 2,
            option2= R.string.pet_talk_option1B, point2= 3,
            option3= R.string.pet_talk_option1C, point3= 4)


        )

    fun getAllPets(): List<HistoryPets> {
        return pets
    }

    fun getHistoryById(id: Int): HistoryPets {
        return pets.first { it.idHistory == id }
    }
}