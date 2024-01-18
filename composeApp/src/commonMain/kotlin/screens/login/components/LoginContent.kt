package screens.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import screens.menu.screen.MenuScreen


@Composable
fun LoginContent() {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visualPassword by remember { mutableStateOf(false) }
    //para navegar
    val navigator = LocalNavigator.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Inicio de sesión", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Card(
            modifier = Modifier,
            shape = RoundedCornerShape(5),
            elevation = 20.dp,
            contentColor = Color.Black
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                OutlinedTextField(
                    value = user,
                    onValueChange = {
                        user = it
                    },
                    label = { Text("User") }
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = { Text("Password") },
                    visualTransformation = if (visualPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconToggleButton(checked = visualPassword, onCheckedChange = { visualPassword = it }) {
                            Icon(
                                imageVector = Icons.Default.Visibility,
                                contentDescription = null
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                Button(onClick = {
                    navigator?.push(MenuScreen())
                }, modifier = Modifier) {
                    Text("ACEPTAR", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            }
        }
    }
}



