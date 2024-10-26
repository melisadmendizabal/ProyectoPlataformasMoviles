package com.uvg.freetofeel.presentation.petPresentation.petTalk

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R
import com.uvg.freetofeel.presentation.challengePresenation.dailyReco.DailyRecoScreen

@Composable
fun PetTalkROUTE(
    onElection: ()->Unit
){
    PetTalkScreen(
        onElection = onElection)
}



@Composable
fun PetTalkScreen(onElection: ()->Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inversePrimary), // Cambiar cuando se tengan los colores reales
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.lazy_back), // Se cambia según el animal que esté seleccionado por el usuario
            contentDescription = "Hábitat de la mascota",
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
    }
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Icon(Icons.Default.Face, contentDescription = "", modifier = Modifier.weight(0.5f)) //Cambiar eventualmente según la mascota
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(0.5f)
            .background(MaterialTheme.colorScheme.secondaryContainer,   //Cambiar color
                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))){
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly)
            {
                Text(text = stringResource(id = R.string.pet_talk_title1), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
                Text(text = stringResource(id = R.string.pet_talk_body1)
                    , style = MaterialTheme.typography.bodyMedium
                , textAlign = TextAlign.Center)

                Button(onClick = onElection, modifier = Modifier
                    .width(315.dp)
                    .height(45.dp)) {
                    Text(text = stringResource(id = R.string.pet_talk_option1A)
                        , style = MaterialTheme.typography.labelMedium
                        , textAlign = TextAlign.Center)
                }
                Button(onClick = onElection, modifier = Modifier
                    .width(315.dp)
                    .height(45.dp)
                    ) {
                    Text(text = stringResource(id = R.string.pet_talk_option1B)
                        , style = MaterialTheme.typography.labelMedium
                        , textAlign = TextAlign.Center)
                }
                Button(onClick = onElection, modifier = Modifier
                    .width(315.dp)
                    .height(45.dp)) {
                    Text(text = stringResource(id = R.string.pet_talk_option1C)
                    , style = MaterialTheme.typography.labelMedium
                        , textAlign = TextAlign.Center)
                }
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun PreviewPetTalkScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        PetTalkScreen( onElection = {})
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPetTalkScreenDark() {
    MaterialTheme(
        colorScheme = darkColorScheme() // DarkMode
    ) {
        PetTalkScreen(onElection = {})
    }
}