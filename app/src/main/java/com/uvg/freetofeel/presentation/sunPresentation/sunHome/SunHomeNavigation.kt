package com.uvg.freetofeel.presentation.sunPresentation.sunHome

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable


@Serializable
data object SunHomeDESTINATION

fun NavController.navigateToSunHome(
    destination: SunHomeDESTINATION,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.sunHomeScreen(
    onDescribeClick:()->Unit,
    onExpressClick: ()->Unit,
    onCommentClick :()->Unit

){
    composable<SunHomeDESTINATION>{
        SunHomeROUTE(
            onDescribeClick = onDescribeClick,
            onExpressClick = onExpressClick,
            onCommentClick = onCommentClick)
    }
}