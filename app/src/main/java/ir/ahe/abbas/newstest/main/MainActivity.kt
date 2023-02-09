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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
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
    private fun HomePage(
        modifier: Modifier,
        navController: NavController,
        homeViewModel: HomeViewModel = hiltViewModel()
    ) {

        val newsList by homeViewModel.news.collectAsState()
        ItemList(modifier, newsList)

    }

    @Composable
    private fun ItemList(modifier: Modifier, newsList: List<News>) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(items = newsList, itemContent = { news ->
                NewsItem(item = news, modifier = modifier)
            })


        }
    }

    @Composable
    private fun NewsItem(item: News, modifier: Modifier) {
        Box(
            modifier
                .height(80.dp)
                .width(IntrinsicSize.Max)
        ) {
            Row {

                Spacer(modifier.width(12.dp))

                Card(
                    modifier
                        .height(80.dp)
                        .width(80.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    AsyncImage(
                        model = item.urlToImage,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier.width(12.dp))

                Text(
                    text = item.title!!,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
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