package ru.nsu.rustore_caseclub.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.nsu.rustore_caseclub.model.Model

@Composable
fun AppCard(modifier: Modifier, model: Model?, navController: NavController?, appId: Int) {
    Scaffold(
        topBar = {
            Button(onClick = { println("Вернуться назад") }) {
                Text("Go back")
            }
        },
        bottomBar = {
            Text("hee")
        }
    ) {
        innerPadding ->
        println(innerPadding)
    }
}

@Preview
@Composable
fun AppCardPreview() {
    AppCard(modifier = Modifier.padding(24.dp), model = null, navController = null, 10)
}