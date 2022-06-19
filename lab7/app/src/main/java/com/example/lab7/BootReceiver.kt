package com.example.lab7

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

import android.provider.Telephony
import android.util.Log
import android.widget.Toast

private const val TAG = "MyBroadcastReceiver"

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        StringBuilder().apply {
            append("Action: ${intent.action}")
            append(" это случилось \n")
            //URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}
            toString().also { log ->
                Log.d(TAG, log)
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }
    }
}