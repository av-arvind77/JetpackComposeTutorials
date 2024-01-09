package dev.arvind.jetpackcomposetutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.arvind.jetpackcomposetutorials.ui.theme.JetpackComposeTutorialsTheme

class MainActivity : ComponentActivity() {

    // All the Jetpack Items are in Material3 and its in experimental phase,
    // so used ExperimentalMaterial3Api annotation
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // It remembers the value
                        val username = remember {
                            mutableStateOf(TextFieldValue())
                        }
                        val password = remember {
                            mutableStateOf(TextFieldValue())
                        }
                        // TextView in Jetpack Compose
                        Text(text = "Login", style = MaterialTheme.typography.displaySmall)
                        // Give spacing in the view
                        Spacer(modifier = Modifier.height(36.dp))

                        // EditText in Jetpack Compose
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = username.value,
                            onValueChange = {
                                username.value = it
                            },
                            label = { Text(text = "username") },
                            visualTransformation = VisualTransformation.None
                        )

                        /**
                         * EditText for Password Field
                         * Used @PasswordVisualTransformation for Password to not visible
                         */
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = password.value,
                            onValueChange = {
                                password.value = it
                            },
                            label = { Text(text = "password") },
                            visualTransformation = PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        // Button in Jetpack Compose
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            onClick = {}) {
                            Text(text = "Login")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialsTheme {
        Greeting("Android")
    }
}