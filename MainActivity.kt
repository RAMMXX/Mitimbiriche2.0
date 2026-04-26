package com.negocio.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm = AppViewModel()

        setContent {
            App(vm)
        }
    }
}

@Composable
fun App(vm: AppViewModel) {
    var tab by remember { mutableStateOf(0) }

    Column {
        Row {
            Button(onClick = { tab = 0 }) { Text("Inicio") }
            Button(onClick = { tab = 1 }) { Text("Inventario") }
            Button(onClick = { tab = 2 }) { Text("Ventas") }
        }

        when(tab){
            0 -> Dashboard(vm)
            1 -> Inventario(vm)
            2 -> Ventas(vm)
        }
    }
}
