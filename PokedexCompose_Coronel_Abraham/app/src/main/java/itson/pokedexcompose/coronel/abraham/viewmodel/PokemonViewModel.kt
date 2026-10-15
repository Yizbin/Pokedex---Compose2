package itson.pokedexcompose.coronel.abraham.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import itson.pokedexcompose.coronel.abraham.model.data.pokemonList
import itson.pokedexcompose.coronel.abraham.model.domain.Pokemon

class PokemonViewModel : ViewModel(){
    var wildPokemon by mutableStateOf<Pokemon?>(null)
        private set

    var capturePokemon by mutableStateOf(listOf<Pokemon>())
        private set

    var gonePokemon by mutableStateOf(false)

    fun searchPokemon() {
        wildPokemon = pokemonList.random()
    }

    fun capturePokemon(){
        wildPokemon?.let{
            var isCaptured = (1..2).random()
            if(isCaptured == 1) {
                capturePokemon = capturePokemon + it
                gonePokemon = false
                wildPokemon = null
            } else {
                gonePokemon = true
                wildPokemon = null
            }
        }

    }
}