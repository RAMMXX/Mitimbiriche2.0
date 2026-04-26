package com.negocio.app

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*

@Composable
fun Dashboard(vm: AppViewModel){
    Column {
        Text("💰 Ventas: ${vm.ventas.value}")
        Text("📈 Ganancia: ${vm.ganancia.value}")
    }
}

@Composable
fun Inventario(vm: AppViewModel){
    Column {
        Button(onClick = { vm.agregar("Nuevo", 2.0, 10) }) {
            Text("Agregar producto")
        }

        vm.productos.forEach {
            Text("${it.nombre} - Stock: ${it.stock}")
        }
    }
}

@Composable
fun Ventas(vm: AppViewModel){
    Column {
        vm.productos.forEach {
            Button(onClick = { vm.vender(it) }) {
                Text("Vender ${it.nombre}")
            }
        }
    }
}
