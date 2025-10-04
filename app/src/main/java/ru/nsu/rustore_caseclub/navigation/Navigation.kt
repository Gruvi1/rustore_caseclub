package ru.nsu.rustore_caseclub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.nsu.rustore_caseclub.model.AppInfo
import ru.nsu.rustore_caseclub.ui.AppCard
import ru.nsu.rustore_caseclub.ui.screens.AppShowCase

@Composable
fun Navigation(apps: List<AppInfo>) {
    val navController = rememberNavController()

    NavHost(navController, "app_list") {
        composable("app_list") {
            AppShowCase(apps) { appId ->
                navController.navigate("app_detail/$appId")
            }
        }

        composable(
            "app_detail/{appId}",
            arguments = listOf(navArgument("appId") { type = NavType.StringType })
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getString("appId")
            val app = apps.find { it.id.toString() == appId }
            if (app != null) {
                AppCard(appInfo = app)
            }
        }
    }
}

@Preview
@Composable
fun NavigationPreview() {
    val vkAppInfo = AppInfo(
        id = 1,
        name = "ВКонтакте",
        category = "Социальные сети",
        description = "VK — это социальная сеть для общения, обмена медиа и доступа к музыке, видео и сообществам.",
        icon = "file:///android_asset/vk_icon.png",
        screenshots = listOf(
            "https://www.rustore.ru/help/assets/images/download-f690244ac26c7242a94e303d8a03796e.webp",
            "https://www.rustore.ru/help/assets/images/description-fa26cd4dd77d390831208550893078c6.webp"
        ),
        developerCompany = "VK Devs",
        ageRating = "12+"
    )

    val appInfos = List(15) { vkAppInfo }

    Navigation(appInfos)
}