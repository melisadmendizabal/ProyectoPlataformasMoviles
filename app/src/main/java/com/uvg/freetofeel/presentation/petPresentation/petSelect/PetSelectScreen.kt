package com.uvg.freetofeel.presentation.petPresentation.petSelect

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.R

@Composable
fun PetSelectROUTE(
    onBackFromSelectToHomePet: ()-> Unit
){
    PetSelectScreen(
        onBackFromSelectToHomePet = onBackFromSelectToHomePet
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetSelectScreen(
    onBackFromSelectToHomePet: ()-> Unit
){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        CenterAlignedTopAppBar(
            title = { Text(text = stringResource(id = R.string.pet_select_topAppBar) , textAlign = TextAlign.Center, fontFamily = FontFamily.Monospace)},
            navigationIcon = {
                IconButton(onClick = onBackFromSelectToHomePet) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        Text(text = stringResource(id = R.string.pet_select_mainMSG), style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.weight(0.1f))
        Column (modifier = Modifier
            .weight(0.7f)
            .padding(10.dp)
            ,verticalArrangement = Arrangement.SpaceBetween)
        {
            PetCards(points = 5,//Cambiar por una variable de los puntos que tenga con c/u de mascotas
                name = stringResource(id = R.string.pet_select_sloth),
                problem = stringResource(id = R.string.pet_select_sloth_problem),
                imageID = getImageResource("Pug")
            ) //Cambiar cuando se tengan los dibujos de mascotas
            PetCards(points = 6, name = "Abejoide",
                problem = stringResource(id = R.string.pet_select_bee_problem),
                imageID = getImageResource("Bulldog")
            )
            PetCards(points = 7,    //same
                name = "Erizo",     //same
                problem = stringResource(id = R.string.pet_select_hedgehog_problem),
                imageID = getImageResource("si")
            )   //same
            PetCards(points = 8,    //same
                name = "Medusín",   //same
                problem = stringResource(id = R.string.pet_select_jelly_problem),
                imageID = getImageResource("Pug")
            ) //same

        }
    }


}



@Composable
fun PetCards(points: Int,name:String, problem:String,imageID:Int){

    Card(modifier = Modifier.height(130.dp)) {
        Row(horizontalArrangement = Arrangement.Center
            , verticalAlignment = Alignment.CenterVertically
            ,modifier = Modifier
                .padding(7.dp)
                .fillMaxSize()) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = CircleShape
                    )
                    .weight(0.2f)
                , contentAlignment = Alignment.Center
            ) {
                Text(text = points.toString(), color = MaterialTheme.colorScheme.onTertiaryContainer) //Cambiar por una variable que contenga la cantidad de puntos según la mascota
            }

            Column (modifier = Modifier
                .weight(0.5f)
                .padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start){
                Text(text = name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold)
                Text(text = problem,
                    style = MaterialTheme.typography.labelLarge)
            }
            Image(painter = painterResource(id = imageID),
                contentDescription = "PetImage",
                modifier = Modifier
                    .weight(0.3f)
                    .clip(
                        CircleShape
                    ))
        }
    }
    Spacer(modifier = Modifier.height(30.dp))
}


fun getImageResource(name: String): Int {
    return when (name) {
        "Pug" -> R.drawable.pug
        "Bulldog" -> R.drawable.ic_launcher_foreground
        // Agregar según imagenes
        else -> R.drawable.ic_launcher_background // Debido a "when", necesita un recurso por defecto
    }
}









@Preview(showBackground = true)
@Composable
fun PreviewPetSelectScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        PetSelectScreen( onBackFromSelectToHomePet ={})
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPetSelectScreenDark() {
    MaterialTheme(
        colorScheme = darkColorScheme() // DarkMode
    ) {
        PetSelectScreen(onBackFromSelectToHomePet ={})
    }
}