package com.uvg.freetofeel.data.source

import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.Pet

class PetDB {
    private val pets: List<Pet> = listOf(
        Pet(id = 1, name = "Mimioso", issue = R.string.pet_select_sloth_problem,
            points = 10, iconPet = R.drawable.icon_sad_not, backPet = R.drawable.lazy_back,
            imagePet = R.drawable.lazy_pet),
        Pet(id = 2, name = "Erizo", issue = R.string.pet_select_hedgehog_problem,
            points = 10, iconPet = R.drawable.icon_happy_not, backPet = R.drawable.hedgehog_back,
            imagePet = R.drawable.lazy_pet),
        Pet(id = 3, name = "Abejoide", issue = R.string.pet_select_bee_problem,
            points = 10, iconPet = R.drawable.icon_angry_not, backPet = R.drawable.bee_back,
            imagePet = R.drawable.lazy_pet),
        Pet(id = 4, name = "Medusín", issue = R.string.pet_select_jelly_problem,
            points = 10, iconPet = R.drawable.icon_happy_not, backPet = R.drawable.jelly_back,
            imagePet = R.drawable.lazy_pet),


    )

    fun getAllPets(): List<Pet> {
        return pets
    }

    fun getLocationById(id: Int): Pet {
        return pets.first { it.id == id }
    }
}