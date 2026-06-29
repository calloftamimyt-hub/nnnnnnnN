package com.example
import android.app.*
import android.content.*
import android.os.*
object SocialBlockerService { fun isPermissionGranted(c: Context)=true; fun startService(c: Context){}; fun stopService(c: Context){} }
class SocialBlockerServiceImpl : Service() { override fun onBind(i: Intent): IBinder? = null }