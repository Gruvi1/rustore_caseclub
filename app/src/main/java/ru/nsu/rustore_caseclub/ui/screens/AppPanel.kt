package ru.nsu.rustore_caseclub.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.nsu.rustore_caseclub.model.AppInfo
import ru.nsu.rustore_caseclub.ui.getImage

@Composable
fun AppDisplay(appInfo: AppInfo) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    )
    {
        getImage(url = appInfo.icon, modifier = Modifier.size(200.dp))
        Text(text = appInfo.name, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = getShortDescr(appInfo.description), modifier = Modifier.padding(vertical = 4.dp))
        Text(text = appInfo.category, modifier = Modifier.padding(vertical = 4.dp))
    }
}
fun getShortDescr(descr: String) : String {
    if (descr.length > 40) {
        return descr.substring(0, 40) + "..."
    }
    return descr
}

@Preview
@Composable
fun AppDisplayPreview() {
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

    AppDisplay(vkAppInfo)
}