package com.example.parcial29mar

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                var saldo by remember { mutableStateOf(100000) }

                NavHost(navController = navController, startDestination = "billetera") {
                    composable("billetera") {
                        BilleteraScreen(
                            saldo = saldo,
                            onRetirar = { montoRetirado ->
                                saldo -= montoRetirado
                                navController.navigate("confirmacion/$montoRetirado")
                            }
                        )
                    }
                    composable("confirmacion/{monto}") { backStackEntry ->
                        val monto = backStackEntry.arguments?.getString("monto")?.toIntOrNull() ?: 0
                        ConfirmacionScreen(monto)
                    }
                }
            }
        }
    }
}