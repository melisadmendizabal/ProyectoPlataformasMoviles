package com.uvg.freetofeel.presentation.challengePresenation.challengeHome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.R
import com.uvg.freetofeel.LanguageViewModel

@Composable
fun ChallengeHomeROUTE(
    onSelect: (Any) -> Unit

){
    ChallengeHomeScreen(
        onSelect = onSelect
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChallengeHomeScreen(onSelect:(Any)->Unit) {
    var inputText by remember { mutableStateOf("") }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val waaa = List(60){ stringResource(id = R.string.challenge_column1)}

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
        Box(Modifier.padding(vertical = 10.dp, horizontal = 5.dp)) {
            LazyColumn{
                items(waaa.chunked(2)) { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        for (item in rowItems) {
                            itemsLazyColumn(valueitem = item,
                                modifier = Modifier.weight(1f)){onSelect(item)}
                        }
                    }

                }

            }

        }
    }
}

@Composable
fun itemsLazyColumn(valueitem: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(6.dp))
            .border(BorderStroke(2.dp, MaterialTheme.colorScheme.primary))
            .background(MaterialTheme.colorScheme.primary)
            .clickable(onClick = onClick)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(6.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pug),
                    contentDescription = "consejo",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Box(Modifier.fillMaxWidth()) {
                Text(
                    text = valueitem,
                    Modifier.padding(horizontal = 9.dp, vertical = 3.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
@Composable
fun itemsLazyRow(valueitem: String){
    Box(modifier = Modifier
        .padding(5.dp)
        .clip(RoundedCornerShape(6.dp))
        .border(BorderStroke(2.dp, MaterialTheme.colorScheme.onPrimary))
        .background(MaterialTheme.colorScheme.onPrimary)
    ){
        Text(text = valueitem,
            Modifier.padding(horizontal = 9.dp, vertical = 3.dp),
            color = MaterialTheme.colorScheme.primary)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSUnRecoScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        val languageViewModel = LanguageViewModel()
        ChallengeHomeScreen(onSelect = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDailyRecoScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        val languageViewModel = LanguageViewModel()
        ChallengeHomeScreen(onSelect = {})
    }
}