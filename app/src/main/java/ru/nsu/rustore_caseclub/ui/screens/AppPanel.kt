package ru.nsu.rustore_caseclub.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import ru.nsu.rustore_caseclub.model.AppInfo

@Composable
fun AppDisplay(appInfo: AppInfo) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    )
    {

        Text(text = appInfo.name, modifier = Modifier.padding(vertical = 4.dp))
        Text(text = getShortDescr(appInfo.description), modifier = Modifier.padding(vertical = 4.dp))
        Text(text = appInfo.category, modifier = Modifier.padding(vertical = 4.dp))
    }
}
fun getShortDescr(descr: String) : String {
    if (descr.length > 40) {
        return descr.substring(0, 40)
    }
    return descr
}
