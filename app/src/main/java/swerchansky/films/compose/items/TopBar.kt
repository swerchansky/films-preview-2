package swerchansky.films.compose.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import swerchansky.films.R

@Composable
fun TopBar(
    barTitle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 18.dp, end = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = barTitle,
            color = colorResource(R.color.title),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.wrapContentHeight(Alignment.Bottom)
        )
        Image(
            painter = painterResource(R.drawable.search_image),
            contentDescription = "search",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(colorResource(R.color.search_icon)),
            modifier = Modifier
                .size(25.dp)
                .wrapContentHeight(Alignment.Bottom)
        )
    }
}