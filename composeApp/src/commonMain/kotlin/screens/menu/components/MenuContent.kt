package screens.menu.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import webservices.WebServices


@Composable
fun MenuContent() {

    val scope = MainScope()
    var text by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = text)

        scope.launch(Dispatchers.Default) {
            kotlin.runCatching {
                WebServices().getProducts()
            }.onSuccess {
                text = it
            }.onFailure {
                text = it.message.toString()
            }
        }
    }
}

/*    //val products by productsViewModel.productResponse.observeAsState()
    val products = remember { mutableListOf<Product>() }
    //obtener detalle de product
    var selectProduct by remember { mutableStateOf<Product?>(null) }
    var showDetail by remember { mutableStateOf(false) }

    val scope = MainScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {


        LazyRow(
            modifier = Modifier
                .padding(8.dp)
        ) {
            scope.launch(Dispatchers.Default) {
                items(items = products) { product ->
                    ItemProducts(product = product)
                }
            }
        }

        Card(
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxHeight(1f),
            backgroundColor = Color.White,
            contentColor = Color.Black,
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            elevation = 20.dp
        ) {
            if (showDetail && selectProduct != null) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    selectProduct!!.image?.let { painterResource(it) }?.let {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.4f),
                            painter = it,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Price", fontStyle = FontStyle.Italic, fontSize = 35.sp)
                        Spacer(modifier = Modifier.fillMaxWidth(0.5f))
                        Text(
                            text = "$${selectProduct!!.price}",
                            fontStyle = FontStyle.Italic,
                            fontSize = 25.sp
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Name:", fontStyle = FontStyle.Italic, fontSize = 25.sp)
                        selectProduct!!.title?.let {
                            Text(
                                text = it,
                                fontStyle = FontStyle.Italic,
                                fontSize = 25.sp,
                                maxLines = 1,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Description:", fontStyle = FontStyle.Italic, fontSize = 25.sp)
                        selectProduct!!.description?.let {
                            Text(
                                text = "$it...",
                                fontStyle = FontStyle.Italic,
                                fontSize = 20.sp,
                                maxLines = 4
                            )
                        }
                    }
                }
            }
        }
    }*/



































