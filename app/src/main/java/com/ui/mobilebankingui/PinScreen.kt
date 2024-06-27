package com.ui.mobilebankingui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
fun PinScreen(navController: NavHostController, bank: String, rekening: String, jumlah: String, keterangan: String) {

    var pin by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(painter = painterResource(id = R.drawable.logo_bsi), contentDescription = "Login image",
            modifier = Modifier.size(200.dp))

        Text(
            text = "Masukkan pin BSI Mobile untuk melanjutkan transaksi",
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            color = Color(0xFF757575),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 52.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = pin, onValueChange = {
            pin = it
        }, label = {
            Text(text = "Pin")
        }, visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            Log.i("Credential", "Pin : $pin")
            navController.navigate("verifikasi/$bank/$rekening/$jumlah/$keterangan/$pin")
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00A39D), // Custom hex color
                contentColor = Color.White
            ),
            modifier = Modifier
                .width(275.dp)
                .height(80.dp)
                .padding(bottom = 32.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Kirim")
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}
