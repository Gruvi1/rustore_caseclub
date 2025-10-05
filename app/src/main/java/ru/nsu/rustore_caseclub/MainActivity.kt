package ru.nsu.rustore_caseclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.nsu.rustore_caseclub.model.storage.BadRepository
import ru.nsu.rustore_caseclub.ui.screens.AppScreen
import ru.nsu.rustore_caseclub.ui.screens.AppStoreScreen
import ru.nsu.rustore_caseclub.ui.screens.OnboardingScreen
import ru.nsu.rustore_caseclub.ui.theme.Rustore_caseclubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val bd = BadRepository(this)

        setContent {
            Rustore_caseclubTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "onboarding"
                ) {
                    composable("onboarding") {
                        OnboardingScreen(navController = navController)
                    }
                    composable("app_store") {
                        AppStoreScreen(
                            apps = bd.getList(),
                            onAppClick = { appInfo ->
                                navController.navigate("app_detail/${appInfo.id}")
                            }
                        )
                    }
                    composable(
                        "app_detail/{appId}",
                        arguments = listOf(navArgument("appId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val appId = backStackEntry.arguments?.getString("appId") ?: return@composable
                        val appInfo = bd.getAppById(appId)
                        appInfo?.let {
                            AppScreen(appInfo = it)
                        }
                    }
                }
            }
        }
    }
}