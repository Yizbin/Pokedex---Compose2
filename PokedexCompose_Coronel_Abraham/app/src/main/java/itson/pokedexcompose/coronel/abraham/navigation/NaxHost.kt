package itson.pokedexcompose.coronel.abraham.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import itson.pokedexcompose.coronel.abraham.screens.MenuPokedexScreen

@Composable
fun MyApp(innerPaddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = PokemonList) {
        composable<PokemonList> {
            MenuPokedexScreen(innerPadding, onNavigateToDetail = {id -> navController.navigate(route = PokemonDetail(id))})
        }

        composable<PokemonDetail>(){
            val pokemon = it.arguments?.getInt("pokemon") ?: -1
            PokemonDetailScreen(innerPadding, getPokemonByNumber(pokemon))
        }
    }
}
