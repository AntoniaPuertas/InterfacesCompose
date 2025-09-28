package com.example.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.holamundo.ui.theme.HolaMundoTheme
import kotlinx.coroutines.launch
import androidx.compose.material3.ExperimentalMaterial3Api

class ControlScrollActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoTheme {
                ScrollControlList()
            }
        }
    }
}



/**
 * 📱 FUNCIÓN: ScrollControlList
 *
 * PROPÓSITO:
 * Crea una lista vertical scrolleable con un botón flotante que aparece automáticamente
 * cuando el usuario hace scroll hacia abajo, permitiendo volver al inicio con animación.
 *
 * CONCEPTOS DEMOSTRADOS:
 * ✅ Scaffold - Estructura básica de pantalla Material Design
 * ✅ LazyColumn - Lista eficiente para grandes cantidades de datos
 * ✅ Corrutinas - Tareas ligeras para operaciones asíncronas
 * ✅ Estados derivados - Estados que se calculan automáticamente
 * ✅ Animaciones - Transiciones suaves de UI
 * ✅ FloatingActionButton - Botón de acción principal
 *
 * @param modifier Modificador para personalizar apariencia y comportamiento
 */
@OptIn(ExperimentalMaterial3Api::class) // ⚠️ Permite usar APIs experimentales de Material 3
@Composable
fun ScrollControlList(modifier: Modifier = Modifier) {
    //Genera 100 elementos de prueba para la lista
    val items = (1..100).map { "Item #$it" }
    //Controla y observa el estado de la lista
    val listState = rememberLazyListState()
    //corrutina necesaria para llamar a animateScrollToItem()
    val coroutineScope = rememberCoroutineScope()

    // Estado derivado para determinar si mostrar el botón de desplazamiento
    val showFAB by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }
    //Estructura básica de la pantalla
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Mi Lista") }
            )
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = showFAB, // Solo visible cuando no estamos en el inicio
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut()
            ) {
                FloatingActionButton(
                    onClick = {
                        //crea una nueva corrutina para llamar a animateScrollToItem()
                        coroutineScope.launch {
                            //Función suspendida que anima el scroll
                            //Se ejecuta de manera asíncrona
                            listState.animateScrollToItem(0)
                        }
                    }
                ) {
                    Icon(
                        Icons.Default.KeyboardArrowUp,
                        contentDescription = "Subir"
                    )
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    HolaMundoTheme {
        ScrollControlList()
    }
}