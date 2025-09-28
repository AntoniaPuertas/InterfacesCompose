package com.example.holamundo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.holamundo.ui.theme.HolaMundoTheme


/**
 * Muestra una lista de contenido mixto utilizando `LazyColumn`.
 *
 * Esta función Composable renderiza una lista vertical que incluye:
 * 1. Un encabezado de texto fijo.
 * 2. Una serie de elementos de texto, cada uno dentro de una `Card`.
 * 3. Un pie de página con un botón fijo.
 *
 * Es un ejemplo de cómo se pueden combinar diferentes tipos de ítems (`item` individual y `items` de una lista)
 * dentro de una `LazyColumn`.
 *
 * @param modifier El [Modifier] que se aplicará al componente `LazyColumn`.
 *                 Por defecto es [Modifier]. Útil para pasar paddings o configuraciones de layout.
 */
class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MixedContentList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MixedContentList(modifier: Modifier = Modifier) {
    val data = listOf("Item A", "Item B", "Item C")

    LazyColumn {
        // Header único
        item {
            Text(
                text = "Lista de elementos",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
        }

        // Lista de items con bucle
        items(data) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        // Footer único
        item {
            Button(
                onClick = { /* acción */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Cargar más")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MixedContentListPreview() {
    HolaMundoTheme {
        MixedContentList()
    }
}