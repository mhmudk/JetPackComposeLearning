package com.learning.jetpackcomposelearning

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.learning.jetpackcomposelearning.ui.theme.JetpackComposeLearningTheme
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HandleTextFields()
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello Mahmoud $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeLearningTheme {
        Greeting("Android")
    }
}

@Composable
fun TextFieldWithIcons(
    label: String, placeHolder: String, icon: ImageVector,
    text: String,
    onValueChange: (String) -> Unit
) {
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = icon, contentDescription = "emailIcon") },
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(text = label) },
        placeholder = { Text(text = placeHolder) },
    )


}

@Composable
fun HandleTextFields() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }


    Column {
        TextFieldWithIcons(
            label = "Email",
            placeHolder = "Write your email",
            icon = Icons.Default.Email,
            text = email,
            onValueChange = {
                email = it
            }
        )
        TextFieldWithIcons(
            label = "Password",
            placeHolder = "Write your password",
            icon = Icons.Default.Lock,
            text = password,
            onValueChange = {
                password = it
            }
        )

        TextFieldWithIcons(
            label = "Name",
            placeHolder = "Write your name",
            icon = Icons.Default.Person,
            text = name,
            onValueChange = {
                name = it
            }
        )

        TextFieldWithIcons(
            label = "phone",
            placeHolder = "Write your phone",
            icon = Icons.Default.Phone, text = phone,
            onValueChange = {
                phone = it
            }
        )
        Button(
            onClick = {
                Log.d("XYZ ", "HandleTextFields: " +
                        "\n" +"email ---> ${email}" +
                        "\n" +" password  ---> ${password}  " +
                        "\n" + "phone ---> ${phone}" +
                        "\n" + " name ---> ${name}")

            }
        ) {
            Text(text = "Login ")
        }
    }
}