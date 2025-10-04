package ru.nsu.rustore_caseclub.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.nsu.rustore_caseclub.model.AppInfo
import ru.nsu.rustore_caseclub.model.Model

@Composable
fun MainScreen(apps: List<AppInfo>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp)
    ) {
        items(apps) { app ->
            AppDisplay(app)
        }
    }
}
