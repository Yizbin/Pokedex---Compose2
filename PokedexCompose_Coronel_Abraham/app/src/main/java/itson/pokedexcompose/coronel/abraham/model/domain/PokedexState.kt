package itson.pokedexcompose.coronel.abraham.model.domain

data class PokedexState(
    val team: List<Pokemon> = emptyList(),
    val lastCaptured: Pokemon? = null,

)
