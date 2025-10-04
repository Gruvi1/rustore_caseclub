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
import ru.nsu.rustore_caseclub.ui.AppCard
import ru.nsu.rustore_caseclub.ui.theme.Rustore_caseclubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Rustore_caseclubTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    println(innerPadding)

                    val vkAppInfo = AppInfo(
                        id = 1,
                        name = "VK",
                        category = "Социальные сети",
                        description = "VK — это социальная сеть для общения, обмена медиа и доступа к музыке, видео и сообществам.",
                        icon = "file:///android_asset/vk_icon.png",
                        screenshots = listOf(
                            "https://www.rustore.ru/help/assets/images/download-f690244ac26c7242a94e303d8a03796e.webp",
                            "https://www.rustore.ru/help/assets/images/description-fa26cd4dd77d390831208550893078c6.webp"
                        ),
                        developerCompany = "VK Devs",
                        ageRating = "12+"
                    )

                    AppCard(null, vkAppInfo)
                }
            }
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