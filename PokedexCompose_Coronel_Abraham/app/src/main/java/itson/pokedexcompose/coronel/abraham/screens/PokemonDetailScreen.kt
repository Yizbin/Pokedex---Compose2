package itson.pokedexcompose.coronel.abraham.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import itson.pokedexcompose.coronel.abraham.model.domain.Pokemon

@Composable
fun pokemonDetailScreen(innerPaddingValues: PaddingValues, pokemon: Pokemon) {
    Column() {
        Text(pokemon.nombre)
        Image(painterResource(pokemon.imagen), contentDescription = "${pokemon.nombre} image")
    }
}