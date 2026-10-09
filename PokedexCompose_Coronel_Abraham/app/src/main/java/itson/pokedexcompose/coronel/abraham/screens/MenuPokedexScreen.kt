package itson.pokedexcompose.coronel.abraham.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import itson.pokedexcompose.coronel.abraham.R
import itson.pokedexcompose.coronel.abraham.components.FavoritesRow
import itson.pokedexcompose.coronel.abraham.components.MenuPokedex
import itson.pokedexcompose.coronel.abraham.components.PokedexGrid
import itson.pokedexcompose.coronel.abraham.model.data.pokemonList
import itson.pokedexcompose.coronel.abraham.ui.theme.Blue
import itson.pokedexcompose.coronel.abraham.ui.theme.Green
import itson.pokedexcompose.coronel.abraham.ui.theme.LightBlue
import itson.pokedexcompose.coronel.abraham.ui.theme.LightGreen

@Composable
fun MenuPokedexScreen(
    innerPadding: PaddingValues = PaddingValues(),
    modifier: Modifier = Modifier,
    onNavigateToDetail: (id: Int) -> Unit = {}
) {
    val favorites = pokemonList.filter { it.favorito }
    var grid by remember { mutableStateOf(value = false) }

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
            favoriteList = favorites,
            onPokemonClick = onNavigateToDetail
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Todos mis pokemones",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Switch(
                checked = grid,
                onCheckedChange = { grid = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Green,
                    checkedTrackColor = LightGreen,
                    uncheckedThumbColor = Blue,
                    uncheckedTrackColor = LightBlue,
                    uncheckedBorderColor = Color.Transparent
                ),
                thumbContent = {
                    if (grid) {
                        Icon(
                            painter = painterResource(R.drawable.grid),
                            contentDescription = "grid icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    } else {
                        Icon(
                            painter = painterResource(R.drawable.list),
                            contentDescription = "list icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                }
            )
        }

        if (grid) {
            PokedexGrid(
                pokemonList = pokemonList,
                modifier = Modifier.weight(1f),
                onPokemonClick = onNavigateToDetail
            )
        } else {
            MenuPokedex(
                pokemonList = pokemonList,
                modifier = Modifier.weight(1f),
                onPokemonClick = onNavigateToDetail
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexScreenPreview() {
    MenuPokedexScreen(
        innerPadding = PaddingValues(),
        onNavigateToDetail = {}
    )
}
