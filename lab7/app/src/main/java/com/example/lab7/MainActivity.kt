package com.example.lab7

import android.Manifest
import android.app.job.JobInfo
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val br: BroadcastReceiver = MyBroadcastReceiver()

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        Log.d(MainActivity::class.simpleName, "Permission result: $it")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val filter1 = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        val filter2 = IntentFilter(  Intent.ACTION_SCREEN_ON)
        val filter3 = IntentFilter(Intent.ACTION_BATTERY_LOW)
        registerReceiver(br, filter1)
        registerReceiver(br, filter2)
        registerReceiver(br, filter3)
    }

    override fun onResume() {
        super.onResume()
        requestPermissionLauncher.launch(Manifest.permission.CAMERA)
    }
}