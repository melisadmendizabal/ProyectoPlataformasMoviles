package com.uvg.freetofeel.profileData

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.freetofeel.R

@Composable
fun ProfileDataScreen() {
    var itemsList by remember { mutableStateOf(mutableListOf<Pair<String, String>>()) }
    var titleInput by remember { mutableStateOf("") }
    var textInput by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)) {
        TextField(
            value = titleInput,
            onValueChange = { titleInput = it },
            label = { Text(text= stringResource(id = R.string.profile_data_dateTitle)) },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = textInput,
            onValueChange = { textInput = it },
            label = { Text(text= stringResource(id = R.string.profile_data_text)) },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (titleInput.isNotBlank() && textInput.isNotBlank()) {
                    itemsList.add(Pair(titleInput, textInput))
                    titleInput = ""
                    textInput = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text= stringResource(id = R.string.profile_data_addB))
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(itemsList) { item ->
                UniqueData(title = item.first, text = item.second)
            }
        }
    }
}

@Composable
fun UniqueData(title: String, text: String) {
    Spacer(modifier = Modifier.height(5.dp))
    Card(
        onClick = { /* TODO */ },
        modifier = Modifier
            .height(200.dp)
            .width(300.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = title,
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.TopStart),
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = text,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.TopCenter),
                textAlign = TextAlign.Center,
                fontSize = 14.sp
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Button(onClick = { /* Acción del botón 1 */ }) {
                    Text(text = stringResource(id = R.string.profile_home_viewB))
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { /* Acción del botón 2 */ }) {
                    Text(text = stringResource(id = R.string.profile_home_editB))
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewProfileDataScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        ProfileDataScreen()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewProfileDataScreenDark() {
    MaterialTheme(
        colorScheme = darkColorScheme() // DarkMode
    ) {
        ProfileDataScreen()
    }
}