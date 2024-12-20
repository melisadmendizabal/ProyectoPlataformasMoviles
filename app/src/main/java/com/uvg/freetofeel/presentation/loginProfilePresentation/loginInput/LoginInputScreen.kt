package com.uvg.freetofeel.presentation.loginProfilePresentation.loginInput

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R
import com.uvg.freetofeel.SupabaseAuthViewModel
import com.uvg.freetofeel.data.model.UserLoginState

@Composable
fun LoginInputROUTE(
    onLoginStartClick: ()->Unit,
    authViewModel: SupabaseAuthViewModel,
    context: Context
){
    LoginInputScreen(onLoginStartClick = onLoginStartClick,
        authViewModel = authViewModel,
        context = context)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginInputScreen(
                     onLoginStartClick: ()->Unit,
                     authViewModel: SupabaseAuthViewModel,
                     context: Context)
{
    var inputUser by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    val userState by authViewModel.userState
    val isLoading = userState is UserLoginState.Loading

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

    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = stringResource(id = R.string.login_input_title1), textAlign = TextAlign.Center, style = MaterialTheme.typography.displayLarge)
        Text(text = stringResource(id =R.string.login_input_title2), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = inputUser,
            onValueChange = {inputUser = it},
            shape = CircleShape,
            label = { Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { Text(text = stringResource(
                id = R.string.LI_email
            )
                ,textAlign = TextAlign.Center) } },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
            ,modifier = Modifier
                .width(315.dp)
                .height(60.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            )

        )

        OutlinedTextField(
            value = inputPassword,
            onValueChange = {inputPassword = it},
            shape = CircleShape,
            label = { Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { Text(text = stringResource(
                id = R.string.OTF_password1
            )
                ,textAlign = TextAlign.Center) } },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
            ,modifier = Modifier
                .width(315.dp)
                .height(60.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer
            )

        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {onLoginStartClick()
        authViewModel.login(context = context, userEmail = inputUser, userPassword = inputPassword)}, enabled = !isLoading)
        {
            Text(text = stringResource(id = R.string.login_button))
        }

    }

}







@Preview(showBackground = true)
@Composable
fun PreviewNewAccountScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {

        LoginInputScreen(onLoginStartClick = {}, authViewModel = SupabaseAuthViewModel(), context = LocalContext.current)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewAccountScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {


        LoginInputScreen(onLoginStartClick = {}, authViewModel = SupabaseAuthViewModel(), context = LocalContext.current)
    }
}