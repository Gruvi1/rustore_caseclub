package ru.nsu.rustore_caseclub.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import ru.nsu.rustore_caseclub.model.AppInfo

@Composable
fun AppScreen(appInfo: AppInfo) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            AppHeader(appInfo = appInfo)
        }

        item {
            AppDescription(description = appInfo.description)
        }

        item {
            ScreenshotsCarousel(screenshots = appInfo.screenshots)
        }

        item {
            InstallButton()
        }
    }
}

@Composable
private fun AppHeader(appInfo: AppInfo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        AsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data(appInfo.icon)
            .crossfade(true)
            .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp))

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = appInfo.name, modifier = Modifier.padding(vertical = 4.dp))

            Text(
                text = appInfo.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = appInfo.category,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = appInfo.ageRating,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun AppDescription(description: String) {
    Card {
        Text(
            text = description,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun ScreenshotsCarousel(screenshots: List<String>) {
    LazyRow {
        items(screenshots) { screenshotUrl ->
            AsyncImage(
                model = screenshotUrl,
                contentDescription = "Скриншот приложения",
                modifier = Modifier
                    .size(200.dp, 120.dp)
                    .padding(horizontal = 4.dp)
            )
        }
    }
}

@Composable
private fun InstallButton() {
    Button(
        onClick = { /* Установка */ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Установить")
    }
}