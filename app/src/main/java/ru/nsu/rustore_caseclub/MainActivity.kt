package ru.nsu.rustore_caseclub

import BadRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.nsu.rustore_caseclub.ui.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val bd = BadRepository(this)
        setContent {
            MainScreen(bd.readAppsFromRaw())
        }
    }
}