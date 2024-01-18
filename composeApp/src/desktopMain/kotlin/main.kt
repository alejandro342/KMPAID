import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LogoDev
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        icon = rememberVectorPainter(image = Icons.Default.LogoDev),
        onCloseRequest = ::exitApplication,
        title = "Login"
    ) {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}