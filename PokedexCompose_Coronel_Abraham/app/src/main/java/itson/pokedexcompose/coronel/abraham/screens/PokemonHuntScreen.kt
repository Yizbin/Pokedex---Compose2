package itson.pokedexcompose.coronel.abraham.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import itson.pokedexcompose.coronel.abraham.viewmodel.PokemonViewModel

@Composable
fun PokemonHuntScreen(innerPaddingValues: PaddingValues, viewModel: PokemonViewModel = viewModel()) {
    Column(Modifier.fillMaxWidth().padding(innerPaddingValues), horizontalAlignment = Alignment.CenterHorizontally) {
        Button({viewModel.searchPokemon()}) {
            Text("Buscar pokemon en la hierva")
        }

        Spacer(Modifier.size(18.dp))
        viewModel.wildPokemon?.let {
            pokemon -> Text("Aparecio un ${pokemon.nombre} salvaje")
            Spacer(Modifier.size(15.dp))
            Button(onClick = {}) {
                Text("Capturar a ${pokemon.nombre}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHuntPreview(){

}
