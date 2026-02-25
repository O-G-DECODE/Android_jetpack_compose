package com.example.learning_one
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                   MyCounterScreen()
                }
            }
        }

@Preview(showBackground = true)
@Composable
fun MyCounterScreen(){
    var count by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ) {
        Text(

            text = "Counter Application ", fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
            )
        Text(text = "$count" ,
            fontSize = 50.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(onClick = { count++ })
            {
                Text("+")
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Button(onClick = {
                if(count != 0){
                    count--
                }else{
                    count=0
                }
            }) {
                Text("-")
            }
        }


    }

}

