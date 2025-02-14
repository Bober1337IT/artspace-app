package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtGallery(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtGallery(modifier: Modifier = Modifier) {
    var step by remember { mutableStateOf(1) };
    if (step < 1){
        step = 3;
    }
    if (step > 3){
        step = 1;
    }
    var imageResource : Int
    var textName : String
    var year : Int
    var title : String
    when(step){
        1-> {
            imageResource = R.drawable.napoelon;
            title = "Napoleon Crossing the Alps"
            textName = "Jacques-Louis David"
            year = 1805
        }
        2->{
            imageResource = R.drawable.monalisa;
            title = "Mona Lisa"
            textName = "Leonardo da Vinci"
            year = 1506
        }
        else -> {
            imageResource = R.drawable.georgewashington;
            title = "Lansdowne portrait"
            textName = "Gilbert Stuart"
            year = 1796
        }
    }

    Column(
        modifier = modifier
            .fillMaxHeight()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(0.65f)
                .padding(32.dp)
                
        ) {
            Column(
                modifier = Modifier
                    .border(BorderStroke(4.dp, Color.LightGray))
                    .shadow(8.dp)
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxSize()
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth()
                .padding(32.dp)
                .background(Color.LightGray)
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light
                    )
                }
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = textName,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = " ($year)",
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(0.15f)
                .fillMaxWidth()
        ) {
            Button(onClick ={step--} ) {
                Text(
                    text = "Previous"
                )
            }
            Spacer(
                modifier = Modifier.width(64.dp)
            )
            Button(onClick ={step++}) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtGallery()
    }
}