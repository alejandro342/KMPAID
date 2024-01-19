package screens.login.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import screens.login.components.LoginContent

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold {
            LoginContent()
        }
    }
}