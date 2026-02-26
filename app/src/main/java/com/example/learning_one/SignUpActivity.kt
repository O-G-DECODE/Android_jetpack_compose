package com.example.learning_one
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SignUp()
        }
    }
}
@Preview
@Composable
fun SignUp() {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "SignUp Page",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            modifier = Modifier.padding(20.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(15.dp)

        )
        {
            Text(
                text = "Username",

                )
       Spacer(modifier = Modifier.padding(5.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter the Name")},
            )

        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

            Text(
                text =  "Email"
            )
            Spacer(modifier = Modifier.padding(14.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = {Text("Enter the Email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(15.dp)

        )
        {
            Text(
                text = "Phone",
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Enter the Phone")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

            Text(
                text =  "Password"
            )

            Spacer(modifier = Modifier.padding(5.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it},
                label = {Text("Enter the Password")},
                visualTransformation = PasswordVisualTransformation(),

            )

        }
        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {
            if(email.isBlank() || name.isBlank() || phone.isBlank() || password.isBlank()){
                     message = "please fill all the column"
            }else{
                Toast.makeText(context, "SignUp Successfully" , Toast.LENGTH_LONG).show()
                val intent = android.content.Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }

        }) {
            Text("Submit")
        }
        Text( text = message )

    }
}


