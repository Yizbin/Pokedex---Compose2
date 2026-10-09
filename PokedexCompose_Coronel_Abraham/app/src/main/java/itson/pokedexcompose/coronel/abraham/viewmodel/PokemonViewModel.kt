package itson.pokedexcompose.coronel.abraham.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import itson.pokedexcompose.coronel.abraham.model.domain.Pokemon

class PokemonViewModel : ViewModel(){
    var wildPokemon by mutableStateOf<Pokemon?>(null)

    fun capturePokemon(){

    }
}