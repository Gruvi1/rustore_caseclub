package ru.nsu.rustore_caseclub.ui.screens

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.nsu.rustore_caseclub.R
import ru.nsu.rustore_caseclub.model.Model

@Composable
fun CardHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
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
            Text("Название")
            Text("Разработчик")
        }
    }
}

@Composable
fun MetaData(modifier: Modifier = Modifier) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Категория приложения")
        Text("Возраст: 0+")
    }
}

@Composable
fun ScreenShots() {
    val imageList = listOf(
        R.drawable.screen1,
        R.drawable.screen2
    )

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
fun FullDescription() {
    Column {

    }
}

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    model: Model?,
    navController: NavController?,
    appId: Int
) {
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
            CardHeader()
            Spacer(modifier = Modifier.height(8.dp))
            MetaData()
            ScreenShots()
            FullDescription()
        }
    }
}

@Preview
@Composable
fun AppCardPreview() {
    AppCard(modifier = Modifier.padding(20.dp), model = null, navController = null, appId = 10)
}