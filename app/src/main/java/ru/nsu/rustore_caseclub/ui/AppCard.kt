package ru.nsu.rustore_caseclub.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
        }
    }
}

@Preview
@Composable
fun AppCardPreview() {
    AppCard(modifier = Modifier.padding(20.dp), model = null, navController = null, appId = 10)
}