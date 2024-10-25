package com.uvg.freetofeel.presentation.navigation.BotNavigation

import androidx.annotation.DrawableRes
import com.uvg.freetofeel.R
import com.uvg.freetofeel.presentation.challengePresenation.challengeHome.ChallengeHomeDESTINATION
import com.uvg.freetofeel.presentation.loginProfilePresentation.profileHome.ProfileHomeDESTINATION
import com.uvg.freetofeel.presentation.petPresentation.petHome.PetHomeDESTINATION
import com.uvg.freetofeel.presentation.sunPresentation.sunHome.SunHomeDESTINATION

//Se guarda declara el tipo de objeto que se va a utilizar en la barra de navegación de abajo
// también se tiene la lista con todos los elementos: Sun, Pet, Consejos, Profile
//todos los iconos jiji


data class BottonNavigationItem(
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
    val destination: Any
)

val LevelsDestinationBotNav = listOf(
    SunHomeDESTINATION:: class,
    PetHomeDESTINATION:: class,
    ChallengeHomeDESTINATION:: class,
    ProfileHomeDESTINATION:: class
)


val menuItemsBotNav = listOf(

    BottonNavigationItem(
        title = "Sun",
        selectedIcon = R.drawable.icon_sun_fill,
        unselectedIcon = R.drawable.icon_sun_not,
        hasNews = false,
        badgeCount = null,
        destination = SunHomeDESTINATION
    ),

    BottonNavigationItem(
        title = "Pet",
        selectedIcon = R.drawable.icon_pet_fill,
        unselectedIcon = R.drawable.icon_pet_not,
        hasNews = false,
        badgeCount = null,
        destination = PetHomeDESTINATION
    ),

    BottonNavigationItem(
        title = "Challenge",
        selectedIcon = R.drawable.icon_challenge_fill,
        unselectedIcon = R.drawable.icon_challenge_notfill,
        hasNews = false,
        badgeCount = null,
        destination = ChallengeHomeDESTINATION
    ),

    BottonNavigationItem(
        title = "Profile",
        selectedIcon = R.drawable.icon_profile_fill,
        unselectedIcon = R.drawable.icon_profile_not,
        hasNews = false,
        badgeCount = null,
        destination = ProfileHomeDESTINATION
    )

)



