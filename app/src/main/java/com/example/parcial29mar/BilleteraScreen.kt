package com.example.parcial29mar

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@Composable
fun BilleteraScreen(saldo: Int, onRetirar: (Int) -> Unit) {
    var input by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Saldo disponible:", fontSize = 20.sp)
        Text(text = "$$saldo", fontSize = 32.sp, color = Color(0xFF2E7D32))

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = input,
                onValueChange = {
                    if (it.all { char -> char.isDigit() }) {
                        input = it
                        error = false
                    }
                },
                label = { Text("Monto a retirar") },
                isError = error,
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    errorBorderColor = Color.Red
                )
            )

            Button(
                onClick = {
                    val monto = input.toIntOrNull()
                    if (monto != null && monto in 1 until saldo) {
                        onRetirar(monto)
                        input = ""
                    } else {
                        error = true
                    }
                }
            ) {
                Text("RETIRAR")
            }
        }

        if (error) {
            Spacer(modifier = Modifier.height(12.dp))
            Text("Monto inválido o excede el saldo", color = Color.Red)
        }
    }
}