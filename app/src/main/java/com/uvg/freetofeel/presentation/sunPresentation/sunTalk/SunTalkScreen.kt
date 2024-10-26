package com.uvg.freetofeel.presentation.sunPresentation.sunTalk

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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R
import com.uvg.freetofeel.presentation.sunPresentation.sunInput.SunInputScreen


@Composable
fun SunTalkROUTE(
    onAccept: ()->Unit
){
    SunTalkScreen(
        onAccept = onAccept)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SunTalkScreen(onAccept: () -> Unit) {
    var inputText by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.inversePrimary)
    ) //Cambiar cuando se tengan los colores reales
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight())
    {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(width = 220.dp, height = 150.dp)
                .background(MaterialTheme.colorScheme.secondary))
        {
            Text(text = "imagen")
        }

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(width = 320.dp, height = 270.dp)
                .clip(RoundedCornerShape(17.dp))
                .background(MaterialTheme.colorScheme.primary)
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween,modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)) {
                Text(text = stringResource(id = R.string.sunTalk_example_title),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 33.sp
                )
                Text(text = stringResource(id = R.string.sunTalk_example_text), //Ejemplo del texto
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(vertical = 5.dp))
                Row {
                    TextButton(onClick = onAccept) {
                        Text(text = stringResource(id = R.string.sunTalk_button),
                            color = MaterialTheme.colorScheme.onSecondary)
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
        val languageViewModel = LanguageViewModel()
        SunTalkScreen(onAccept = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDailyRecoScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        val languageViewModel = LanguageViewModel()
        SunTalkScreen(onAccept = {})
    }
}
