package ru.nsu.rustore_caseclub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
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
fun ScreenShots(imageList: List<Int>) {
    LazyRow {
        items(imageList.size) { index ->
            Image(
                painter = painterResource(id = imageList[index]),
                contentDescription = "Photo ${index + 1}",
                modifier = Modifier
                    .size(120.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )
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
fun AppCard(
    navController: NavController?,
    appInfo: AppInfo
) {
    val imageList = listOf(
        R.drawable.screen1,
        R.drawable.screen2
    )

    Scaffold(
        topBar = {
            Button(onClick = {  }) {
                Text("Go back")
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
            ScreenShots(imageList = imageList)
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
        iconContent = "file:///android_asset/vk_icon.png",
        screenshots = listOf(
            "file:///android_asset/vk_screenshot1.png",
            "file:///android_asset/vk_screenshot2.png",
            "file:///android_asset/vk_screenshot3.png"
        ),
        developerCompany = "VK Devs",
        ageRating = "12+"
    )

    AppCard(navController = null, appInfo = vkAppInfo)
}