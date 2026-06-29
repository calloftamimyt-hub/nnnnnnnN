package com.example.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.database.UserAlarm

class AlarmViewModel(context: Context) : ViewModel() {
    private val _alarms = MutableStateFlow<List<UserAlarm>>(emptyList())
    val alarms: StateFlow<List<UserAlarm>> = _alarms

    fun addAlarm(alarm: UserAlarm) {}
    fun toggleAlarm(alarm: UserAlarm) {}
    fun deleteAlarm(alarm: UserAlarm) {}
}
