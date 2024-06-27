package com.ui.mobilebankingui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun VerificationScreen(
    navController: NavHostController,
    bank: String,
    rekening: String,
    jumlah: String,
    keterangan: String,
    pin: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = R.drawable.logo_bsi), contentDescription = "Logo BSI",
            modifier = Modifier.size(200.dp))

        Text(
            text = "Transfer Berhasil",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF008883)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp)
                .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = "Bank: $bank",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Rekening: $rekening",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Jumlah: Rp.$jumlah,-",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Keterangan: $keterangan",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("transfer")
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
            Text(text = "Selesai")
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}
