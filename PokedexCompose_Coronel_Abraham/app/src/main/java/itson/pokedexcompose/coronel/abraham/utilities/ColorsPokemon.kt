package itson.pokedexcompose.coronel.abraham.utilities

import androidx.compose.ui.graphics.Color
import itson.pokedexcompose.coronel.abraham.ui.theme.Bug
import itson.pokedexcompose.coronel.abraham.ui.theme.Dark
import itson.pokedexcompose.coronel.abraham.ui.theme.DarkGray
import itson.pokedexcompose.coronel.abraham.ui.theme.Dragon
import itson.pokedexcompose.coronel.abraham.ui.theme.Electric
import itson.pokedexcompose.coronel.abraham.ui.theme.Fairy
import itson.pokedexcompose.coronel.abraham.ui.theme.Fight
import itson.pokedexcompose.coronel.abraham.ui.theme.Fire
import itson.pokedexcompose.coronel.abraham.ui.theme.Flying
import itson.pokedexcompose.coronel.abraham.ui.theme.Ghost
import itson.pokedexcompose.coronel.abraham.ui.theme.Grass
import itson.pokedexcompose.coronel.abraham.ui.theme.Ground
import itson.pokedexcompose.coronel.abraham.ui.theme.Ice
import itson.pokedexcompose.coronel.abraham.ui.theme.Normal
import itson.pokedexcompose.coronel.abraham.ui.theme.OffWhite
import itson.pokedexcompose.coronel.abraham.ui.theme.Poison
import itson.pokedexcompose.coronel.abraham.ui.theme.Psych
import itson.pokedexcompose.coronel.abraham.ui.theme.Rock
import itson.pokedexcompose.coronel.abraham.ui.theme.Water

fun getColorByType(tipo: String): Pair<Color, Color> {
    val firstType = tipo.split("/").firstOrNull()?.trim() ?: tipo.trim()
    return when {
        firstType.contains("Electric", ignoreCase = true) -> Pair(Electric, DarkGray)
        firstType.contains("Grass", ignoreCase = true) -> Pair(Grass, OffWhite)
        firstType.contains("Fire", ignoreCase = true) -> Pair(Fire, OffWhite)
        firstType.contains("Water", ignoreCase = true) -> Pair(Water, OffWhite)
        firstType.contains("Normal", ignoreCase = true) -> Pair(Normal, OffWhite)
        firstType.contains("Bug", ignoreCase = true) -> Pair(Bug, OffWhite)
        firstType.contains("Poison", ignoreCase = true) -> Pair(Poison, OffWhite)
        firstType.contains("Ground", ignoreCase = true) -> Pair(Ground, OffWhite)
        firstType.contains("Rock", ignoreCase = true) -> Pair(Rock, OffWhite)
        firstType.contains("Flying", ignoreCase = true) -> Pair(Flying, DarkGray)
        firstType.contains("Fight", ignoreCase = true) -> Pair(Fight, DarkGray)
        firstType.contains("Psych", ignoreCase = true) -> Pair(Psych, OffWhite)
        firstType.contains("Ghost", ignoreCase = true) -> Pair(Ghost, OffWhite)
        firstType.contains("Dragon", ignoreCase = true) -> Pair(Dragon, OffWhite)
        firstType.contains("Dark", ignoreCase = true) -> Pair(Dark, OffWhite)
        firstType.contains("Ice", ignoreCase = true) -> Pair(Ice, DarkGray)
        firstType.contains("Fairy", ignoreCase = true) -> Pair(Fairy, DarkGray)
        else -> Pair(Normal, OffWhite)
    }
}
