package com.uvg.freetofeel.loginBase

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.freetofeel.LanguageViewModel
import com.uvg.freetofeel.R


@Composable
fun LoginRoute(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    languageViewModel: LanguageViewModel
) {
    LoginBaseScreen(LocalContext.current,languageViewModel)
}



@Composable
fun LoginBaseScreen(context: Context,languageViewModel: LanguageViewModel) {
    Box(modifier = Modifier.fillMaxWidth()
        .fillMaxHeight()
        .background(color = MaterialTheme.colorScheme.inversePrimary) //Cambiar cuando se tengan los colores reales
        ,contentAlignment = Alignment.BottomCenter)
    {
        Image(
            painter = painterResource(id = R.drawable.cloud_bot),
            contentDescription = "Nubes Inferiores",
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.BottomCenter,

            )
    }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ) {
            Icon(Icons.Default.Face, contentDescription = "", modifier = Modifier.weight(0.35f))
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxSize(), contentAlignment = Alignment.TopCenter
            )
            {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {


                    Text(
                        text = stringResource(id = R.string.welcome_message),
                        style = MaterialTheme.typography.displayLarge

                    )

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(200.dp)
                            .height(40.dp),
                        //colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)      Cuando ya se tenga colores, cambiarlo acá.
                    ) {
                        Text(
                            text = stringResource(id = R.string.login_text),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .width(200.dp)
                            .height(40.dp)
                            .padding()
                    ) {
                        Text(
                            text = stringResource(id = R.string.new_account_text),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick =
                {
                    languageViewModel.updateLanguage("es"); (context as? Activity)?.recreate()
                }) {
                    Text(text = "Español")

                }
                Button(onClick =
                {
                    languageViewModel.updateLanguage("en")
                    (context as? Activity)?.recreate()
                }) {
                    Text(text = "English")

                }
            }


        }
    }




// Sección de previews
@Preview(showBackground = true)
@Composable
fun PreviewLoginBaseScreen() {
    val languageViewModel = LanguageViewModel()
    // Aquí puedes usar un color sólido o una imagen de prueba
    LoginBaseScreen(context = LocalContext.current, languageViewModel = languageViewModel)
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLoginBaseScreenDark() {
    // Simula un contexto para la vista previa
    val languageViewModel = LanguageViewModel() // Crea una instancia del ViewModel
    val context = LocalContext.current // Obtén el contexto

    // Aplica el tema oscuro
    MaterialTheme(
        colorScheme = darkColorScheme() // DarkMode
    ) {
        LoginBaseScreen(context = context, languageViewModel = languageViewModel)
    }
}




