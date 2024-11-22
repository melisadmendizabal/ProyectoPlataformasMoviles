package com.uvg.freetofeel.data.source

import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.HistoryPets

class HistoryPetsDb {
    private val historypets: List<HistoryPets> = listOf(
        HistoryPets(title = R.string.pet_lazy_title1, description = R.string.pet_lazy_body1, typePet = "lazy", idHistory = 1,
            option1 = R.string.pet_lazy_option1A, point1 = 5,
            option2 = R.string.pet_lazy_option1B, point2 = 3,
            option3 = R.string.pet_lazy_option1C, point3 = 10,
            back = R.drawable.lazy_back, pet = R.drawable.lazy_pet
        ),

        HistoryPets(title = R.string.pet_lazy_title2, description = R.string.pet_lazy_body2, typePet = "lazy", idHistory = 2,
            option1 = R.string.pet_lazy_option2A, point1 = 3,
            option2 = R.string.pet_lazy_option2B, point2 = 5,
            option3 = R.string.pet_lazy_option2C, point3 = 10,
            back = R.drawable.lazy_back, pet = R.drawable.lazy_pet
        ),

        HistoryPets(title = R.string.pet_lazy_title3, description = R.string.pet_lazy_body3, typePet = "lazy", idHistory = 3,
            option1 = R.string.pet_lazy_option3A, point1 = 3,
            option2 = R.string.pet_lazy_option3B, point2 = 5,
            option3 = R.string.pet_lazy_option3C, point3 = 10,
            back = R.drawable.lazy_back, pet = R.drawable.lazy_pet
        ),

        HistoryPets(title = R.string.pet_lazy_title4, description = R.string.pet_lazy_body4, typePet = "lazy", idHistory = 4,
            option1 = R.string.pet_lazy_option4A, point1 = 3,
            option2 = R.string.pet_lazy_option4B, point2 = 5,
            option3 = R.string.pet_lazy_option4C, point3 = 10,
            back = R.drawable.lazy_back, pet = R.drawable.lazy_pet
        ),

        HistoryPets(title = R.string.pet_lazy_title5, description = R.string.pet_lazy_body5, typePet = "lazy", idHistory = 5,
            option1 = R.string.pet_lazy_option5A, point1 = 8,
            option2 = R.string.pet_lazy_option5B, point2 = 10,
            option3 = R.string.pet_lazy_option5C, point3 = 10,
            back = R.drawable.lazy_back, pet = R.drawable.lazy_pet
        ),


        HistoryPets(title = R.string.pet_hedge_title1, description = R.string.pet_hedge_body1, typePet = "hedge", idHistory = 1,
            option1 = R.string.pet_hedge_option1A, point1 = 3,
            option2 = R.string.pet_hedge_option1B, point2 = 5,
            option3 = R.string.pet_hedge_option1C, point3 = 10,
            back = R.drawable.hedgehog_back, pet = R.drawable.hedgehog_pet
        ),

        HistoryPets(title = R.string.pet_hedge_title2, description = R.string.pet_hedge_body2, typePet = "hedge", idHistory = 2,
            option1 = R.string.pet_hedge_option2A, point1 = 3,
            option2 = R.string.pet_hedge_option2B, point2 = 5,
            option3 = R.string.pet_hedge_option2C, point3 = 10,
            back = R.drawable.hedgehog_back, pet = R.drawable.hedgehog_pet
        ),

        HistoryPets(title = R.string.pet_hedge_title3, description = R.string.pet_hedge_body3, typePet = "hedge", idHistory = 3,
            option1 = R.string.pet_hedge_option3A, point1 = 3,
            option2 = R.string.pet_hedge_option3B, point2 = 5,
            option3 = R.string.pet_hedge_option3C, point3 = 10,
            back = R.drawable.hedgehog_back, pet = R.drawable.hedgehog_pet
        ),

        HistoryPets(title = R.string.pet_hedge_title4, description = R.string.pet_hedge_body4, typePet = "hedge", idHistory = 4,
            option1 = R.string.pet_hedge_option4A, point1 = 3,
            option2 = R.string.pet_hedge_option4B, point2 = 5,
            option3 = R.string.pet_hedge_option4C, point3 = 10,
            back = R.drawable.hedgehog_back, pet = R.drawable.hedgehog_pet
        ),

        HistoryPets(title = R.string.pet_hedge_title5, description = R.string.pet_hedge_body5, typePet = "hedge", idHistory = 5,
            option1 = R.string.pet_hedge_option5A, point1 = 8,
            option2 = R.string.pet_hedge_option5B, point2 = 10,
            option3 = R.string.pet_hedge_option5C, point3 = 10,
            back = R.drawable.hedgehog_back, pet = R.drawable.hedgehog_pet
        ),

        HistoryPets(title = R.string.pet_bee_title1, description = R.string.pet_bee_body1, typePet = "bee", idHistory = 1,
            option1 = R.string.pet_bee_option1A, point1 = 3,
            option2 = R.string.pet_bee_option1B, point2 = 5,
            option3 = R.string.pet_bee_option1C, point3 = 10,
            back = R.drawable.bee_back, pet = R.drawable.bee_pet
        ),

        HistoryPets(title = R.string.pet_bee_title2, description = R.string.pet_bee_body2, typePet = "bee", idHistory = 2,
            option1 = R.string.pet_bee_option2A, point1 = 3,
            option2 = R.string.pet_bee_option2B, point2 = 5,
            option3 = R.string.pet_bee_option2C, point3 = 10,
            back = R.drawable.bee_back, pet = R.drawable.bee_pet
        ),

        HistoryPets(title = R.string.pet_bee_title3, description = R.string.pet_bee_body3, typePet = "bee", idHistory = 3,
            option1 = R.string.pet_bee_option3A, point1 = 3,
            option2 = R.string.pet_bee_option3B, point2 = 10,
            option3 = R.string.pet_bee_option3C, point3 = 10,
            back = R.drawable.bee_back, pet = R.drawable.bee_pet
        ),

        HistoryPets(title = R.string.pet_bee_title4, description = R.string.pet_bee_body4, typePet = "bee", idHistory = 4,
            option1 = R.string.pet_bee_option4A, point1 = 3,
            option2 = R.string.pet_bee_option4B, point2 = 5,
            option3 = R.string.pet_bee_option4C, point3 = 10,
            back = R.drawable.bee_back, pet = R.drawable.bee_pet
        ),
        HistoryPets(title = R.string.pet_bee_title5, description = R.string.pet_bee_body5, typePet = "bee", idHistory = 5,
            option1 = R.string.pet_bee_option5A, point1 = 8,
            option2 = R.string.pet_bee_option5B, point2 = 10,
            option3 = R.string.pet_bee_option5C, point3 = 10,
            back = R.drawable.bee_back, pet = R.drawable.bee_pet
        ),

        HistoryPets(title = R.string.pet_jelly_title1, description = R.string.pet_jelly_body1, typePet = "jelly", idHistory = 1,
            option1 = R.string.pet_jelly_option1A, point1 = 3,
            option2 = R.string.pet_jelly_option1B, point2 = 5,
            option3 = R.string.pet_jelly_option1C, point3 = 10,
            back = R.drawable.jelly_back, pet = R.drawable.jelly_pet
        ),

        HistoryPets(title = R.string.pet_jelly_title2, description = R.string.pet_jelly_body2, typePet = "jelly", idHistory = 2,
            option1 = R.string.pet_jelly_option2A, point1 = 3,
            option2 = R.string.pet_jelly_option2B, point2 = 5,
            option3 = R.string.pet_jelly_option2C, point3 = 10,
            back = R.drawable.jelly_back, pet = R.drawable.jelly_pet
        ),

        HistoryPets(title = R.string.pet_jelly_title3, description = R.string.pet_jelly_body3, typePet = "jelly", idHistory = 3,
            option1 = R.string.pet_jelly_option3A, point1 = 3,
            option2 = R.string.pet_jelly_option3B, point2 = 5,
            option3 = R.string.pet_jelly_option3C, point3 = 10,
            back = R.drawable.jelly_back, pet = R.drawable.jelly_pet
        ),

        HistoryPets(title = R.string.pet_jelly_title4, description = R.string.pet_jelly_body4, typePet = "jelly", idHistory = 4,
            option1 = R.string.pet_jelly_option4A, point1 = 3,
            option2 = R.string.pet_jelly_option4B, point2 = 5,
            option3 = R.string.pet_jelly_option4C, point3 = 10,
            back = R.drawable.jelly_back, pet = R.drawable.jelly_pet
        ),

        HistoryPets(title = R.string.pet_jelly_title5, description = R.string.pet_jelly_body5, typePet = "jelly", idHistory = 5,
            option1 = R.string.pet_jelly_option5A, point1 = 3,
            option2 = R.string.pet_jelly_option5B, point2 = 5,
            option3 = R.string.pet_jelly_option5C, point3 = 10,
            back = R.drawable.jelly_back, pet = R.drawable.jelly_pet
        )
    )
    fun getAllHistories(): List<HistoryPets>{
        return historypets
    }
}