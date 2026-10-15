package itson.pokedexcompose.coronel.abraham.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import itson.pokedexcompose.coronel.abraham.screens.MenuPokedexScreen
import itson.pokedexcompose.coronel.abraham.screens.PokemonDetailScreen
import itson.pokedexcompose.coronel.abraham.screens.PokemonHuntScreen
import itson.pokedexcompose.coronel.abraham.viewmodel.PokemonViewModel

@Composable
fun MyApp(innerPaddingValues: PaddingValues = PaddingValues()) {
    val navController = rememberNavController()
    val viewModel: PokemonViewModel = viewModel()

    val navigateToDetail = { id: Int -> navController.navigate(PokemonDetail(id)) }

    NavHost(navController = navController, startDestination = PokemonList) {
        composable<PokemonList> {
            MenuPokedexScreen(
                pokemonList = viewModel.pokemons,
                favorites = viewModel.favorites,
                innerPadding = innerPaddingValues,
                onNavigateToDetail = navigateToDetail,
                onNavigateToHunt = { navController.navigate(PokemonHunt) }
            )
        }

        composable<PokemonHunt> {
            PokemonHuntScreen(
                wildPokemon = viewModel.wildPokemon,
                state = viewModel.pokedexState,
                innerPaddingValues = innerPaddingValues,
                onSearch = { viewModel.searchPokemon() },
                onCapture = { viewModel.capturePokemon() },
                onNavigateToDetail = navigateToDetail
            )
        }

        composable<PokemonDetail> { backStackEntry ->
            val id = backStackEntry.toRoute<PokemonDetail>().pokemon
            val pokemon = viewModel.getPokemonByNumber(id)
            if (pokemon != null) {
                PokemonDetailScreen(
                    innerPaddingValues = innerPaddingValues,
                    pokemon = pokemon,
                    prevPokemon = viewModel.getPrevPokemon(id),
                    nextPokemon = viewModel.getNextPokemon(id),
                    onBackClick = { navController.popBackStack() },
                    onToggleFavorite = { viewModel.toggleFavorite(id) },
                    onNavigateToPokemon = { nextId ->
                        navController.navigate(PokemonDetail(nextId)) {
                            popUpTo<PokemonDetail> { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}