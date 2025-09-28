package com.example.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.holamundo.ui.theme.HolaMundoTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImagenConPlaceholder(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImagenConPlaceholder(modifier: Modifier = Modifier) {

    GlideImage(
        model = "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png",
        contentDescription = "Superman",
        modifier = Modifier.size(150.dp),
        loading = placeholder(R.drawable.baseline_cloud_download_24),
        failure = placeholder(R.drawable.outline_account_circle_off_24)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    HolaMundoTheme {
        ImagenConPlaceholder()
    }
}