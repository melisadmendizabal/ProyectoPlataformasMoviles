package com.uvg.freetofeel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.freetofeel.ui.theme.FreeToFeelTheme


class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent{
        FreeToFeelTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize().safeDrawingPadding(),
            ) { innerPadding ->
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = LoginDestination,        //Cambiar eventualmente
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
                {
                    //Todo el contenido del la lógica de la navegacion
                }
              }
        }
    }
}

}





