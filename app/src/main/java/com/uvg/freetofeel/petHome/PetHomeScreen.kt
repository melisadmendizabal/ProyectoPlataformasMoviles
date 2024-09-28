package com.uvg.freetofeel.petHome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetHomeScreen(languageViewModel: LanguageViewModel){
    var inputText by remember { mutableStateOf("") }
    val selectedLanguage = languageViewModel.selectedLanguage

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary), // Cambiar cuando se tengan los colores reales
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

    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(vertical = 40.dp, horizontal = 25.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row {
                Icon(Icons.Filled.Star, contentDescription = "points")
                Text(text = "100 ")
                Text(text = stringResource(id = R.string.points))
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Menu, contentDescription = "More Pets")
            }
        }

        Box(modifier = Modifier
            .size(250.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary)) {
        }

        Row {
            OutlinedTextField(
                value = inputText,
                onValueChange = {inputText = it},
                shape = CircleShape,
                label = { Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { Text(text = stringResource(
                    id = R.string.pet_home_button1
                )
                    ,textAlign = TextAlign.Center) } },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                ,modifier = Modifier
                    .weight(0.5f)
                    .height(60.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                )

            )
            Spacer(modifier = Modifier.width(15.dp))

            OutlinedTextField(
                value = inputText,
                onValueChange = {inputText = it},
                shape = CircleShape,
                label = { Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { Text(text = stringResource(
                    id = R.string.pet_home_button2
                )
                    ,textAlign = TextAlign.Center) } },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                ,modifier = Modifier
                    .weight(0.5f)
                    .height(60.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewAccountScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        val languageViewModel = LanguageViewModel()
        PetHomeScreen(languageViewModel = languageViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewAccountScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        val languageViewModel = LanguageViewModel()

        PetHomeScreen(languageViewModel = languageViewModel)
    }
}