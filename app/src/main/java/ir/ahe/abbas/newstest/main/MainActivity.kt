package ir.ahe.abbas.newstest.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.ahe.abbas.newstest.home.HomePage

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppScreen()
        }
    }

    @Composable
    private fun AppScreen() {

        val itemList = listOf(
            BottomNavItem.Home,
            BottomNavItem.Category
        )
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                ir.ahe.abbas.newstest.main.components.BottomNavigation(
                    itemList = itemList,
                    navController
                )
            }
        ) { innerPadding ->
            NavHost(
                navController, startDestination = BottomNavItem.Home.route,
                Modifier.padding(innerPadding)
            ) {
                composable(BottomNavItem.Home.route) {
                    HomePage(
                        navController = navController
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    private fun Preview() {
        AppScreen()
    }

}