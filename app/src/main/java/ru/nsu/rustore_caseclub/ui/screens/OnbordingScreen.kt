package ru.nsu.rustore_caseclub.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.rustore_caseclub.R

@Composable
fun DisplayOnboarding() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.rustore_logo),
            contentDescription = "Логотип RuStore",
            modifier = Modifier.size(128.dp) // размер картинки
        )

        Spacer(modifier = Modifier.height(16.dp)) // отступ между картинкой и текстом

        Text(
            text = "Добро пожаловать в RuStore!",
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}