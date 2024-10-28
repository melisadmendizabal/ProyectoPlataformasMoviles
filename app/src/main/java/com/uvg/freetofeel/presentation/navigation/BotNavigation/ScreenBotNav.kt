package com.uvg.freetofeel.presentation.navigation.BotNavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uvg.freetofeel.presentation.challengePresenation.challengeChosen.ChallengeChosenDESTINATION
import com.uvg.freetofeel.presentation.challengePresenation.challengeChosen.challengeChosenScreen
import com.uvg.freetofeel.presentation.challengePresenation.challengeChosen.navigateToChallengeChosen
import com.uvg.freetofeel.presentation.challengePresenation.challengeHome.challengehomeScreen
import com.uvg.freetofeel.presentation.challengePresenation.dailyReco.DailyRecoDESTINATION
import com.uvg.freetofeel.presentation.challengePresenation.dailyReco.dailyRecoScreen
import com.uvg.freetofeel.presentation.challengePresenation.dailyReco.navigateToDailyReco
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.LoginBaseDestination
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.navigateToLoginBase
import com.uvg.freetofeel.presentation.loginProfilePresentation.profileData.ProfileDataDESTINATION
import com.uvg.freetofeel.presentation.loginProfilePresentation.profileData.navigateToProfileData
import com.uvg.freetofeel.presentation.loginProfilePresentation.profileData.profileDataScreen
import com.uvg.freetofeel.presentation.loginProfilePresentation.profileHome.profilehomeScreen
import com.uvg.freetofeel.presentation.petPresentation.firstPet.FirstPetDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petHome.PetHomeDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petHome.pethomeScreen
import com.uvg.freetofeel.presentation.petPresentation.petSelect.PetSelectDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petSelect.navigateToPetSelect
import com.uvg.freetofeel.presentation.petPresentation.petSelect.petSelectScreen
import com.uvg.freetofeel.presentation.petPresentation.petTalk.PetTalkDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petTalk.navigateToPetTalk
import com.uvg.freetofeel.presentation.petPresentation.petTalk.petTalkScreen
import com.uvg.freetofeel.presentation.sunPresentation.sunFeeling.SunFeelingDESTINATION
import com.uvg.freetofeel.presentation.sunPresentation.sunFeeling.navigateToSunFeeling
import com.uvg.freetofeel.presentation.sunPresentation.sunFeeling.sunFeelingScreen
import com.uvg.freetofeel.presentation.sunPresentation.sunHome.SunHomeDESTINATION
import com.uvg.freetofeel.presentation.sunPresentation.sunHome.navigateToSunHome
import com.uvg.freetofeel.presentation.sunPresentation.sunHome.sunHomeScreen
import com.uvg.freetofeel.presentation.sunPresentation.sunInput.SunInputDESTINATION
import com.uvg.freetofeel.presentation.sunPresentation.sunInput.navigateToSunInput
import com.uvg.freetofeel.presentation.sunPresentation.sunInput.sunInputScreen
import com.uvg.freetofeel.presentation.sunPresentation.sunTalk.SunTalkDESTINATION
import com.uvg.freetofeel.presentation.sunPresentation.sunTalk.navigateToSunTalk
import com.uvg.freetofeel.presentation.sunPresentation.sunTalk.sunTalkScreen

@Composable
fun ScreenBotNav(
    navController: NavHostController = rememberNavController()
){
    var bottomBarVisible by rememberSaveable {
        mutableStateOf(false)
    }

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    bottomBarVisible = if (currentDestination != null){
        LevelsDestinationBotNav.any {destination ->
            currentDestination.hasRoute(destination)
        }

    } else {
        false
    }

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = bottomBarVisible,
                enter = slideInVertically(initialOffsetY = {it}),
                exit = slideOutVertically(targetOffsetY = {it})
            ) {
                NavigationBar(
                    checkItemSelected = { destination ->
                        currentDestination?.hierarchy?.any { it.hasRoute(destination::class)  } ?: false
                    },
                    onNavItemClick = { destination ->
                        navController.navigate(destination){
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }

    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PetHomeDESTINATION,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){


            pethomeScreen(
                onAllPetsClick = {
                    navController.navigateToPetSelect(PetSelectDESTINATION)
                },
                onTipDayPetScreenClick = {navController.navigateToDailyReco(DailyRecoDESTINATION)},
                onHistoryScreenPetHome = {navController.navigateToPetTalk(PetTalkDESTINATION)}
            )

            sunHomeScreen(onCommentClick = {navController.navigateToSunInput(SunInputDESTINATION)},
                onExpressClick = {navController.navigateToSunFeeling(SunFeelingDESTINATION)},
                onDescribeClick = {navController.navigateToSunInput(SunInputDESTINATION)})
            challengehomeScreen(onSelect = {navController.navigateToChallengeChosen(ChallengeChosenDESTINATION)})
            challengeChosenScreen(onButton = {navController.navigateUp()}) //TODO: Manejar las opciones
            profilehomeScreen(
                onMyWriteClick = {
                    navController.navigateToProfileData(
                        ProfileDataDESTINATION
                    )
                }
            )

            profileDataScreen(
                onBackProfileData = {navController.navigateUp()}
            )

            dailyRecoScreen(
                onAcceptDailyReco = {navController.navigateUp()} //TODO:cambiar eventualmente para que sí cambie de mascota
            )
            petTalkScreen(onElection = {navController.navigateUp()}) //TODO cambiar eventualmente para que sí dé puntos

            petSelectScreen(
                onBackFromSelectToHomePet = {
                    navController.navigateUp()
                }
            )
            sunInputScreen(onOption = {navController.navigateUp()}) //cambiar eventualmente para que sí guarde o cancele

            sunFeelingScreen(onEmotionClick = {navController.navigateToSunTalk(SunTalkDESTINATION)}, userName = "R&M") //Cambiar por el nombre real del usuario
        sunTalkScreen(onAccept = {navController.popBackStack(); navController.navigateToSunHome(SunHomeDESTINATION)})

        }
    }
}