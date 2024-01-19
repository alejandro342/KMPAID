package screens.menu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import models.Product
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import webservices.WebServices

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ItemProducts(
    product: Product
) {
    val scope = MainScope()


    val image = product.image?.let { painterResource(it) }

    scope.launch(Dispatchers.Default) {
        WebServices().getProducts()
    }
    Card(
        modifier = Modifier
            .padding(top = 60.dp, start = 5.dp)
            .clip(CircleShape),
        elevation = 30.dp
    ) {


        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            painter = image!!,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text("IMAGE: $image")
    }
}