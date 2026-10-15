package itson.pokedexcompose.coronel.abraham.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import itson.pokedexcompose.coronel.abraham.model.data.pokemonList
import itson.pokedexcompose.coronel.abraham.model.domain.PokedexState
import itson.pokedexcompose.coronel.abraham.model.domain.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PokemonViewModel : ViewModel() {

    private val _pokemons = mutableStateListOf<Pokemon>().apply { addAll(pokemonList) }
    val pokemons: List<Pokemon> get() = _pokemons

    val favorites: List<Pokemon> get() = _pokemons.filter { it.favorito }

    var wildPokemon by mutableStateOf<Pokemon?>(null)
        private set

    var pokedexState by mutableStateOf(PokedexState())
        private set

    fun searchPokemon() {
        wildPokemon = _pokemons.random()
        pokedexState = pokedexState.copy(lastCaptured = null, escaped = false)
    }

    fun capturePokemon() {
        val wild = wildPokemon ?: return
        pokedexState = if ((1..2).random() == 1) {
            pokedexState.copy(team = pokedexState.team + wild, lastCaptured = wild, escaped = false)
        } else {
            pokedexState.copy(lastCaptured = null, escaped = true)
        }
        wildPokemon = null
    }

    fun getPokemonByNumber(numero: Int): Pokemon? = _pokemons.find { it.numero == numero }

    fun getPrevPokemon(numero: Int): Pokemon? {
        val index = _pokemons.indexOfFirst { it.numero == numero }
        return if (index > 0) _pokemons[index - 1] else null
    }

    fun getNextPokemon(numero: Int): Pokemon? {
        val index = _pokemons.indexOfFirst { it.numero == numero }
        return if (index in 0 until _pokemons.lastIndex) _pokemons[index + 1] else null
    }

    fun toggleFavorite(numero: Int) {
        val index = _pokemons.indexOfFirst { it.numero == numero }
        if (index >= 0) {
            _pokemons[index] = _pokemons[index].copy(favorito = !_pokemons[index].favorito)
        }
    }
}