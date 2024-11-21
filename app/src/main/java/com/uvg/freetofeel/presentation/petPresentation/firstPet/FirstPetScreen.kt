package com.uvg.freetofeel.presentation.petPresentation.firstPet

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R
@Composable
fun FirstPetROUTE(
    onFirstPetOk: () -> Unit
){
    FirstPetScreen(onFirstPetOk = onFirstPetOk)
}

@Composable
fun FirstPetScreen(onFirstPetOk: ()-> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inversePrimary), // Cambiar cuando se tengan los colores reales
        contentAlignment = Alignment.Center
    ) {
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
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        AlertDialog(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.4f),
            onDismissRequest = { /* Lógica al cerrar */ }, //posiblemente se quede vacío, porque solo hay aceptar
            title = { Text(text = stringResource(id = R.string.first_pet_title), textAlign = TextAlign.Center) },
            text = { Text(text = stringResource(id = R.string.first_pet_body1), textAlign = TextAlign.Justify) },

            confirmButton = {
                Button(onClick = onFirstPetOk) {
                    Text(text = stringResource(id = R.string.first_pet_confirm))
                }
            }
        )
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewFirstPetScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        FirstPetScreen(onFirstPetOk = {})
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewFirstPetScreenDark() {
    MaterialTheme(
        colorScheme = darkColorScheme() // DarkMode
    ) {
        FirstPetScreen(onFirstPetOk = {})
    }
}