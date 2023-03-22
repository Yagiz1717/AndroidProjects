package com.yagizkaya.ilhamalmacaproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yagizkaya.ilhamalmacaproject.ui.theme.IlhamAlmacaProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IlhamAlmacaProjectTheme {
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
                    Text(text = "İlham Almaca")
                },
                backgroundColor = colorResource(id = R.color.topBarColor)
            )
        }
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(modifier = Modifier
                        .size(170.dp)
                        .clip(CircleShape),
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = ""

                    )
                }
                val context = LocalContext.current

                Column(modifier = Modifier.padding(start = 30.dp, end = 30.dp)) {
                    Text(
                        text = "Eğer bir şey yaparsan ve ortaya iyi bir şey çıkarsa, o zaman fazla beklemeden daha iyi olan başka bir şey için uğraşmalısın.",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(modifier = Modifier
                        .padding(top = 10.dp, end = 20.dp)
                        .fillMaxWidth(),
                        text = "Steve Jobs",
                        textAlign = TextAlign.End,
                        fontSize = 15.sp
                    )
                }
                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "İlham Alındı.",
                            Toast.LENGTH_SHORT
                        ).show()
                    },

                    ) {
                    Text(
                        text = "İlham Al",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IlhamAlmacaProjectTheme {
        MainPage()
    }
}