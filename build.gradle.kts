// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.compose) apply false
  alias(libs.plugins.google.devtools.ksp) apply false
  alias(libs.plugins.roborazzi) apply false
  alias(libs.plugins.secrets) apply false
  alias(libs.plugins.gms.google.services) apply false
  alias(libs.plugins.kotlinx.serialization) apply false
}

tasks.register("generateStubs") {
  doLast {
    val rDir = file("app/src/main/java/com/example/receiver")
    rDir.mkdirs()
    java.io.File(rDir, "AlarmReceiver.kt").writeText("package com.example.receiver\nimport android.content.*\nclass AlarmReceiver : BroadcastReceiver() { override fun onReceive(c: Context, i: Intent) {} }")
    java.io.File(rDir, "AlarmService.kt").writeText("package com.example.receiver\nimport android.app.*\nimport android.content.*\nimport android.os.*\nclass AlarmService : Service() { override fun onBind(i: Intent): IBinder? = null }")
    java.io.File(rDir, "AdhanService.kt").writeText("package com.example.receiver\nimport android.app.*\nimport android.content.*\nimport android.os.*\nclass AdhanService : Service() { override fun onBind(i: Intent): IBinder? = null }")
    java.io.File(rDir, "SilentModeReceiver.kt").writeText("package com.example.receiver\nimport android.content.*\nclass SilentModeReceiver : BroadcastReceiver() { override fun onReceive(c: Context, i: Intent) {} }")
    java.io.File(rDir, "PrayerNotificationReceiver.kt").writeText("package com.example.receiver\nimport android.content.*\nclass PrayerNotificationReceiver : BroadcastReceiver() { override fun onReceive(c: Context, i: Intent) {} }")
    java.io.File(rDir, "DuroodReceiver.kt").writeText("package com.example.receiver\nimport android.content.*\nclass DuroodReceiver : BroadcastReceiver() { override fun onReceive(c: Context, i: Intent) {} }")
    java.io.File(rDir, "MyFirebaseMessagingService.kt").writeText("package com.example.receiver\nimport com.google.firebase.messaging.FirebaseMessagingService\nclass MyFirebaseMessagingService : FirebaseMessagingService() {}")
    java.io.File(rDir, "SilentModeHelper.kt").writeText("package com.example.receiver\nimport android.content.*\nobject SilentModeHelper { fun scheduleSilentAlarms(c: Context) {} }")
    java.io.File(rDir, "AlarmHelper.kt").writeText("package com.example.receiver\nimport android.content.*\nobject AlarmHelper { fun scheduleNextPrayer(context: Context, lat: Double, lng: Double, timezoneOffsetHor: Double, alarms: Map<String, Boolean>, locationName: String, isAuto: Boolean) {} }")
    java.io.File(rDir, "DuroodHelper.kt").writeText("package com.example.receiver\nimport android.content.*\nobject DuroodHelper { fun isEnabled(c: Context)=false; fun getIntervalMins(c: Context)=15; fun isVoiceEnabled(c: Context)=false; fun getSelectedText(c: Context)=\"\"; fun isBusyEnabled(c: Context)=false; fun getBusyStartMins(c: Context)=0; fun getBusyEndMins(c: Context)=0; fun getCustomVoiceUri(c: Context): String? = null; fun saveConfig(c:Context, enabled:Boolean, interval:Int, voice:Boolean, text:String, customVoice:String?, busy:Boolean, start:Int, end:Int) {} }")
    
    val mDir = file("app/src/main/java/com/example")
    java.io.File(mDir, "SocialAccessibilityService.kt").writeText("package com.example\nimport android.accessibilityservice.*\nimport android.view.accessibility.*\nclass SocialAccessibilityService : AccessibilityService() { override fun onAccessibilityEvent(e: AccessibilityEvent) {} override fun onInterrupt() {} }")
    java.io.File(mDir, "SocialBlockerService.kt").writeText("package com.example\nimport android.app.*\nimport android.content.*\nimport android.os.*\nobject SocialBlockerService { fun isPermissionGranted(c: Context)=true; fun startService(c: Context){}; fun stopService(c: Context){} }\nclass SocialBlockerServiceImpl : Service() { override fun onBind(i: Intent): IBinder? = null }")
    
    val wDir = file("app/src/main/java/com/example/widget")
    wDir.mkdirs()
    java.io.File(wDir, "PrayerTimesWidgetProvider.kt").writeText("package com.example.widget\nimport android.appwidget.*\nclass PrayerTimesWidgetProvider : AppWidgetProvider() {}")
    java.io.File(wDir, "NextPrayerWidgetProvider.kt").writeText("package com.example.widget\nimport android.appwidget.*\nclass NextPrayerWidgetProvider : AppWidgetProvider() {}")
    java.io.File(wDir, "SunriseSunsetWidgetProvider.kt").writeText("package com.example.widget\nimport android.appwidget.*\nclass SunriseSunsetWidgetProvider : AppWidgetProvider() {}")
    java.io.File(wDir, "SunriseWidgetProvider.kt").writeText("package com.example.widget\nimport android.appwidget.*\nclass SunriseWidgetProvider : AppWidgetProvider() {}")
    java.io.File(wDir, "SunsetWidgetProvider.kt").writeText("package com.example.widget\nimport android.appwidget.*\nclass SunsetWidgetProvider : AppWidgetProvider() {}")
    java.io.File(wDir, "DateWidgetProvider.kt").writeText("package com.example.widget\nimport android.appwidget.*\nclass DateWidgetProvider : AppWidgetProvider() {}")
    java.io.File(wDir, "WidgetUtils.kt").writeText("package com.example.widget\nimport android.content.*\nobject WidgetUtils { fun pinWidget(c: Context, name: String){}; fun updateAllWidgets(c: Context){} }")

    val xmlDir = file("app/src/main/res/xml")
    xmlDir.mkdirs()
    val xmlTpl = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<appwidget-provider xmlns:android=\"http://schemas.android.com/apk/res/android\" android:minWidth=\"40dp\" android:minHeight=\"40dp\" android:updatePeriodMillis=\"86400000\" android:initialLayout=\"@layout/widget_default\" />"
    java.io.File(xmlDir, "prayer_times_widget_info.xml").writeText(xmlTpl)
    java.io.File(xmlDir, "next_prayer_widget_info.xml").writeText(xmlTpl)
    java.io.File(xmlDir, "sunrise_sunset_widget_info.xml").writeText(xmlTpl)
    java.io.File(xmlDir, "sunrise_widget_info.xml").writeText(xmlTpl)
    java.io.File(xmlDir, "sunset_widget_info.xml").writeText(xmlTpl)
    java.io.File(xmlDir, "date_widget_info.xml").writeText(xmlTpl)
    java.io.File(xmlDir, "accessibility_service_config.xml").writeText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<accessibility-service xmlns:android=\"http://schemas.android.com/apk/res/android\" android:accessibilityEventTypes=\"typeAllMask\" android:accessibilityFeedbackType=\"feedbackGeneric\" android:accessibilityFlags=\"flagDefault\" android:canRetrieveWindowContent=\"true\" />")
    
    val layoutDir = file("app/src/main/res/layout")
    layoutDir.mkdirs()
    java.io.File(layoutDir, "widget_default.xml").writeText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\" android:layout_width=\"match_parent\" android:layout_height=\"match_parent\" android:orientation=\"vertical\"></LinearLayout>")
    
    println("Generated stubs successfully!")
  }
}

