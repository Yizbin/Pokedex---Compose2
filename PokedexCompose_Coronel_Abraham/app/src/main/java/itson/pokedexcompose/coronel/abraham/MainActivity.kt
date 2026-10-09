package itson.pokedexcompose.coronel.abraham

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import itson.pokedexcompose.coronel.abraham.ui.theme.FondoLucario
import itson.pokedexcompose.coronel.abraham.ui.theme.TextoGris
import itson.pokedexcompose.coronel.abraham.ui.theme.TextoNumeroOscuro
import itson.pokedexcompose.coronel.abraham.ui.theme.TextoRojoTitulo
import itson.pokedexcompose.coronel.abraham.ui.theme.TipoAcero
import itson.pokedexcompose.coronel.abraham.ui.theme.TipoLucha

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PantallaPokedex()
            }
        }
    }
}

@Composable
fun PantallaPokedex() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoLucario)
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
                .padding(start = 24.dp, top = 48.dp, end = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.nombre_pokemon),
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = stringResource(id = R.string.numero_pokemon),
                    color = TextoNumeroOscuro,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Icon(
                imageVector = Icons.Outlined.StarBorder,
                contentDescription = "Favorito",
                tint = Color.White,
                modifier = Modifier.size(36.dp)
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
                    EtiquetaTipo(texto = stringResource(id = R.string.tipo_lucha), color = TipoLucha)
                    Spacer(modifier = Modifier.width(12.dp))
                    EtiquetaTipo(texto = stringResource(id = R.string.tipo_acero), color = TipoAcero)
                }

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        FilaEstadistica(
                            titulo = stringResource(R.string.estadistica_altura_titulo),
                            valor = stringResource(R.string.estadistica_altura_valor)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        FilaEstadistica(
                            titulo = stringResource(R.string.estadistica_peso_titulo),
                            valor = stringResource(R.string.estadistica_peso_valor)
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = stringResource(R.string.estadistica_habilidad_titulo),
                            color = TextoRojoTitulo,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = stringResource(R.string.estadistica_habilidad_valor),
                            color = TextoGris,
                            fontSize = 18.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = stringResource(id = R.string.descripcion_pokemon),
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
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.riolu),
                            contentDescription = "Riolu",
                            modifier = Modifier.size(75.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            BotonNavegacionRedondo(icono = Icons.AutoMirrored.Filled.KeyboardArrowLeft)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = stringResource(id = R.string.pokemon_anterior), color = TextoGris, fontSize = 12.sp)
                        }
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.hippopotas),
                            contentDescription = "Hippopotas",
                            modifier = Modifier.size(75.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = stringResource(id = R.string.pokemon_siguiente), color = TextoGris, fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            BotonNavegacionRedondo(icono = Icons.AutoMirrored.Filled.KeyboardArrowRight)
                        }
                    }
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.lucario),
            contentDescription = "Lucario",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 130.dp)
                .size(240.dp)
        )
    }
}

@Composable
fun FilaEstadistica(titulo: String, valor: String) {
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
fun EtiquetaTipo(texto: String, color: Color) {
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
fun BotonNavegacionRedondo(icono: ImageVector) {
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VistaPreviaPantallaPokedex() {
    MaterialTheme {
        PantallaPokedex()
    }
}
