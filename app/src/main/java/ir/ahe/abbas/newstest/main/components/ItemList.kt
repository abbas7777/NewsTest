package ir.ahe.abbas.newstest.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.ahe.abbas.newstest.models.News

@Composable
 fun ItemList(modifier: Modifier, newsList: List<News>) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = newsList, itemContent = { news ->
            NewsItem(item = news, modifier = modifier)
        })
    }
}