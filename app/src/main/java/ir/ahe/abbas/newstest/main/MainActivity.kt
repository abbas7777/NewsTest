package ir.ahe.abbas.newstest.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

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
            bottomBar = { BottomNavigation(itemList = itemList, navController) }
        ) { innerPadding ->
            NavHost(
                navController, startDestination = BottomNavItem.Home.route,
                Modifier.padding(innerPadding)
            ) {
            }
        }
    }

    @Composable
    private fun BottomNavigation(
        itemList: List<BottomNavItem>,
        navController: NavController
    ) {

        BottomNavigation {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            itemList.forEach { item ->

                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = item.drawableRes),
                            contentDescription = null
                        )
                    },
                    label = { Text(text = stringResource(id = item.label)) },
                    selected = currentDestination?.hierarchy?.any
                    { it.route == item.route } == true,
                    onClick = {
                        navController.navigate(item.route) {

                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

    @Preview
    @Composable
    private fun Preview() {
        AppScreen()
    }

}