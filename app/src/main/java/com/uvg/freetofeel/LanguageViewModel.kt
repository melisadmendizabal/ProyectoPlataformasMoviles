package com.uvg.freetofeel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.Locale

class LanguageViewModel(private val context: Context) : ViewModel() {

    var selectedLanguage by mutableStateOf(loadLanguage()) // Cargar el idioma desde SharedPreferences

    // Actualizar el idioma
    fun updateLanguage(languageCode: String) {
        selectedLanguage = languageCode
        saveLanguage(languageCode)
    }

    // Guardar el idioma en SharedPreferences
    private fun saveLanguage(languageCode: String) {
        val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("selected_language", languageCode)
            apply()
        }
    }

    // Cargar el idioma desde SharedPreferences
    private fun loadLanguage(): String {
        val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        return sharedPref.getString("selected_language", "es") ?: "es" // Idioma predeterminado: español
    }
}


class LanguageViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LanguageViewModel::class.java)) {
            return LanguageViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

public fun updateLocaleLanguage(context: Context, languageCode:String){
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val config = context.resources.configuration
    config.setLocale(locale)
    context.resources.updateConfiguration(config,context.resources.displayMetrics)
}


