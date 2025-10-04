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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.nsu.rustore_caseclub.model.AppInfo

@Composable
fun AppDisplay(appInfo: AppInfo) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    )
    {
        AsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fphotobooth.cdn.sports.ru%2Fpreset%2Ftags%2F8%2F5b%2F54e9ce5864397a8a820ff3013a5e2.jpeg&f=1&nofb=1&ipt=19561c7ec7112e07fce518e45112c7c02841e3a5e8a0046bcbadc94d5b3b8d98")
            .crossfade(true)
            .build(),
            contentDescription = "Изображение из интернета",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp))
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
