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
    val tasbihCount: Int = 0,
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
    val itemTitle: String = "",
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
    val snooze: String,
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
    @Query("SELECT COUNT(*) FROM notifications WHERE remoteId = :remoteId")
    fun countByRemoteId(remoteId: String): Int
    @Query("SELECT COUNT(*) FROM notifications WHERE isRead = 0")
    fun getUnreadCount(): Flow<Int>
    @Query("DELETE FROM notifications")
    fun deleteAllNotifications()
    @Query("DELETE FROM notifications WHERE id = :id")
    fun deleteNotificationById(id: Int)
    @Update
    fun updateNotification(notification: NotificationEntity)
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