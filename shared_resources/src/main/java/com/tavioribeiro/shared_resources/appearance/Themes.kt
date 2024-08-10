package com.tavioribeiro.shared_resources.appearance

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object AppTheme {
    val lightColors = lightColorScheme(
        primary = Color(0xFFE4FF5A), // Yellow - Cor principal, usada no botão "All Stacks"
        onPrimary = Color.Black, // Black - Cor do texto sobre a cor primária
        secondary = Color(0xFFE0E0E0), // Light Gray - Cor dos botões inativos ("Private", "Shared with")
        onSecondary = Color(0xFF616161), // Dark Gray - Cor do texto sobre os botões inativos
        background = Color(0xFFF5F5F5), // Very Light Gray - Cor de fundo da tela
        onBackground = Color(0xFF212121), // Dark Gray - Cor do texto principal ("Find a card...", "Top Spots...")
        surface = Color(0xFFF5F5F5), // Very Light Gray - Cor da superfície do card "Top Spots..."
        onSurface = Color(0xFF212121), // Dark Gray - Cor do texto no card "Top Spots..."
        surfaceVariant = Color(0xFFEEEEEE), //  Light Gray - Cor do círculo que contém o número de resultados
        onSurfaceVariant = Color(0xFFBDBDBD) // Gray - Cor do número de resultados dentro do círculo
    )

    val darkColors = darkColorScheme(
        primary = Color(0xFFA0CE37), // Darker Yellow - Cor principal, usada no botão "All Stacks"
        onPrimary = Color.Black, // Black - Cor do texto sobre a cor primária
        secondary = Color(0xFF424242), // Dark Gray - Cor dos botões inativos ("Private", "Shared with")
        onSecondary = Color(0xFFBDBDBD), // Light Gray - Cor do texto sobre os botões inativos
        background = Color(0xFF121212), // Dark Background - Cor de fundo da tela
        onBackground = Color(0xFFFFFFFF), // White - Cor do texto principal ("Find a card...", "Top Spots...")
        surface = Color(0xFF1E1E1E), // Darker Gray - Cor da superfície do card "Top Spots..."
        onSurface = Color(0xFFFFFFFF), // White - Cor do texto no card "Top Spots..."
        surfaceVariant = Color(0xFF252525), // Darker Gray - Cor do círculo que contém o número de resultados
        onSurfaceVariant = Color(0xFF9E9E9E) // Light Gray - Cor do número de resultados dentro do círculo
    )
}


@Composable
fun AppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) AppTheme.darkColors else AppTheme.lightColors,
        typography = Typography(),
        content = content
    )
}