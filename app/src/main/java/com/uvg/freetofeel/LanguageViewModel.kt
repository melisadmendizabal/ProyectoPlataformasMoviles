package com.uvg.freetofeel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


//Clase creada para manejar los idiomas de la aplicación.
//De esta manera, la app siempre sabe cuál fue el idioma seleccionado por el usuario.

class LanguageViewModel : ViewModel() {
    var selectedLanguage by mutableStateOf("es") // Idioma predeterminado: español

    fun updateLanguage(languageCode: String) {
        selectedLanguage = languageCode
    }
}