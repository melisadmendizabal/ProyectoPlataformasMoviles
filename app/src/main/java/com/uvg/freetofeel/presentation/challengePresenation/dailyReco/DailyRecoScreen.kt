package com.uvg.freetofeel.presentation.challengePresenation.dailyReco
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R

@Composable
fun DailyRecoROUTE(
    onAcceptDailyReco: ()->Unit
){
    DailyRecoScreen(
        onAcceptDailyReco = onAcceptDailyReco)
}

@Composable
fun DailyRecoScreen( onAcceptDailyReco: ()->Unit) {
    var inputText by remember { mutableStateOf("") }
    val checkSelect = remember {
        mutableStateOf(false)
    }

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
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    radiusX = 10.dp,
                    radiusY = 10.dp,
                    edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(0.dp))
                ),
            contentScale = ContentScale.FillHeight
        )
    }

    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = {Text(text = stringResource(id = R.string.dailyreco_title_example),
            color = MaterialTheme.colorScheme.onPrimary,  //ejemplo de texto
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())},

        text = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(id = R.string.dialyreco_text_example), //Ejemplo del texto
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.onPrimary)

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Box(modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.onPrimary)
                    ){
                        Icon(Icons.Outlined.FavoriteBorder, contentDescription = "like",
                            modifier = Modifier.align(Alignment.Center),
                            tint = MaterialTheme.colorScheme.primary)
                    }

                        Text(text = stringResource(id = R.string.dailyreco_val_completed),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(horizontal = 10.dp))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "10 +",
                            color = MaterialTheme.colorScheme.onPrimary)                                         //volver variable
                        Checkbox(checked = checkSelect.value,
                            onCheckedChange = {checkSelect.value = it},
                            colors = CheckboxDefaults.colors(
                                checkedColor = MaterialTheme.colorScheme.onPrimary,
                                uncheckedColor = MaterialTheme.colorScheme.onSecondary,
                                checkmarkColor = MaterialTheme.colorScheme.primary,
                            )
                        )
                    }
                }
            } },

        confirmButton = {
            TextButton(onClick = onAcceptDailyReco) {
                Text(stringResource(id = R.string.dailyreco_view),
                    color = MaterialTheme.colorScheme.onPrimary)
            }
        },
        containerColor = MaterialTheme.colorScheme.primary

    )
}


@Preview(showBackground = true)
@Composable
fun PreviewDailyRecoScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        DailyRecoScreen( onAcceptDailyReco = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDailyRecoScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {

        DailyRecoScreen( onAcceptDailyReco = {})
    }
}