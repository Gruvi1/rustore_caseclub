package ru.nsu.rustore_caseclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.nsu.rustore_caseclub.model.AppInfo
import ru.nsu.rustore_caseclub.ui.screens.AppDisplay
import ru.nsu.rustore_caseclub.ui.theme.Rustore_caseclubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val vkApp = AppInfo (
            id = 1,
            name = "VK",
            category = "Социальные сети",
            description = "VK — это социальная сеть для общения, обмена медиа и доступа к музыке, видео и сообществам.",
            iconContent = "file:///android_asset/vk_icon.png",
            screenshots = listOf(
                "file:///android_asset/vk_screenshot1.png",
                "file:///android_asset/vk_screenshot2.png",
                "file:///android_asset/vk_screenshot3.png"
            ),
            developerCompany = "VK Devs",
            ageRating = "12+"
        )



        setContent {
            AppDisplay(vkApp)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Rustore_caseclubTheme {
        Greeting("Android")
    }
}