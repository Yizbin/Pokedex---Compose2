package itson.pokedexcompose.coronel.abraham.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import itson.pokedexcompose.coronel.abraham.screens.MenuPokedexScreen
import itson.pokedexcompose.coronel.abraham.screens.PokemonDetailScreen
import itson.pokedexcompose.coronel.abraham.screens.PokemonHuntScreen

@Composable
fun MyApp(innerPaddingValues: PaddingValues = PaddingValues()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PokemonList) {
        composable<PokemonList> {
            MenuPokedexScreen(
                innerPadding = innerPaddingValues,
                onNavigateToDetail = { id ->
                    navController.navigate(route = PokemonDetail(id))
                },
                onNavigateToHunt = {navController.navigate(route = PokemonHunt)}
            )
        }

        composable<PokemonDetail> { backStackEntry ->
            val pokemon = backStackEntry.arguments?.getInt("pokemon") ?: -1
            PokemonDetailScreen(
                innerPaddingValues = innerPaddingValues,
                pokemonId = pokemon,
                onBackClick = { navController.popBackStack() },
                onNavigateToPokemon = { nextId ->
                    navController.navigate(route = PokemonDetail(nextId))
                }
            )
        }

        composable<PokemonHunt>{
            PokemonHuntScreen(innerPaddingValues)
        }
    }
}
