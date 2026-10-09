package itson.pokedexcompose.coronel.abraham.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import itson.pokedexcompose.coronel.abraham.ui.theme.PokedexCompose_Coronel_AbrahamTheme
import itson.pokedexcompose.coronel.abraham.screens.MenuPokedexScreen

class PokedexList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexCompose_Coronel_AbrahamTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuPokedexScreen(
                        innerPadding = innerPadding,
                    )
                }
            }
        }
    }
}
