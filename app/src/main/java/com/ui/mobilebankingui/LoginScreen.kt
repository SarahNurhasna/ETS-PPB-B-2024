package com.ui.mobilebankingui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign


@Composable
fun LoginScreen(navController: NavHostController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.bottombg),
            contentDescription = "Bottom Background",
            modifier = Modifier
                .size(7000.dp)
                .align(Alignment.BottomCenter)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(painter = painterResource(id = R.drawable.logo_bsi), contentDescription = "Login image",
                modifier = Modifier.size(200.dp))

            Text(
                text = "Selamat Datang",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF008883)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Silahkan masukan kata sandi pengguna untuk ke aplikasi",
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                color = Color(0xFF757575),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = email, onValueChange = {
                email = it
            }, label = {
                Text(text = "Email Address")
            }, shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = password, onValueChange = {
                password = it
            }, label = {
                Text(text = "Password")
            },
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = {
                Log.i("Credential", "Email : $email Password : $password")
                navController.navigate("transfer")
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00A39D), // Custom hex color
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .width(275.dp)
                    .height(80.dp)
                    .padding(bottom = 32.dp), //
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Masuk",
                    fontSize = 16.sp,)
            }

            Image(painter = painterResource(id = R.drawable.fingerprint), contentDescription = "fingerprint",
                modifier = Modifier.size(75.dp))


            Spacer(modifier = Modifier.height(200.dp))
        }
    }

}