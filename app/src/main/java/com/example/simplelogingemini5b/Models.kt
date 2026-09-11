package com.example.simplelogingemini5b

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val login: String,
    val password: String,
    val email: String
) : Serializable

data class Curso(
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val imagenResId: Int,
    val nivel: String,
    val duracion: String,
    val instructor: Usuario? = null
) : Serializable
