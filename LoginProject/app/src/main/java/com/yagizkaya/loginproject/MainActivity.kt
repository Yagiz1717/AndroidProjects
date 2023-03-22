package com.yagizkaya.loginproject

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yagizkaya.loginproject.ui.theme.LoginProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun MainPage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Giriş Sayfası",
                        color = Color.White
                    )
                },
                backgroundColor = colorResource(id = R.color.topBarColor)
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding.calculateBottomPadding())) {
            ContentPage()
        }
    }
}

@Composable
fun ContentPage() {
    var tfUserName by remember { mutableStateOf("") }
    var tfUserPassword by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "",
            modifier = Modifier.size(80.dp)
        )
        Column() {
            TextField(
                value = tfUserName,
                onValueChange = { tfUserName = it },
                label = { Text("Kullanıcı Adı") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = colorResource(id = R.color.topBarColor),
                    focusedLabelColor = colorResource(id = R.color.topBarColor)
                )
            )
            Spacer(modifier = Modifier.padding(all = 10.dp))
            TextField(
                value = tfUserPassword,
                onValueChange = { tfUserPassword = it },
                label = { Text("Şifre") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = colorResource(id = R.color.topBarColor),
                    focusedLabelColor = colorResource(id = R.color.topBarColor)
                )
            )
        }
        Button(
            onClick = {},

            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.topBarColor),

            ),
            modifier = Modifier.size(150.dp, 50.dp)
        ) {
            Text(text = "Giriş Yap")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginProjectTheme {
        MainPage()
    }
}