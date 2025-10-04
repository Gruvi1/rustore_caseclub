package ru.nsu.rustore_caseclub.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.nsu.rustore_caseclub.R
import ru.nsu.rustore_caseclub.model.AppInfo

@Composable
fun ShowCaseTopBar() {
    Row(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(R.string.showcase_topbar),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppShowCaseCard(appInfo: AppInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        onClick = {

        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Blue)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = appInfo.name,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = appInfo.description,
                    maxLines = 1,
                    fontSize = 12.sp
                )
                Text(
                    maxLines = 1,
                    text = appInfo.category,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun AppShowCase(navController: NavController?, appInfos: List<AppInfo>) {
    Scaffold(
        modifier = Modifier
            .padding(top = 24.dp),
        topBar = {
            ShowCaseTopBar()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(appInfos) { info ->
                AppShowCaseCard(info)
            }
        }
    }
}

@Preview
@Composable
fun AppShowCasePreview() {
    val vkAppInfo = AppInfo(
        id = 1,
        name = "ВКонтакте",
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

    val appInfos = List(15) { vkAppInfo }

    AppShowCase(navController = null, appInfos = appInfos)
}