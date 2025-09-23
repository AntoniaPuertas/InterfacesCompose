package com.example.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.holamundo.ui.theme.HolaMundoTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Avatar2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PerfilUsuario2(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * ✅ Función principal que muestra el perfil de usuario con avatar de iniciales
 *
 * Esta función crea un avatar circular con las iniciales del usuario
 * utilizando:
 * - Box: Contenedor principal para el avatar
 * - Modifier.size(80.dp): Define el tamaño del avatar
 * - Modifier.clip(CircleShape): Hace el avatar circular
 * - Modifier.background(Color(0xFF3498DB)): Color azul de fondo
 * - contentAlignment = Alignment.Center: Centra las iniciales
 * - Text con "AG": Muestra las iniciales en blanco y negrita
 */
@Composable
fun PerfilUsuario2(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Card contenedor del perfil
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // ✅ AVATAR CON INICIALES - Implementación exacta según especificaciones
                Box(
                    modifier = Modifier
                        .size(80.dp)                           // Tamaño del avatar
                        .clip(CircleShape)                      // Forma circular
                        .background(Color(0xFF3498DB)),         // Color azul de fondo
                    contentAlignment = Alignment.Center         // Centra el contenido
                ) {
                    // Texto con las iniciales
                    Text(
                        text = "AG",                            // Iniciales
                        color = Color.White,                    // Color blanco
                        fontWeight = FontWeight.Bold,           // Texto en negrita
                        fontSize = 28.sp                        // Tamaño de fuente
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Información adicional del usuario
                Text(
                    text = "Ana García",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "ana.garcia@example.com",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = "Desarrolladora Android",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        // Ejemplo adicional con diferentes iniciales y colores
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Más ejemplos de avatares:",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Avatar 1
            AvatarConIniciales(
                iniciales = "JD",
                color = Color(0xFF9B59B6)  // Púrpura
            )

            // Avatar 2
            AvatarConIniciales(
                iniciales = "ML",
                color = Color(0xFFE74C3C)  // Rojo
            )

            // Avatar 3
            AvatarConIniciales(
                iniciales = "PC",
                color = Color(0xFF2ECC71)  // Verde
            )

            // Avatar 4
            AvatarConIniciales(
                iniciales = "TS",
                color = Color(0xFFF39C12)  // Naranja
            )
        }
    }
}

/**
 * Función reutilizable para crear avatares con iniciales personalizadas
 *
 * @param iniciales Las iniciales a mostrar en el avatar
 * @param color Color de fondo del avatar
 * @param size Tamaño del avatar (por defecto 60.dp)
 */
@Composable
fun AvatarConIniciales(
    iniciales: String,
    color: Color = Color(0xFF3498DB),
    size: Int = 60
) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = iniciales,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = (size * 0.35).sp  // Tamaño proporcional al avatar
        )
    }
}

/**
 * Preview de la función PerfilUsuario
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilUsuarioPreview() {
    MaterialTheme {
        PerfilUsuario2()
    }
}

/**
 * Función alternativa que permite personalizar los datos del usuario
 */
@Composable
fun PerfilUsuarioPersonalizable(
    nombre: String = "Usuario",
    apellido: String = "Ejemplo",
    email: String = "usuario@example.com",
    cargo: String = "Profesional",
    colorAvatar: Color = Color(0xFF3498DB)
) {
    // Obtener las iniciales del nombre y apellido
    // Si el nombre o apellido está vacío, se muestra una cadena vacía
    // Si no, se toma el primer carácter de cada nombre y apellido
    // Se convierten a mayúsculas y se concatenan
    // Ejemplo: "Antonia" y "Puertas" se mostrarán como "AP"
    // Explicado en 13-generacion-iniciales
    val iniciales = "${nombre.firstOrNull() ?: ""}${apellido.firstOrNull() ?: ""}"
        .uppercase()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar con las iniciales dinámicas
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(colorAvatar),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = iniciales,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "$nombre $apellido",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = email,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = cargo,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

/**
 * Preview de la función personalizable
 */
@Preview(showBackground = true)
@Composable
fun PerfilUsuarioPersonalizablePreview() {
    MaterialTheme {
        Column {
            PerfilUsuarioPersonalizable(
                nombre = "Antonia",
                apellido = "Puertas",
                email = "a.puertas@atlantidaformacionprofesional.com",
                cargo = "Ingeniera de Software",
                colorAvatar = Color(0xFF16A085)
            )
        }
    }
}