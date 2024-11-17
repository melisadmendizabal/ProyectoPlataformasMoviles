package com.uvg.freetofeel.presentation.petPresentation.petHome

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.Pet

@Composable
fun PetHomeROUTE(
    onAllPetsClick: () -> Unit,
    onTipDayPetScreenClick: ()-> Unit,
    onHistoryScreenPetHome: ()-> Unit,
    viewModel: PetHomeViewModel = viewModel()
){
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.getPet()
    }

    PetHomeScreen(
        state = state,
        pet = state.showPet,
        onAllPetsClick = onAllPetsClick,
        onTipDayPetScreenClick = onTipDayPetScreenClick,
        onHistoryScreenPetHome = onHistoryScreenPetHome
    )
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetHomeScreen(
    state: PetHomeState,
    pet: Pet?,

    onAllPetsClick: () -> Unit,
    onTipDayPetScreenClick: ()-> Unit,
    onHistoryScreenPetHome: ()-> Unit
){

    var inputText by remember { mutableStateOf("") }

    Box{
        when{
            pet == null -> {
                Text(text = "No se encontraron los datos del personaje")
            }

            else -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.primary), // Cambiar cuando se tengan los colores reales
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(pet.backPet), // Se cambia según el animal que esté seleccionado por el usuario
                        contentDescription = "Hábitat de la mascota",
                        alignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillHeight
                    )
                }

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 40.dp, horizontal = 13.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Row {
                            Icon(Icons.Filled.Star, contentDescription = "points", tint = MaterialTheme.colorScheme.onPrimary)
                            Text(text = pet.id.toString(), color = MaterialTheme.colorScheme.onPrimary)
                            Text(text = stringResource(id = R.string.points), color = MaterialTheme.colorScheme.onPrimary)
                        }

                        IconButton(onClick = onAllPetsClick, ) {
                            Box {
                                Icon(Icons.Filled.Menu, contentDescription = "More Pets", tint = MaterialTheme.colorScheme.onPrimary)
                            }

                        }
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                    ) {
                        Image(painter = painterResource(pet.imagePet), contentDescription = "lazy")

                    }

                    Row {

                        Button(
                            onClick = onTipDayPetScreenClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary

                            ),
                            modifier = Modifier
                                .weight(0.5f)
                                .height(60.dp)) {
                            Text(text = stringResource(id = R.string.pet_home_button1)
                                , style = MaterialTheme.typography.titleMedium
                                , textAlign = TextAlign.Center)
                        }


                        Spacer(modifier = Modifier.width(10.dp))

                        Button(onClick = onHistoryScreenPetHome,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.onPrimary,
                                contentColor = MaterialTheme.colorScheme.primary

                            ),
                            modifier = Modifier
                                .weight(0.5f)
                                .height(60.dp)) {
                            Text(text = stringResource(id = R.string.pet_home_button2)
                                , style = MaterialTheme.typography.titleMedium
                                , textAlign = TextAlign.Center)
                        }


                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewAccountScreenLight() {

    MaterialTheme(colorScheme = lightColorScheme()) {

        PetHomeScreen(state = PetHomeState(), pet = PetHomeState().showPet,onAllPetsClick = { }, onTipDayPetScreenClick = {}, onHistoryScreenPetHome = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewAccountScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {

        PetHomeScreen(state = PetHomeState(), pet = PetHomeState().showPet,onAllPetsClick = { }, onTipDayPetScreenClick = {}, onHistoryScreenPetHome = {})
    }
}