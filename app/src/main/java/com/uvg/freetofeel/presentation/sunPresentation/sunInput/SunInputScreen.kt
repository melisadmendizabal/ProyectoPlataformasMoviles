package com.uvg.freetofeel.presentation.sunPresentation.sunInput

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R
import com.uvg.freetofeel.presentation.petPresentation.petTalk.PetTalkScreen


@Composable
fun SunInputROUTE(
    onOption: ()->Unit
){
    SunInputScreen(
        onOption = onOption)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SunInputScreen(onOption: () -> Unit) {
    var inputText by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    val options = listOf(
        stringResource(id = R.string.sunFeeling_happy),
        stringResource(id = R.string.sunFeeling_sad),
        stringResource(id = R.string.sunFeeling_bored),
        stringResource(id = R.string.sunFeeling_restless),
        stringResource(id = R.string.sunFeeling_angry)

    )

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = MaterialTheme.colorScheme.inversePrimary)) //Cambiar cuando se tengan los colores reales
    {
        Image(
            painter = painterResource(id = R.drawable.cloud_top),
            contentDescription = "Nubes superiores",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()

        )
        Image(
            painter = painterResource(id = R.drawable.cloud_bot),
            contentDescription = "Nubes Inferiores",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()

        )


    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 20.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        Image(
            painter = painterResource(id = R.drawable.sun),
            contentDescription = "sun",
            modifier = Modifier.size(150.dp)

            )

        Spacer(modifier = Modifier.padding(10.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(19.dp))
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally) {

                TextField(
                    value = title,
                    onValueChange = {title = it},
                    placeholder = { Text(stringResource(id = R.string.sunInput_title), color = MaterialTheme.colorScheme.primary)},
                    colors = TextFieldDefaults.textFieldColors(

                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedLabelColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        ),
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.33f)
                )


                TextField(
                    value = text,
                    onValueChange = {text = it},
                    placeholder = { Text(stringResource(id = R.string.sunInput_text), color = MaterialTheme.colorScheme.primary)},
                    colors = TextFieldDefaults.textFieldColors(

                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedLabelColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,


                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.8f)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    options.forEach { option ->
                        Column {
                            RadioButton(
                                selected = (option == selectedOption),
                                onClick = { selectedOption = option },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MaterialTheme.colorScheme.primary,
                                    unselectedColor = MaterialTheme.colorScheme.primary
                                )
                            )

                            Text(text = option,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }


                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = onOption, //Luego validar si la opción es guardar, que guarde
                        Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                            .padding(horizontal = 10.dp)) {
                        Text(text = stringResource(id = R.string.sunInput_buttonCancel))
                    }

                    Button(onClick = onOption,//Luego validar si la opción es cancelar, que elimine la entrada
                        Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                            .padding(horizontal = 10.dp)) {
                        Text(text = stringResource(id = R.string.sunInput_buttonSave ),
                            color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSUnRecoScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        SunInputScreen(onOption = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDailyRecoScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        SunInputScreen(onOption = {})
    }
}