package ru.nsu.rustore_caseclub.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.nsu.rustore_caseclub.R
import ru.nsu.rustore_caseclub.model.AppInfo

@Composable
fun CardHeader(name: String, developer: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Blue)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(name)
            Text(developer)
        }
    }
}

@Composable
fun MetaData(category: String, restrict: String) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(category)
        Text("${stringResource(R.string.restrict)}: $restrict")
    }
}

@Composable
fun ScreenShots(imageList: List<String>) {
    val imageUrl = remember { mutableStateOf("") }
    val showFullScreen = remember { mutableStateOf(false) }

    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(imageList.size) { index ->
            Card(modifier = Modifier
                .clickable {
                    imageUrl.value = imageList[index]
                    showFullScreen.value = true
                           },
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageList[index])
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(4.dp)
                )
            }
        }
    }

    if (showFullScreen.value) {
        Dialog(
            onDismissRequest = { showFullScreen.value = false },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .clickable { showFullScreen.value = false },
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun FullDescription(description: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = stringResource(R.string.description), fontWeight = FontWeight.Bold)
        Text(description)
    }
}

@Composable
fun AppCard(appInfo: AppInfo) {
    Scaffold(
        modifier = Modifier
            .padding(top = 24.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text("Back")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            CardHeader(name = appInfo.name, developer = appInfo.developerCompany)
            Spacer(modifier = Modifier.height(8.dp))
            MetaData(category = appInfo.category, restrict = appInfo.ageRating)
            ScreenShots(imageList = appInfo.screenshots)
            Spacer(modifier = Modifier.height(8.dp))
            FullDescription(description = appInfo.description)
        }
    }
}

@Preview
@Composable
fun AppCardPreview() {
    val vkAppInfo = AppInfo(
        id = 1,
        name = "VK",
        category = "Социальные сети",
        description = "VK — это социальная сеть для общения, обмена медиа и доступа к музыке, видео и сообществам.",
        icon = "file:///android_asset/vk_icon.png",
        screenshots = listOf(
            "https://www.rustore.ru/help/assets/images/download-f690244ac26c7242a94e303d8a03796e.webp",
            "https://www.rustore.ru/help/assets/images/description-fa26cd4dd77d390831208550893078c6.webp",
            "https://www.rustore.ru/help/assets/images/download-f690244ac26c7242a94e303d8a03796e.webp",
            "https://www.rustore.ru/help/assets/images/description-fa26cd4dd77d390831208550893078c6.webp"
        ),
        developerCompany = "VK Devs",
        ageRating = "12+"
    )

    AppCard(appInfo = vkAppInfo)
}