package itson.pokedexcompose.coronel.abraham.model.domain

import androidx.annotation.DrawableRes

data class Pokemon(
    val nombre: String,
    val numero: Int,
    val tipo: String,
    val descripcion: String,
    val altura: Float,
    val peso: Float,
    val favorito: Boolean,
    val habilidad: String,
    @DrawableRes val imagen: Int
)
