package com.uvg.freetofeel.presentation.sunPresentation.sunFeeling

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R
import com.uvg.freetofeel.presentation.sunPresentation.sunInput.SunInputScreen


@Composable
fun SunFeelingROUTE(
    onHappyClick: () -> Unit,
    onBoredClick: () -> Unit,
    onAngryClick: () -> Unit,
    onSadClick: () -> Unit,
    onRestlessClick: () -> Unit,
    username: String,
    viewModel: SunFeelingViewModel = viewModel(factory=SunFeelingViewModel.Factory)
){
    val state by viewModel.state.collectAsStateWithLifecycle()
    SunFeelingScreen(
        state = state,
        onHappyClick = onHappyClick,
        onBoredClick = onBoredClick,
        onAngryClick = onAngryClick,
        onSadClick = onSadClick,
        onRestlessClick = onRestlessClick,
        username = username)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SunFeelingScreen(onHappyClick: () -> Unit,
                     onBoredClick:() -> Unit,
                     onAngryClick:() -> Unit,
                     onSadClick:() -> Unit,
                     onRestlessClick:() -> Unit ,
                     username: String,
                     state: SunFeelingState){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = MaterialTheme.colorScheme.inversePrimary)) //Cambiar cuando se tengan los colores reales
    {
        Column (modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.cloud_top),
                contentDescription = "Nubes superiores",
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.TopCenter,

                )
            Image(
                painter = painterResource(id = R.drawable.cloud_bot),
                contentDescription = "Nubes Inferiores",
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.BottomCenter,

                )
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Image(
                painter = painterResource(id = R.drawable.sun),
                contentDescription = "sun",
                )

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("$username,",
                    fontSize = 30.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
                Text(text = stringResource(id = R.string.sunFeeling_ask),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontStyle = FontStyle.Italic,)
            }


            Box(modifier = Modifier
                .size(250.dp)){
                Image(
                    painter = painterResource(id = R.drawable.pentagonosun),
                    contentDescription = "Pentagono",
                    modifier = Modifier.fillMaxWidth(),
                )
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {


                    Row(Modifier.weight(0.3f)) {
                        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                            //Happy
                            IconButton(onClick = onHappyClick,
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.onPrimary))
                            {
                                Image(
                                    painterResource(id = R.drawable.icon_happy_not),
                                    contentDescription = "Happy",
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                                )
                            }

                            Text(text = stringResource(id = R.string.sunFeeling_happy),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary)
                        }
                    }

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .weight(0.4f), horizontalArrangement = Arrangement.SpaceBetween) {
                        //restless
                        Column {
                            IconButton(onClick = onRestlessClick,
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.onPrimary
                                )) {
                                Image(
                                    painterResource(id = R.drawable.icon_stress_not),
                                    contentDescription = "restless",
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                                )
                            }
                            Text(text = stringResource(id = R.string.sunFeeling_restless),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary)
                        }


                        //bored
                        Column {
                            IconButton(onClick = onBoredClick,
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.onPrimary
                                ))
                            {
                                Image(
                                    painterResource(id = R.drawable.icon_borred_not),
                                    contentDescription = "bored",
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                                )
                            }

                            Text(text = stringResource(id = R.string.sunFeeling_bored),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary)
                        }

                    }

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)
                            .weight(0.3f), horizontalArrangement = Arrangement.SpaceBetween) {
                        //Sad
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = onSadClick,
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.onPrimary))
                            {

                                Image(
                                    painterResource(id = R.drawable.icon_sad_not),
                                    contentDescription = "sad",
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                                )
                            }

                            Text(text = stringResource(id = R.string.sunFeeling_sad),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center)
                        }


                        //Angry
                        Column {
                            IconButton(onClick = onAngryClick,
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.onPrimary
                                ))
                            {

                                Image(
                                    painterResource(id = R.drawable.icon_angry_not),
                                    contentDescription = "angry",
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                                )
                            }

                            Text(text = stringResource(id = R.string.sunFeeling_angry),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDailyRecoScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        val languageViewModel = LanguageViewModel()
        SunFeelingScreen(onRestlessClick = {}, username = "UserName", onAngryClick = {}, onBoredClick = {}, onHappyClick = {}, onSadClick = {},state = SunFeelingState())
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDailyRecoScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        val languageViewModel = LanguageViewModel()
        SunFeelingScreen(onRestlessClick = {}, username = "UserName", onAngryClick = {}, onBoredClick = {}, onHappyClick = {}, onSadClick = {},state = SunFeelingState())
    }
}