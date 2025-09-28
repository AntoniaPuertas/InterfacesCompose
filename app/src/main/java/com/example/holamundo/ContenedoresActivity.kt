package com.example.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.holamundo.ui.theme.HolaMundoTheme

class ContenedoresActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CompleteLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
/**
 * Define la estructura completa de la interfaz de usuario para la pantalla principal.
 *
 * Esta función Composable organiza varios elementos de la UI en una disposición vertical (`Column`):
 * 1.  **Encabezado (`Row`):** Muestra el título de la aplicación y un botón de "Configuración".
 *     Los elementos dentro del encabezado están distribuidos horizontalmente.
 * 2.  **Lista de Categorías (`LazyRow`):** Una lista horizontal de "chips" o etiquetas de categorías
 *     que permite el desplazamiento.
 * 3.  **Lista Principal de Ítems (`LazyColumn`):** Una lista vertical de tarjetas (`ItemCard`)
 *     que ocupa el espacio restante de la pantalla y permite el desplazamiento.
 *
 * @param modifier El [Modifier] que se aplicará al `Column` raíz de este layout.
 *                 Por defecto es [Modifier]. Se utiliza para pasar paddings (como los `innerPadding`
 *                 de un `Scaffold`) u otras configuraciones de layout desde el llamador.
 */
@Composable
fun CompleteLayout(modifier: Modifier = Modifier) {
    Column {
        // Header con elementos horizontales
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Mi App")
            Button(onClick = {}) {
                Text("Configuración")
            }
        }

        // Lista de categorías horizontal
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listOf("Todos", "Favoritos", "Recientes", "Populares", "Destacados")) { category ->
                CategoryChip(category)
            }
        }

        // Lista principal vertical
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(20) { index ->
                ItemCard("Item #${index + 1}")
            }
        }
    }
}

@Composable
fun CategoryChip(text: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = Color.White
        )
    }
}

@Composable
fun ItemCard(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CompleteLayoutPreview() {
    HolaMundoTheme {
        CompleteLayout()
    }
}