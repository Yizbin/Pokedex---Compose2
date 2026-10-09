package itson.pokedexcompose.coronel.abraham.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import itson.pokedexcompose.coronel.abraham.viewmodel.PokemonViewModel

@Composable
fun PokemonHuntScreen(innerPaddingValues: PaddingValues, viewModel: PokemonViewModel = viewModel()) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button({}) {
            Text("Buscar pokemon en la hierva")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHuntPreview(){

}