tasks.register("generateStubs2") {
  doLast {
    val dbDir = file("app/src/main/java/com/example/database")
    dbDir.mkdirs()
    val dbCode = """
package com.example.database
import androidx.room.*
import android.content.Context
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "tracker")
data class DailyTracker(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String = "",
    val quran: Boolean = false,
    val charity: Boolean = false,
    val reading: Boolean = false,
    val istighfar: Boolean = false,
    val parents: Boolean = false,
    val fajr: Boolean = false,
    val dhuhr: Boolean = false,
    val asr: Boolean = false,
    val maghrib: Boolean = false,
    val isha: Boolean = false
)

@Entity(tableName = "notifications")
data class NotificationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val body: String,
    val timestamp: Long,
    val type: String,
    val actorName: String,
    val remoteId: String,
    val isRead: Boolean = false
)

@Entity(tableName = "alarms")
data class UserAlarm(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val hour: Int,
    val minute: Int,
    val amPm: String,
    val days: String,
    val deleteAfterRinging: Boolean,
    val sound: String,
    val ringtoneUri: String?,
    val label: String,
    val snooze: Boolean,
    val vibrate: Boolean,
    val isEnabled: Boolean = true
)

@Dao
interface NotificationDao {
    @Query("SELECT * FROM notifications ORDER BY timestamp DESC")
    fun getAllNotifications(): Flow<List<NotificationEntity>>
    @Insert
    fun insertNotification(notification: NotificationEntity)
    @Query("UPDATE notifications SET isRead = 1")
    fun markAllAsRead()
}

@Database(entities = [DailyTracker::class, NotificationEntity::class, UserAlarm::class], version = 1, exportSchema = false)
abstract class TrackerDatabase : RoomDatabase() {
    abstract fun notificationDao(): NotificationDao
    companion object {
        @Volatile private var Instance: TrackerDatabase? = null
        fun getDatabase(context: Context): TrackerDatabase =
            Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TrackerDatabase::class.java, "tracker_db").build().also { Instance = it }
            }
    }
}
    """.trimIndent()
    java.io.File(dbDir, "Database.kt").writeText(dbCode)

    val vmDir = file("app/src/main/java/com/example/viewmodel")
    vmDir.mkdirs()
    val vmCode = """
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
    """.trimIndent()
    java.io.File(vmDir, "ViewModels.kt").writeText(vmCode)
    println("Generated viewmodels and DB successfully!")
  }
}
