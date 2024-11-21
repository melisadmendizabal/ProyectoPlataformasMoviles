package com.uvg.freetofeel.presentation.loginProfilePresentation.newAccount

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R
import com.uvg.freetofeel.SupabaseAuthViewModel

@Composable
fun NewAccountROUTE(
    onCreateAccountClick:() -> Unit,
    authViewModel: SupabaseAuthViewModel,
    context: Context
){
    NewAccountScreen(
        onCreateAccountClick = onCreateAccountClick,
        authViewModel = authViewModel,
        context = context
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewAccountScreen(
                     onCreateAccountClick:() -> Unit,
                     authViewModel: SupabaseAuthViewModel,
                     context: Context)
    {
    var inputUser by remember { mutableStateOf("")}
    var inputEmail by remember { mutableStateOf("")}
    var inputPassword by remember { mutableStateOf("")}
    var inputPassword2 by remember { mutableStateOf("")}
    var isButtonEnabled by remember { mutableStateOf(false) }
    var isPasswordVisible by remember { mutableStateOf(false) }


    LaunchedEffect(inputPassword, inputPassword2) {
        isButtonEnabled = inputPassword == inputPassword2 && inputPassword.isNotEmpty()
    }
    val passwordVisualTransformation: VisualTransformation =
        if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()


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

    Text(text = stringResource(id = R.string.new_account_welcome1), textAlign = TextAlign.Center, style = MaterialTheme.typography.displayLarge)
    Text(text = stringResource(id = R.string.new_account_welcome2), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.displayLarge)
    Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
        value = inputUser,
        onValueChange = {inputUser = it},
        shape = CircleShape,
        label = { Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { Text(text = stringResource(
            id = R.string.OTF_user
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
            value = inputEmail,
            onValueChange = {inputEmail = it},
            shape = CircleShape,
            label = { Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) { Text(text = stringResource(
                id = R.string.OTF_email
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
            onValueChange = { inputPassword = it },
            shape = CircleShape,
            label = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.OTF_password1),
                        textAlign = TextAlign.Center
                    )
                }
            },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),

            visualTransformation = passwordVisualTransformation,
            modifier = Modifier
                .width(315.dp)
                .height(60.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer
            )
        )
        OutlinedTextField(
            value = inputPassword2,
            onValueChange = { inputPassword2 = it },
            shape = CircleShape,
            label = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.OTF_password2),
                        textAlign = TextAlign.Center
                    )
                }
            },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            visualTransformation = passwordVisualTransformation,
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                        contentDescription = null
                    )
                }
            },
            modifier = Modifier
                .width(315.dp)
                .height(60.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer
            )
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {onCreateAccountClick()
            authViewModel.signUp(context = context, userEmail = inputEmail, userPassword = inputPassword)
                         authViewModel.saveUserData(name = inputUser, points = 0)}
            , enabled = isButtonEnabled) {
         Text(text = stringResource(id = R.string.CreateAcc))
        }
    }

}



@Preview(showBackground = true)
@Composable
fun PreviewNewAccountScreenLight() {
    MaterialTheme(colorScheme = lightColorScheme()) {

        NewAccountScreen( onCreateAccountClick = {}, authViewModel = SupabaseAuthViewModel(), context = LocalContext.current)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewAccountScreenDark() {
    MaterialTheme(colorScheme = darkColorScheme()) {


        NewAccountScreen( onCreateAccountClick = {}, authViewModel = SupabaseAuthViewModel(), context = LocalContext.current)
    }
}