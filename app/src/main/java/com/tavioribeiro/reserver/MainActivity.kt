package com.tavioribeiro.reserver


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tavioribeiro.reserver.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        setContent {
            MyScaffold()
            //MainContainer()
        }
    }


    @Composable
    fun MainContainer() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Greeting()
        }
    }



    @Composable
    fun Greeting() {
        Text(
            text = "Testando o Compose :)",
            color = Color.Green,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxSize() // Preenche a tela
                .wrapContentSize(Alignment.Center) // Centraliza o conteúdo
        )
    }



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyScaffold() {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Meu App" ) })
            },
            bottomBar = {

            }) { paddingValues ->
            // Conteúdo principal do Scaffold, você pode adicionar outros componentes aqui
            // paddingValues fornece as informações de padding para ajustar o conteúdo de acordo com os outros elementos do Scaffold
            Text("Conteúdo Principal", modifier = Modifier.padding(paddingValues))
        }
    }
}