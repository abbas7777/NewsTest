package ir.ahe.abbas.newstest.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.ahe.abbas.newstest.main.components.ItemList

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val newsList by homeViewModel.news.collectAsState()
    ItemList(modifier, newsList)
}