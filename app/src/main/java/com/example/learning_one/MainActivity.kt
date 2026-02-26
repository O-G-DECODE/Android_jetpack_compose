package com.example.learning_one
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                   LoginApp()
                }
            }
        }

@Composable
fun LoginApp(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ) {
        Text(
            text = "Login Page " ,
            fontSize = 20.sp,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.padding(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = {Text("Enter the email")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Enter the password")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {
            message = if ( email.isBlank() || password.isBlank()){
                "PLease fill all field"
            }else{
                "Login Sucessfull"
            }
        })
        {
            Text("Login")
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = message, color = Color.DarkGray)
        Button(
            onClick = {
                val intent = android.content.Intent(context, SignUpActivity::class.java)
                context.startActivity(intent)
            }
        ) {
            Text("SignUp")
        }
    }

}

