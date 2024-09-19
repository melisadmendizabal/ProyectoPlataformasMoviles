package com.uvg.freetofeel

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.freetofeel.loginBase.LoginBaseDestination
import com.uvg.freetofeel.loginBase.loginBaseScreen
import com.uvg.freetofeel.ui.theme.FreeToFeelTheme
import java.util.Locale


class MainActivity : ComponentActivity() {
    private val languageViewModel: LanguageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
        setContent{
        FreeToFeelTheme {
            val context = LocalContext.current
            val languageCode = languageViewModel.selectedLanguage
            updateLocaleLanguage(context, languageCode)

            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding(),
            ) {
                innerPadding ->

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = LoginBaseDestination,        //Cambiar eventualmente
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
                {
                    loginBaseScreen(onButtonClick = {},context,languageViewModel)
                //Todo el contenido del la lógica de la navegacion
                }
              }
        }
    }
}

}

public fun updateLocaleLanguage(context: Context, languageCode:String){
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val config = context.resources.configuration
    config.setLocale(locale)
    context.resources.updateConfiguration(config,context.resources.displayMetrics)
}



