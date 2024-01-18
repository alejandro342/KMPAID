import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import screens.login.screen.LoginScreen


@Composable
fun App() {
    MaterialTheme {
        Navigator(screen = LoginScreen()) { navigator ->
            SlideTransition(navigator)
        }
    }
}