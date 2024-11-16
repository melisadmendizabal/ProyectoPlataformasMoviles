package com.uvg.freetofeel

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.LoginBaseDestination
import com.uvg.freetofeel.presentation.loginProfilePresentation.loginBase.loginBaseScreen
import com.uvg.freetofeel.presentation.navigation.AppNavigation
import com.uvg.freetofeel.ui.theme.FreeToFeelTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    private val languageViewModel: LanguageViewModel by viewModels {
        LanguageViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FreeToFeelTheme {
                val context = LocalContext.current
                val navController = rememberNavController()
                val languageCode = languageViewModel.selectedLanguage
                updateLocaleLanguage(context, languageCode)


                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation(
                            navController,
                            context,
                            languageViewModel
                        )
                    }
                }
            }
        }
    }
}





