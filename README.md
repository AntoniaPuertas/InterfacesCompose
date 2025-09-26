# HolaMundo - Android Jetpack Compose Learning Project

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

Un proyecto de aprendizaje de Android que demuestra diferentes conceptos fundamentales de **Jetpack Compose** a través de múltiples actividades interactivas.

## 📋 Descripción

HolaMundo es una aplicación Android diseñada para enseñar los conceptos básicos de Jetpack Compose, incluyendo gestión de estado, navegación, formularios, listas y componentes personalizados. Cada actividad se enfoca en un aspecto específico del desarrollo con Compose.

## ✨ Características

### 🎯 Actividades Incluidas

| Actividad | Descripción | Conceptos Aprendidos |
|-----------|-------------|---------------------|
| **MainActivity** | Pantalla de bienvenida simple | Composables básicos, Text, Column |
| **AvatarActivity** | Perfil de usuario con imagen | Image, CircleShape, Layouts |
| **Avatar2Activity** | Avatares con iniciales personalizadas | Box, Background, Clip, Reutilización |
| **ContadorActivity** | Contador interactivo | Estado (`remember`), Button, Event handling |
| **TareasActivity** | Lista de tareas | LazyColumn, Cards, Listas |
| **FormularioActivity** | Formulario de registro | TextField, Form validation, Estado |
| **InicioActivity** | Navegación entre pantallas | Navigation Compose, NavController |
| **EstadosActivity** | Temporizador con efectos | LaunchedEffect, Coroutines, Estado avanzado |

### 🛠️ Tecnologías Utilizadas

- **Kotlin** - Lenguaje de programación principal
- **Jetpack Compose** - Toolkit moderno de UI para Android
- **Material Design 3** - Sistema de diseño de Google
- **Navigation Compose** - Navegación declarativa


## 🚀 Instalación y Ejecución

### Prerrequisitos

- Android Studio Electric Eel (o superior)
- JDK 11 o superior
- SDK de Android (API 24 o superior)
- Dispositivo Android o emulador

### Pasos para ejecutar

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/tuusuario/holamundo.git
   cd holamundo
   ```

2. **Abre el proyecto en Android Studio**
   - Abre Android Studio
   - Selecciona "Open an existing project"
   - Navega hasta la carpeta del proyecto y ábrelo

3. **Sincroniza las dependencias**
   - Android Studio sincronizará automáticamente las dependencias de Gradle
   - Espera a que termine el proceso

4. **Ejecuta la aplicación**
   - Conecta un dispositivo Android o inicia un emulador
   - Haz clic en el botón "Run" (▶️) o presiona `Shift + F10`

## 📱 Capturas de Pantalla

### Funcionalidades Principales

#### 🎨 Avatares Personalizados
- Avatares circulares con imágenes
- Generación automática de iniciales
- Múltiples colores y estilos

#### 🔢 Contador Interactivo
- Botones de incremento y decremento
- Gestión de estado reactivo
- Interfaz intuitiva

#### 📝 Formularios Dinámicos
- Campos de entrada validados
- Respuesta en tiempo real
- Material Design

#### ⏱️ Temporizador Avanzado
- Cuenta regresiva automática
- Control de reproducción/pausa
- Efectos visuales condicionales

## 🏗️ Estructura del Proyecto

```
app/src/main/java/com/example/holamundo/
├── MainActivity.kt           # Pantalla principal
├── AvatarActivity.kt        # Perfiles con imágenes
├── Avatar2Activity.kt       # Avatares con iniciales
├── ContadorActivity.kt      # Contador interactivo
├── TareasActivity.kt        # Lista de tareas
├── FormularioActivity.kt    # Formulario de registro
├── InicioActivity.kt        # Navegación
├── EstadosActivity.kt       # Temporizador y efectos
└── ui/theme/               # Temas y estilos
    ├── Color.kt
    ├── Theme.kt
    └── Type.kt
```

## 📚 Conceptos de Jetpack Compose Demostrados

### 🔧 Composables Básicos
- `Text` - Mostrar texto con estilos
- `Button` - Botones interactivos
- `Image` - Mostrar imágenes
- `Column/Row` - Layouts verticales y horizontales

### 🎛️ Gestión de Estado
```kotlin
var contador by remember { mutableStateOf(0) }
```

### 🎨 Modificadores
```kotlin
Modifier
    .size(80.dp)
    .clip(CircleShape)
    .background(Color.Blue)
```

### 🚦 Navegación
```kotlin
NavHost(navController, startDestination = "inicio") {
    composable("inicio") { PantallaInicio() }
    composable("perfil") { PantallaPerfil() }
}
```

### ⚡ Efectos y Corrutinas
```kotlin
LaunchedEffect(activo) {
    while (activo && tiempo > 0) {
        delay(1000)
        tiempo--
    }
}
```

## 🔧 Configuración del Proyecto

### Build.gradle (App Level)
- **Compile SDK**: 36
- **Min SDK**: 24
- **Target SDK**: 36
- **Java Version**: 11
- **Kotlin**: 2.0.21

### Dependencias Principales
```kotlin
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.navigation:navigation-compose:2.9.4")
implementation("androidx.activity:activity-compose:1.8.0")
```

## 🎯 Objetivos de Aprendizaje

Al explorar este proyecto, aprenderás:

- ✅ Sintaxis básica de Jetpack Compose
- ✅ Gestión de estado en aplicaciones reactivas
- ✅ Creación de interfaces de usuario declarativas
- ✅ Navegación entre pantallas
- ✅ Manejo de eventos de usuario
- ✅ Uso de LazyColumn para listas eficientes
- ✅ Integración de Material Design 3
- ✅ Programación asíncrona con Coroutines



**¡Feliz coding con Jetpack Compose! 🚀✨**
