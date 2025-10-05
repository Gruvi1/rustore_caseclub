package ru.nsu.rustore_caseclub.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.nsu.rustore_caseclub.model.AppInfo
import ru.nsu.rustore_caseclub.ui.components.AppCard
import ru.nsu.rustore_caseclub.ui.components.FullScreenImage

@Composable
fun AppStoreScreen(
    apps: List<AppInfo>,
    onAppClick: (AppInfo) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp)
    ) {
        items(apps) { app ->
            AppCard(
                appInfo = app,
                onClick = { onAppClick(app) }
            )
        }
    }
}