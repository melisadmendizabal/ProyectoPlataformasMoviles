package com.uvg.freetofeel.presentation.loginProfilePresentation.profileHome

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.R
import com.uvg.freetofeel.SupabaseAuthViewModel
import com.uvg.freetofeel.data.model.UserData

@Composable
fun ProfileHomeROUTE(
    onMyWriteClick: ()-> Unit,
    authViewModel: SupabaseAuthViewModel,
    context: Context,
    onLogOutClick: () -> Unit
){
    ProfileHomeScreen(onMyWriteClick = onMyWriteClick, authViewModel = authViewModel, context = context, onLogOutClick = onLogOutClick)
}

@Composable
fun ProfileHomeScreen(onMyWriteClick: ()-> Unit,authViewModel: SupabaseAuthViewModel,context: Context,onLogOutClick:()->Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.primaryContainer)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(0.5f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {

                Text(text = stringResource(id = R.string.profile_home_greeting), style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.onPrimaryContainer)
                Text(
                    text = "Nombre",    //Cambiarlo por nombre de usuario
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold
                    , color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Apodo", //Cambiarlo por apodo de usuario
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                    , color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                    Box(contentAlignment = Alignment.Center,modifier = Modifier
                        .clip(
                            RoundedCornerShape(15.dp)
                        )
                        .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
                        .size(90.dp)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "150",  //Cambiar según variable del usuario
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primaryContainer)
                            Text(text = stringResource(id = R.string.profile_home_points),
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primaryContainer)

                        }
                    }
                    Box(contentAlignment = Alignment.Center,modifier = Modifier
                        .clip(
                            RoundedCornerShape(15.dp)
                        )
                        .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
                        .size(90.dp)) {
                        Column (horizontalAlignment = Alignment.CenterHorizontally){
                            Text(text = "2",    //Cambiar según variable del usuario
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primaryContainer)
                            Text(text = stringResource(id = R.string.profile_home_days),
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primaryContainer)

                        }
                    }
                    Box(contentAlignment = Alignment.Center,modifier = Modifier
                        .clip(
                            RoundedCornerShape(15.dp)
                        )
                        .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
                        .size(90.dp)) {
                        Column (horizontalAlignment = Alignment.CenterHorizontally){
                            Text(text = "3",    //Cambiar según variable del usuario
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primaryContainer)
                            Text(text = stringResource(id = R.string.profile_home_tips),
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.primaryContainer)
                        }
                    }
                }
            }

        Box(modifier = Modifier.weight(0.5f)) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    ExpandableContent(icono = Icons.Default.FavoriteBorder, title = stringResource(id = R.string.profile_home_iLike), onMyWriteClick = onMyWriteClick)
                }
                item {
                    HorizontalDivider(color = MaterialTheme.colorScheme.onPrimaryContainer, thickness = 1.dp)
                }
                item {
                    ExpandableContent(icono = Icons.Default.Clear, title = stringResource(id = R.string.profile_home_iDisLike), onMyWriteClick = onMyWriteClick)
                }
                item {
                    HorizontalDivider(color = MaterialTheme.colorScheme.onPrimaryContainer, thickness = 1.dp)
                }
                item {
                    ExpandableContent(icono = Icons.Default.Person, title = stringResource(id = R.string.profile_home_aboutMe), onMyWriteClick = onMyWriteClick)
                }
                item {
                    HorizontalDivider(color = MaterialTheme.colorScheme.onPrimaryContainer, thickness = 1.dp)
                }
                item {
                    ExpandableContent(icono = Icons.Default.Edit, title = stringResource(id = R.string.profile_home_myWritings), onMyWriteClick = onMyWriteClick)
                }
                item{
                    Button(onClick = { onLogOutClick()
                        authViewModel.logout(context = context) }) {
                        Text(text = "Padre, me cancelaron")
                    }
                }
            }
        }

    }
}


@Composable
fun ExpandableContent(icono: ImageVector, title: String, onMyWriteClick: ()-> Unit) {
    var isExpanded by remember { mutableStateOf(false) }    //Se muestra el contenido segun el bool

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icono,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )

            if (title == stringResource(id = R.string.profile_home_myWritings)){
                IconButton(
                    onClick = onMyWriteClick
                ) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = if (isExpanded) "Contraer" else "Expandir"
                    )
                }
            } else {
                IconButton(
                    onClick = {
                        isExpanded = !isExpanded
                    }
                ) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = if (isExpanded) "Contraer" else "Expandir"
                    )
                }
            }


        }
        if (title != stringResource(id = R.string.profile_home_myWritings)) {

            if (isExpanded) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp)
                ) {
                    UniqueData()        //Aqui habría que hacer que se cree por cuantos haya en una lista (de inputs del usuario)
                }
            }
        }
    }
}



@Composable
fun UniqueData() {
    Spacer(modifier = Modifier.height(5.dp))
    ElevatedCard(
        onClick = { /*TODO*/ }, modifier = Modifier
            .height(200.dp)
            .width(300.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = MaterialTheme.colorScheme.surfaceContainer) //cambiar color a electo por usuario
    )
    {

        Box(modifier = Modifier.fillMaxSize()) {

            Text(
                text = "Titulo",    //Ingresado por el usuario
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.TopStart)
                , textAlign = TextAlign.Left
                , style = MaterialTheme.typography.titleMedium
                , fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Texto del usuario abcdefghijklmnopqrstuñññññññ",  //Ingresado por el usuario
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.TopCenter)
                , textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Button(onClick = { /* Acción del botón 1 */ }) {
                    Text(text= stringResource(id = R.string.profile_home_viewB))
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
fun PreviewProfileHomeScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        ProfileHomeScreen(onMyWriteClick = {}, authViewModel = SupabaseAuthViewModel(), context = LocalContext.current, onLogOutClick = {})
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewProfileHomeScreenDark() {
    MaterialTheme(
        colorScheme = darkColorScheme() // DarkMode
    ) {
        ProfileHomeScreen(onMyWriteClick = {}, authViewModel = SupabaseAuthViewModel(), context = LocalContext.current, onLogOutClick = {})
    }
}