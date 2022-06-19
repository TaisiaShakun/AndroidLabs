package com.example.lab7
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ExampleBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action) {
            Intent.ACTION_BATTERY_OKAY -> batteryOkay()
            Intent.ACTION_BATTERY_LOW -> batteryLow()
            Intent.ACTION_CAMERA_BUTTON -> camera()
        }
    }
    private fun camera() = Unit
    private fun batteryLow() = Unit
    private fun batteryOkay() = Unit
}