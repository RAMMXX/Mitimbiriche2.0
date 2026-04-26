package com.negocio.app

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

data class Producto(
    val nombre: String,
    val precio: Double,
    var stock: Int
)

class AppViewModel {

    val productos = mutableStateListOf(
        Producto("Cerveza", 1.5, 20),
        Producto("Cafe", 1.0, 15)
    )

    val ventas = mutableStateOf(0.0)
    val ganancia = mutableStateOf(0.0)

    fun vender(p: Producto) {
        if(p.stock > 0){
            p.stock -= 1
            ventas.value += p.precio
            ganancia.value += (p.precio * 0.4)
        }
    }

    fun agregar(nombre: String, precio: Double, stock: Int){
        productos.add(Producto(nombre, precio, stock))
    }
}
