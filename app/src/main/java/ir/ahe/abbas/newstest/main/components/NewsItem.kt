package ir.ahe.abbas.newstest.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ir.ahe.abbas.newstest.models.News

@Composable
fun NewsItem(item: News, modifier: Modifier) {
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