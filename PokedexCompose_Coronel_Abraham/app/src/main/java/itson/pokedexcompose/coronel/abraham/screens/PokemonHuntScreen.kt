package itson.pokedexcompose.coronel.abraham.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import itson.pokedexcompose.coronel.abraham.components.PokemonRow
import itson.pokedexcompose.coronel.abraham.model.data.pokemonList
import itson.pokedexcompose.coronel.abraham.model.domain.PokedexState
import itson.pokedexcompose.coronel.abraham.model.domain.Pokemon

@Composable
fun PokemonHuntScreen(
    wildPokemon: Pokemon?,
    state: PokedexState,
    innerPaddingValues: PaddingValues = PaddingValues(),
    onSearch: () -> Unit = {},
    onCapture: () -> Unit = {},
    onNavigateToDetail: (id: Int) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onSearch) {
            Text("Buscar pokemon en la hierba")
        }

        Spacer(Modifier.height(16.dp))

        if (wildPokemon != null) {
            Image(
                painter = painterResource(id = wildPokemon.imagen),
                contentDescription = "${wildPokemon.nombre} image",
                modifier = Modifier.size(160.dp)
            )
            Text("Apareció un ${wildPokemon.nombre} salvaje", style = MaterialTheme.typography.labelLarge)
            Spacer(Modifier.height(8.dp))
            Button(onClick = onCapture) {
                Text("Capturar a ${wildPokemon.nombre}")
            }
        }

        if (state.escaped) {
            Text("¡El pokemon se ha escapado!", style = MaterialTheme.typography.labelLarge)
        }

        state.lastCaptured?.let {
            Text("¡Has capturado a ${it.nombre}!", style = MaterialTheme.typography.labelLarge)
        }

        Spacer(Modifier.height(20.dp))

        Text(
            text = "Pokemones capturados",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(state.team) { pokemon ->
                PokemonRow(
                    pokemon = pokemon,
                    onClick = { onNavigateToDetail(pokemon.numero) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHuntPreview() {
    PokemonHuntScreen(
        wildPokemon = pokemonList.first(),
        state = PokedexState(team = pokemonList.take(2))
    )
}