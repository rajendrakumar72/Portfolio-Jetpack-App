package com.katomaran.jetpacksampleapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.katomaran.jetpacksampleapp.ui.theme.JetpackSampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackSampleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    BizCard()
                }
            }
        }
    }
}

@Composable
fun BizCard() {
    val buttonClickedState= remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 4.dp, backgroundColor = Color.DarkGray) {

            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(color = Color.Green)
                CreateInfo()
                Button(
                    onClick = {
                        buttonClickedState.value=!buttonClickedState.value
                    },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow))
                {
                    Text(text = "Portfolio", style = MaterialTheme.typography.button)
                }
                if (buttonClickedState.value){
                    Content()
                }else{
                    Box() {
                        
                    }
                }

            }

        }
        

    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "RajendraKumar M",
            style = MaterialTheme.typography.h4,
            color = Color.Green
        )

        Text(
            text = "Android Developer",
            color = Color.Red,
            modifier = Modifier.padding(3.dp)
        )

        Text(
            text = "rk10295@gmail.com",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.Red
        )


    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_image),
            contentDescription = "User Image", modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        );

    }
}


@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
             shape = RoundedCornerShape(corner = CornerSize(6.dp)),
             color = Color.LightGray) {

            Portfolio(data= listOf("Project1","Project1","Project1"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){item ->  
           Card(modifier = Modifier
               .padding(13.dp)
               .fillMaxWidth(), shape = RectangleShape
                , elevation = 4.dp) {
               Row(modifier = Modifier
                   .padding(7.dp)
                   .background(MaterialTheme.colors.surface)
                   .padding(16.dp)) {
                   CreateImageProfile(modifier = Modifier.size(80.dp))
                Column(modifier = Modifier
                    .padding(7.dp)
                    .align(alignment = Alignment.CenterVertically)) {
                    Text(text = item, fontWeight = FontWeight.Bold)
                    Text(text = "Tap to see the project", style = MaterialTheme.typography.body2)

                }
               }
               
           }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackSampleAppTheme {
        BizCard()
    }
}