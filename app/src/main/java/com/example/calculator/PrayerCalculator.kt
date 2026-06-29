package com.example.calculator

import java.util.Calendar

data class PrayerTimes(
    val fajr: String = "",
    val sunrise: String = "",
    val dhuhr: String = "",
    val asr: String = "",
    val maghrib: String = "",
    val isha: String = "",
    val fajrHours: Double = 0.0,
    val sunriseHours: Double = 0.0,
    val dhuhrHours: Double = 0.0,
    val asrHours: Double = 0.0,
    val maghribHours: Double = 0.0,
    val ishaHours: Double = 0.0
)

object PrayerCalculator {
    fun calculatePrayerTimes(
        lat: Double,
        lng: Double,
        offset: Double,
        madhab: Int,
        calendar: Calendar? = null
    ): PrayerTimes {
        return PrayerTimes(
            fajr = "05:00", sunrise = "06:00", dhuhr = "12:00", asr = "15:00", maghrib = "18:00", isha = "19:00",
            fajrHours = 5.0, sunriseHours = 6.0, dhuhrHours = 12.0, asrHours = 15.0, maghribHours = 18.0, ishaHours = 19.0
        )
    }
}
