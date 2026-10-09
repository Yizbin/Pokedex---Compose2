package itson.pokedexcompose.coronel.abraham.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import itson.pokedexcompose.coronel.abraham.R
import itson.pokedexcompose.coronel.abraham.model.data.getPokemonByNumber
import itson.pokedexcompose.coronel.abraham.model.data.pokemonList
import itson.pokedexcompose.coronel.abraham.ui.theme.TextoGris
import itson.pokedexcompose.coronel.abraham.ui.theme.TextoNumeroOscuro
import itson.pokedexcompose.coronel.abraham.ui.theme.TextoRojoTitulo
import itson.pokedexcompose.coronel.abraham.utilities.getColorByType

@Composable
fun PokemonDetailScreen(
    innerPaddingValues: PaddingValues = PaddingValues(),
    pokemonId: Int,
    onBackClick: () -> Unit = {},
    onNavigateToPokemon: (id: Int) -> Unit = {}
) {
    val pokemon = getPokemonByNumber(pokemonId) ?: return

    val mainColor = getColorByType(pokemon.tipo).first
    val types = pokemon.tipo.split("/").map { it.trim() }

    val currentIndex = pokemonList.indexOfFirst { it.numero == pokemon.numero }
    val prevPokemon = if (currentIndex > 0) pokemonList[currentIndex - 1] else null
    val nextPokemon = if (currentIndex >= 0 && currentIndex < pokemonList.size - 1) pokemonList[currentIndex + 1] else null

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
            .background(mainColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_pokeball_bg),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.TopEnd)
                .offset(x = 80.dp, y = 40.dp)
                .alpha(0.15f),
            colorFilter = ColorFilter.tint(Color.Black)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 36.dp, end = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Regresar",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Column {
                    Text(
                        text = pokemon.nombre,
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "#${"%04d".format(pokemon.numero)}",
                        color = TextoNumeroOscuro,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
            Icon(
                imageVector = if (pokemon.favorito) Icons.Default.Star else Icons.Outlined.StarBorder,
                contentDescription = "Favorito",
                tint = if (pokemon.favorito) Color.Yellow else Color.White,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .size(36.dp)
            )
        }

        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxHeight(0.65f)
                .fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp, start = 24.dp, end = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(horizontalArrangement = Arrangement.Center) {
                    types.forEachIndexed { index, typeName ->
                        EtiquetaTipo(
                            texto = typeName,
                            color = getColorByType(typeName).first
                        )
                        if (index < types.size - 1) {
                            Spacer(modifier = Modifier.width(12.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        FilaEstadistica(
                            titulo = "Altura",
                            valor = "${pokemon.altura} m"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        FilaEstadistica(
                            titulo = "Peso",
                            valor = "${pokemon.peso} kg"
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Habilidad",
                            color = TextoRojoTitulo,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = pokemon.habilidad,
                            color = TextoGris,
                            fontSize = 18.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = pokemon.descripcion,
                    color = TextoGris,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 22.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    if (prevPokemon != null) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable { onNavigateToPokemon(prevPokemon.numero) }
                        ) {
                            Image(
                                painter = painterResource(id = prevPokemon.imagen),
                                contentDescription = prevPokemon.nombre,
                                modifier = Modifier.size(75.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                BotonNavegacionRedondo(icono = Icons.AutoMirrored.Filled.KeyboardArrowLeft)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "${prevPokemon.nombre} N.º #${"%04d".format(prevPokemon.numero)}",
                                    color = TextoGris,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    } else {
                        Spacer(modifier = Modifier.width(1.dp))
                    }

                    if (nextPokemon != null) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable { onNavigateToPokemon(nextPokemon.numero) }
                        ) {
                            Image(
                                painter = painterResource(id = nextPokemon.imagen),
                                contentDescription = nextPokemon.nombre,
                                modifier = Modifier.size(75.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "${nextPokemon.nombre} N.º #${"%04d".format(nextPokemon.numero)}",
                                    color = TextoGris,
                                    fontSize = 12.sp
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                BotonNavegacionRedondo(icono = Icons.AutoMirrored.Filled.KeyboardArrowRight)
                            }
                        }
                    } else {
                        Spacer(modifier = Modifier.width(1.dp))
                    }
                }
            }
        }

        Image(
            painter = painterResource(id = pokemon.imagen),
            contentDescription = pokemon.nombre,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 130.dp)
                .size(240.dp)
        )
    }
}

@Composable
private fun FilaEstadistica(titulo: String, valor: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = titulo,
            color = TextoRojoTitulo,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.width(70.dp)
        )
        Text(
            text = valor,
            color = TextoGris,
            fontSize = 18.sp
        )
    }
}

@Composable
private fun EtiquetaTipo(texto: String, color: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .padding(horizontal = 24.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = texto,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Composable
private fun BotonNavegacionRedondo(icono: ImageVector) {
    Box(
        modifier = Modifier
            .size(22.dp)
            .clip(CircleShape)
            .background(TextoGris),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icono,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
    }
}
