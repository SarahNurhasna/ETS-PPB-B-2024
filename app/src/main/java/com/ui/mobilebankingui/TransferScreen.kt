package com.ui.mobilebankingui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TransferScreen(navController: NavHostController) {

    var bank by remember {
        mutableStateOf("")
    }

    var rekening by remember {
        mutableStateOf("")
    }

    var jumlah by remember {
        mutableStateOf("")
    }

    var keterangan by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = R.drawable.logo_bsi), contentDescription = "Logo BSI",
            modifier = Modifier.size(200.dp))

        Text(
            text = "Transfer",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            color = Color(0xFF008883)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = bank, onValueChange = {
            bank = it
        }, label = {
            Text(text = "Bank Tujuan")
        }, shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = rekening, onValueChange = {
            rekening = it
        }, label = {
            Text(text = "Nomor Rekening Tujuan")
        }, shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = jumlah, onValueChange = {
            jumlah = it
        }, label = {
            Text(text = "Nominal Transfer")
        }, shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = keterangan, onValueChange = {
            keterangan = it
        }, label = {
            Text(text = "Keterangan Transfer")
        }, shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            Log.i("Transfer", "Bank : $bank, Rekening : $rekening, Jumlah : $jumlah, Keterangan : $keterangan")
            navController.navigate("pin/$bank/$rekening/$jumlah/$keterangan")
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
            Text(text = "Lanjut")
        }

        Spacer(modifier = Modifier.height(100.dp))
    }
}
