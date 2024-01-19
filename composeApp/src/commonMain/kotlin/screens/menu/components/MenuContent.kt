package screens.menu.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
        Text(text = text) // Llama a Text() fuera de la coroutine

        scope.launch(Dispatchers.Default) {
            kotlin.runCatching {
                WebServices().getProducts()
            }.onSuccess {
                text = it.toString() // Convertir el resultado a un string
            }.onFailure {
                text = it.message.toString() // Actualiza el estado en caso de error
            }
        }
    }
}






































