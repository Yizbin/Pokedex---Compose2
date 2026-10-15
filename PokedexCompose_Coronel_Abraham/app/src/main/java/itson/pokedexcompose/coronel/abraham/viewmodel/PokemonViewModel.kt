package itson.pokedexcompose.coronel.abraham.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import itson.pokedexcompose.coronel.abraham.model.data.pokemonList
import itson.pokedexcompose.coronel.abraham.model.domain.Pokemon

class PokemonViewModel : ViewModel() {
    var wildPokemon by mutableStateOf<Pokemon?>(null)
        private set

    var capturedPokemons by mutableStateOf(listOf<Pokemon>())
        private set

    var gonePokemon by mutableStateOf(false)
        private set

    fun searchPokemon() {
        wildPokemon = pokemonList.random()
        gonePokemon = false
    }

    fun capturePokemon() {
        wildPokemon?.let { pokemon ->
            val isCaptured = (1..2).random()
            if (isCaptured == 1) {
                capturedPokemons = capturedPokemons + pokemon
                gonePokemon = false
                wildPokemon = null
            } else {
                gonePokemon = true
                wildPokemon = null
            }
        }
    }
}
