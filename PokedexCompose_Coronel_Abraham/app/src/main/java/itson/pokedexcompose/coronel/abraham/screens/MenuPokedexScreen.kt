package itson.pokedexcompose.coronel.abraham.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import itson.pokedexcompose.coronel.abraham.components.FavoritesRow
import itson.pokedexcompose.coronel.abraham.components.PokedexGrid
import itson.pokedexcompose.coronel.abraham.model.data.pokemonList

@Composable
fun MenuPokedexScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    onNavigateToDetail: (id: Int) -> Unit
) {
    val favorites = pokemonList.filter { it.favorito }

    Column(
        modifier = modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Mis Favoritos",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        FavoritesRow(
            favoriteList = favorites
        )

        Text(
            text = "Todos mis pokemones",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        PokedexGrid(
            pokemonList = pokemonList,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexScreenPreview() {
    MenuPokedexScreen(innerPadding = PaddingValues(), {})
}
