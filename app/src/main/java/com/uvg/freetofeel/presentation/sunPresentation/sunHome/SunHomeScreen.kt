package com.uvg.freetofeel.presentation.sunPresentation.sunHome


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.R


@Composable
fun SunHomeROUTE(
    onDescribeClick: ()->Unit, onExpressClick : ()->Unit, onCommentClick : ()->Unit
){
    SunHomeScreen(onDescribeClick = onDescribeClick, onExpressClick = onExpressClick, onCommentClick = onCommentClick)
}

@Composable
fun SunHomeScreen(onExpressClick: ()->Unit, onDescribeClick:()->Unit,onCommentClick:()->Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = MaterialTheme.colorScheme.onPrimaryContainer)) //Cambiar cuando se tengan los colores reales
    {
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

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(id = R.drawable.sun),
            contentDescription = "Sun",
            modifier = Modifier.weight(0.5f))
        Column (modifier = Modifier.weight(0.2f),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Nombre del usuario,", //Reemplazar por el nombre del usuario
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primaryContainer)
            Text(text = stringResource(id = R.string.sun_home_question),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primaryContainer)
        }
        Column (modifier = Modifier
            .weight(0.3f)
            .padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround)
        {
            Button(onClick = onExpressClick, modifier = Modifier
                .width(315.dp)
                .height(45.dp)) {
                Text(text = stringResource(id = R.string.sun_home_buttonA)
                    , style = MaterialTheme.typography.titleMedium
                    , textAlign = TextAlign.Center)
            }
            Button(onClick = onDescribeClick, modifier = Modifier
                .width(315.dp)
                .height(45.dp)) {
                Text(text = stringResource(id = R.string.sun_home_buttonB)
                    , style = MaterialTheme.typography.titleMedium
                    , textAlign = TextAlign.Center)
            }
            Button(onClick = onCommentClick, modifier = Modifier
                .width(315.dp)
                .height(45.dp)) {
                Text(text = stringResource(id = R.string.sun_home_buttonC)
                    , style = MaterialTheme.typography.titleMedium
                    , textAlign = TextAlign.Center)
            }
        }

    }
}





@Preview(showBackground = true)
@Composable
fun PreviewSunHomeScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        SunHomeScreen(onDescribeClick = {}, onExpressClick = {}, onCommentClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSunHomeScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        SunHomeScreen(onDescribeClick = {}, onExpressClick = {}, onCommentClick = {})
    }
}