package com.example.viewmodel
import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.database.DailyTracker

class SettingsViewModel(context: Context) : ViewModel() {
    private val _language = MutableStateFlow("en")
    val language: StateFlow<String> = _language
    private val _selectedCountryCode = MutableStateFlow("BD")
    val selectedCountryCode: StateFlow<String> = _selectedCountryCode

    fun setSelectedCountryAndLanguage(code: String) {
        _selectedCountryCode.value = code
    }
}

data class TrackerState(
    val history: List<DailyTracker> = emptyList()
)

class TrackerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TrackerState())
    val uiState: StateFlow<TrackerState> = _uiState
}