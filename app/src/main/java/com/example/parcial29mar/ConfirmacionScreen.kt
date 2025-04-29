package com.example.parcial29mar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ConfirmacionScreen(monto: Int, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Comprobante de retiro", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Felicidades!",
            fontSize = 20.sp
        )
        Text(
            text = "Retiraste efectivamente el monto de:",
            fontSize = 20.sp
        )
        Text(
            text = "$$monto",
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("VOLVER A BILLETERA")
        }
    }
}