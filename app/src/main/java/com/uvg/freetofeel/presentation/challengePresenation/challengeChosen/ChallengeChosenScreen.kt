package com.uvg.freetofeel.presentation.challengePresenation.challengeChosen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R
import com.uvg.freetofeel.presentation.challengePresenation.challengeHome.ChallengeHomeScreen
import com.uvg.freetofeel.presentation.challengePresenation.challengeHome.itemsLazyRow


@Composable
fun ChallengeChosenROUTE(
    onButton: () -> Unit

){
    ChallengeChosenScreen(
        onButton = onButton
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChallengeChosenScreen(onButton:()->Unit) {
    var inputText by remember { mutableStateOf("") }
    val textexample = listOf(
        stringResource(id = R.string.challengeChosen_descripción1),
        stringResource(id = R.string.challengeChosen_descripción2),
        stringResource(id = R.string.challengeChosen_descripción3),
    )

    Column(Modifier.fillMaxSize()) {
        Column(Modifier.background(MaterialTheme.colorScheme.primary)) {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.Challenge_title)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )

            Box(
                Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(5.dp)
            ) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                    items(4) { index ->
                        itemsLazyRow(valueitem = stringResource(id = R.string.challenge_row1))
                    }
                }
            }
        }

        Box(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Transparent)
            .border(4.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
        ) {
            Column(Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text = stringResource(id = R.string.challengeChosen_title),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = stringResource(id = R.string.challengeChosen_type),
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.primary
                )

                Box(modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))){
                    Image(painter = painterResource(id = R.drawable.pug),
                        contentDescription = "consejo",
                        modifier = Modifier
                            .fillMaxWidth()

                    )
                }


                Column{
                    for(item in textexample){
                        Row {
                            Text(text = "-", Modifier.padding(horizontal = 5.dp),
                                color = MaterialTheme.colorScheme.primary)
                            Text(text = item, fontSize = 17.sp,
                                textAlign = TextAlign.Justify,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(horizontal = 5.dp))
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                Row(Modifier.fillMaxWidth().padding(horizontal = 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = onButton,
                        Modifier.fillMaxWidth().weight(0.5f).padding(horizontal = 10.dp)) {
                        Text(text = stringResource(id = R.string.challengeChosen_buttonBack))
                    }
                    Button(onClick = onButton,  //Agregar lógica de sumar puntos
                        Modifier.fillMaxWidth().weight(0.5f).padding(horizontal = 10.dp)) {
                        Text(text = stringResource(id = R.string.challengeChosen_buttonAccept),
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
        ChallengeChosenScreen(onButton = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDailyRecoScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        ChallengeChosenScreen(onButton = {})
    }
}