package com.uvg.freetofeel.presentation.petPresentation.petSelect

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.uvg.freetofeel.presentation.challengePresenation.dailyReco.DailyRecoDESTINATION
import com.uvg.freetofeel.presentation.challengePresenation.dailyReco.navigateToDailyReco
import com.uvg.freetofeel.presentation.petPresentation.petHome.navigateToPetHome
import com.uvg.freetofeel.presentation.petPresentation.petHome.pethomeScreen
import com.uvg.freetofeel.presentation.petPresentation.petTalk.PetTalkDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petTalk.navigateToPetTalk
import kotlinx.serialization.Serializable

@Serializable
data object ChangeDestination

fun NavGraphBuilder.changepet(
    navController: NavController
){
    navigation<ChangeDestination>(
        startDestination = PetSelectDESTINATION
    ){
        petSelectScreen(
            onpetselection = navController::navigateToPetHome,
            onBackFromSelectToHomePet = navController:: navigateUp
        )

        pethomeScreen(
            onAllPetsClick = {
                navController.navigateToPetSelect(PetSelectDESTINATION)
            },
            onTipDayPetScreenClick = {
            navController.navigateToDailyReco(DailyRecoDESTINATION)
            },
            onHistoryScreenPetHome = {
                navController.navigateToPetTalk(PetTalkDESTINATION)
            }
        )
        //faltan?


    }
}