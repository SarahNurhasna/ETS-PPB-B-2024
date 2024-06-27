package com.ui.mobilebankingui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ui.mobilebankingui.ui.theme.MobileBankingUITheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBankingUITheme {
                val navController = rememberNavController()
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") { SplashScreen(navController) }
                        composable("login") { LoginScreen(navController) }
                        composable("transfer") { TransferScreen(navController) }
                        composable("pin/{bank}/{rekening}/{jumlah}/{keterangan}") { backStackEntry ->
                            val bank = backStackEntry.arguments?.getString("bank") ?: ""
                            val rekening = backStackEntry.arguments?.getString("rekening") ?: ""
                            val jumlah = backStackEntry.arguments?.getString("jumlah") ?: ""
                            val keterangan = backStackEntry.arguments?.getString("keterangan") ?: ""
                            PinScreen(navController, bank, rekening, jumlah, keterangan)
                        }
                        composable("verifikasi/{bank}/{rekening}/{jumlah}/{keterangan}/{pin}") { backStackEntry ->
                            val bank = backStackEntry.arguments?.getString("bank") ?: ""
                            val rekening = backStackEntry.arguments?.getString("rekening") ?: ""
                            val jumlah = backStackEntry.arguments?.getString("jumlah") ?: ""
                            val keterangan = backStackEntry.arguments?.getString("keterangan") ?: ""
                            val pin = backStackEntry.arguments?.getString("pin") ?: ""
                            VerificationScreen(navController, bank, rekening, jumlah, keterangan, pin)
                        }
                    }

                }
            }
        }
    }

    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bottombg),
            contentDescription = "Bottom Background",
            modifier = Modifier
                .size(7000.dp)
                .align(Alignment.BottomCenter)
        )

        Image(
            painter = painterResource(id = R.drawable.logo_bsi),
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
        )
    }
}
