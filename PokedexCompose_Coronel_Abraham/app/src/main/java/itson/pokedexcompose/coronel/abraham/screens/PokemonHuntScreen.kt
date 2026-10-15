package itson.pokedexcompose.coronel.abraham.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import itson.pokedexcompose.coronel.abraham.components.PokemonRow
import itson.pokedexcompose.coronel.abraham.viewmodel.PokemonViewModel

@Composable
fun PokemonHuntScreen(
    innerPaddingValues: PaddingValues = PaddingValues(),
    viewModel: PokemonViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { viewModel.searchPokemon() }) {
            Text("Buscar pokemon en la hierba")
        }

        Spacer(modifier = Modifier.height(18.dp))

        viewModel.wildPokemon?.let { pokemon ->
            Text(
                text = "¡Apareció un ${pokemon.nombre} salvaje!",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Image(
                painter = painterResource(id = pokemon.imagen),
                contentDescription = pokemon.nombre,
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = { viewModel.capturePokemon() }) {
                Text("Capturar a ${pokemon.nombre}")
            }
        }

        if (viewModel.gonePokemon) {
            Text(
                text = "¡El Pokémon ha huido!",
                color = MaterialTheme.colorScheme.error,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        if (viewModel.capturedPokemons.isNotEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Pokémones capturados (${viewModel.capturedPokemons.size}):",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(viewModel.capturedPokemons) { pokemon ->
                    PokemonRow(pokemon = pokemon)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHuntPreview() {
    PokemonHuntScreen()
}
