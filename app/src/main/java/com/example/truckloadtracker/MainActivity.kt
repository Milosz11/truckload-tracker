package com.example.truckloadtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.truckloadtracker.ui.TruckloadApp
import com.example.truckloadtracker.ui.theme.TruckloadTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TruckloadTrackerTheme {
                TruckloadApp()
            }
        }
    }
}
