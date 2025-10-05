package ru.nsu.rustore_caseclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.nsu.rustore_caseclub.model.storage.LocalRepository
import ru.nsu.rustore_caseclub.ui.components.FullScreenImage
import ru.nsu.rustore_caseclub.ui.screens.AppScreen
import ru.nsu.rustore_caseclub.ui.screens.AppStoreScreen
import ru.nsu.rustore_caseclub.ui.screens.OnboardingScreen
import ru.nsu.rustore_caseclub.ui.theme.Rustore_caseclubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val bd = LocalRepository(this)

        setContent {
            Rustore_caseclubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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
                                AppScreen(
                                    appInfo = it,
                                    onScreenshotClick = { imageUrl -> navController.navigate("full_screen_image/$imageUrl") },
                                    onBackClick = { navController.popBackStack() }
                                )
                            }
                        }
                        composable(
                            "full_screen_image/{imageUrl}",
                            arguments = listOf(navArgument("imageUrl") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val imageUrl = backStackEntry.arguments?.getString("imageUrl") ?: ""
                            FullScreenImage(
                                imageUrl = imageUrl,
                                onDismiss = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}