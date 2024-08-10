package com.tavioribeiro.reserver


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tavioribeiro.components.navigation.MyAppNavigation
import com.tavioribeiro.shared_resources.appearance.AppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            AppTheme(darkTheme = isDarkTheme) {
                val systemUiController = rememberSystemUiController()
                val colors = MaterialTheme.colorScheme

                //Defina a cor da barra de status aqui
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = colors.background,
                        darkIcons = !isDarkTheme // Define se os ícones devem ser escuros ou claros
                    )
                }

                MyScaffold(onThemeToggle = { isDarkTheme = !isDarkTheme })
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(onThemeToggle: () -> Unit) {
    // Aplique o tema atual
    val colors = MaterialTheme.colorScheme

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colors.background
                ),
                title = {
                    Text(
                        text = "ReServer",
                        fontFamily = interSansFamily,
                        fontWeight = FontWeight.Bold,
                        color = colors.onBackground
                    )
                },
            )
        },
        bottomBar = {
            //MyAppNavigation()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(colors.primary)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = onThemeToggle,
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp)) // Define o raio das bordas aqui
                    .background(color = colors.primary)

            ) {
                Text(
                    text = "Trocar Tema",
                    color = colors.onPrimary,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

val interSansFamily = FontFamily(
    Font(com.tavioribeiro.shared_resources.R.font.inter_regular, FontWeight.Normal),
    Font(com.tavioribeiro.shared_resources.R.font.inter_bold, FontWeight.Bold),
    Font(com.tavioribeiro.shared_resources.R.font.inter_italic, FontWeight.Normal, FontStyle.Italic),
    Font(com.tavioribeiro.shared_resources.R.font.inter_medium, FontWeight.Medium)
)

