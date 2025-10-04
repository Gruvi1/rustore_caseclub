package ru.nsu.rustore_caseclub

import BadRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import ru.nsu.rustore_caseclub.ui.AppCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rep = BadRepository(this)
        enableEdgeToEdge()
        setContent {
            AppCard(navController = null, appInfo = rep.readAppsFromRaw()[3])
        }
    }
}
