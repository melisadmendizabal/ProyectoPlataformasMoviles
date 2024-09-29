package com.uvg.freetofeel.petEvolved

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetEvolvedScreen(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
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
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Box(modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id = R.drawable.pug), contentDescription = "Pet", modifier = Modifier.clip(
                CircleShape))
        }

        Column(modifier = Modifier
            .weight(0.5f)
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            , verticalArrangement = Arrangement.Top){
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.pet_evolved_topAppBar) , textAlign = TextAlign.Center) },
                navigationIcon = {
                    IconButton(onClick = {/*TODO*/}) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onTertiaryContainer
                )
            )
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "", modifier = Modifier
                .size(50.dp)
                .clip(CircleShape))
        Text(text = stringResource(id = R.string.pet_evolved_baseBee), //Luego hacerlo variable segun el que se esté seleccionado
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSecondaryContainer)
            RadioButton(selected = true, onClick = { /*TODO*/ })
        }
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "EvoPet",
                    modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape))
                Text(text = stringResource(id = R.string.pet_evolved_evoBee), //Luego hacerlo variable segun el que se esté seleccionado
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer)
                RadioButton(selected = false, onClick = { /*TODO*/ })
            }



        }
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewPetEvolvedScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        PetEvolvedScreen()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPetEvolvedScreenDark() {
    MaterialTheme(
        colorScheme = darkColorScheme() // DarkMode
    ) {
        PetEvolvedScreen()
    }
}