package com.uvg.freetofeel.data.sourse

import com.uvg.freetofeel.data.model.Pet

class PetDB {
    private val pets: List<Pet> = listOf(
        Pet(1,"Mimioso"),
        Pet (2, "Erizo")
    )

    fun getAllPets(): List<Pet> {
        return pets
    }

    fun getLocationById(id: Int): Pet {
        return pets.first { it.id == id }
    }
}