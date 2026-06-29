package com.example
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.model.*
import com.example.database.UserAlarm

fun Int.toBengaliDigits(): String {
    val english = "0123456789"
    val bengali = "০১২৩৪৫৬৭৮৯"
    var result = this.toString()
    for (i in english.indices) {
        result = result.replace(english[i], bengali[i])
    }
    return result
}

@Composable
fun TrackerScreen(
    onBack: () -> Unit = {},
    viewModel: com.example.viewmodel.SettingsViewModel? = null,
    prayerAlarms: Map<String, Boolean> = emptyMap(),
    onTogglePrayerAlarm: (String) -> Unit = {}
) {}

@Composable
fun TasbihScreen(onBack: () -> Unit) {}

@Composable
fun SavedDuasScreen(onBack: () -> Unit) {}

@Composable
fun SavedHadithsScreen(onBack: () -> Unit) {}

@Composable
fun SettingsScreen(
    onBack: () -> Unit = {},
    viewModel: com.example.viewmodel.SettingsViewModel? = null,
    prayerAlarms: Map<String, Boolean> = emptyMap(),
    onTogglePrayerAlarm: (String) -> Unit = {}
) {}

@Composable
fun ZakatCalculatorScreen(onBack: () -> Unit) {}

@Composable
fun SocialMediaBlockerScreen(onBack: () -> Unit) {}

@Composable
fun WebsiteBlockerScreen(onBack: () -> Unit) {}

@Composable
fun ScreenTimeScreen(onBack: () -> Unit) {}

@Composable
fun SplashScreen(onFinished: () -> Unit) {}
