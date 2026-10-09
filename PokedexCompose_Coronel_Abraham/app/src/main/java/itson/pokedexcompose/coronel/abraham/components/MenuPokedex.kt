package itson.pokedexcompose.coronel.abraham.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import itson.pokedexcompose.coronel.abraham.model.data.pokemonList
import itson.pokedexcompose.coronel.abraham.model.domain.Pokemon

@Composable
fun FavoritesRow(
    favoriteList: List<Pokemon>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 5.dp)
    ) {
        items(favoriteList) { pokemon ->
            FavoritePokemon(pokemon = pokemon)
        }
    }
}

@Composable
fun PokedexGrid(
    pokemonList: List<Pokemon>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {
        items(pokemonList) { pokemon ->
            PokemonCell(pokemon = pokemon)
        }
    }
}

@Composable
fun MenuPokedex(
    pokemonList: List<Pokemon>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(pokemonList) { pokemon ->
            PokemonRow(pokemon = pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexPreview() {
    MenuPokedex(pokemonList = pokemonList)
}
