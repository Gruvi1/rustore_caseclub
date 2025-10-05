package ru.nsu.rustore_caseclub.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.nsu.rustore_caseclub.model.AppInfo

@Composable
fun AppCard(
    appInfo: AppInfo,
    onClick: (AppInfo) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
//            .padding(vertical = 16.dp)
            .clickable {onClick(appInfo)}
    ) {
        Card {


            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(appInfo.icon)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(100.dp)
                )
                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    text = appInfo.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    text = appInfo.category,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    text = getShortDescription(appInfo.description),
                    modifier = Modifier.padding(vertical = 4.dp),
                )
            }
        }
    }
}
private fun getShortDescription(description: String) : String {
    if (description.length > 40) {
        return description.substring(0, 40) + "..."
    }
    return description
}