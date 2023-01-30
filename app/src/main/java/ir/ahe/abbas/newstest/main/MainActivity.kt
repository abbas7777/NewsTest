package ir.ahe.abbas.newstest.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ir.ahe.abbas.newstest.home.HomeViewModel
import ir.ahe.abbas.newstest.models.News

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

        val itemList = mutableListOf(
            ScreenItem.Home,
            ScreenItem.Category
        )

        BottomNavigation(itemList = itemList)

    }

    @Composable
    private fun BottomNavigation(
        itemList: MutableList<ScreenItem>
    ) {

        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
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
                            label = { Text(text = stringResource(id = item.resourceId)) },
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
        ) { innerPadding ->
            NavHost(
                navController, startDestination = ScreenItem.Home.route,
                Modifier.padding(innerPadding)
            ) {
               // composable()
            }
        }
    }

    @Composable
    private fun HomePage(navController: NavController) {

        val homeViewModel: HomeViewModel by viewModels()

        homeViewModel.getNews(
            "Apple",
            "2023-01-12",
            "popularity",
            "79819d81c81c4b5aa23c25e99ce15029"
        )


    }


    @Preview
    @Composable
    private fun Preview() {
        AppScreen()
    }

}