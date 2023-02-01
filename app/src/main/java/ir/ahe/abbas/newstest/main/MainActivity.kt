package ir.ahe.abbas.newstest.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
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
    private fun AppScreen(modifier: Modifier = Modifier) {

        val itemList = mutableListOf(
            ScreenItem.Home,
            ScreenItem.Category
        )

        BottomNavigation(itemList = itemList, modifier = modifier)

    }

    @Composable
    private fun BottomNavigation(
        modifier: Modifier,
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
                composable(ScreenItem.Home.route) {
                    HomePage(
                        modifier,
                        navController = navController
                    )
                }
            }
        }
    }

    @Composable
    private fun HomePage(modifier: Modifier, navController: NavController) {

        val homeViewModel:HomeViewModel by viewModels()

        val newsList by homeViewModel.news.collectAsState()
        ItemList(modifier, newsList)

    }

    @Composable
    private fun ItemList(modifier: Modifier, newsList: List<News>) {

        LazyColumn {

            items(items = newsList, itemContent = {news ->
                NewsItem(item = news, modifier = modifier)

            })


        }
    }

    @Composable
    private fun NewsItem(item: News, modifier: Modifier) {
        Box(
            modifier
                .heightIn(40.dp)
                .width(IntrinsicSize.Max)
        ) {
            Row {
                Card(
                    modifier
                        .height(50.dp)
                        .width(50.dp),
                ) {
                    AsyncImage(
                        model = item.urlToImage,
                        contentDescription = null
                    )
                }

                item.title?.let { Text(text = it) }
            }
        }
    }

    @Preview
    @Composable
    private fun Preview() {
        AppScreen()
    }

}