package com.lira.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Используем стандартную светлую схему Material3 принудительно, чтобы всё было видно
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Color(0xFF6200EE),
                    onPrimary = Color.White,
                    background = Color(0xFFF5F5F5),
                    surface = Color.White,
                    onSurface = Color.Black
                )
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LiraChatScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LiraChatScreen() {
    var textInput by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf("L.I.R.A. готова к работе. Задайте вопрос.") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("L.I.R.A. Assistant", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF5F5F5))
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Список сообщений чата
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(messages) { message ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Text(
                            text = message,
                            modifier = Modifier.padding(12.dp),
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Панель ввода
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = textInput,
                    onValueChange = { textInput = it },
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.White, shape = MaterialTheme.shapes.small),
                    placeholder = { Text("Введите запрос...") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        if (textInput.isNotBlank()) {
                            messages.add("Вы: $textInput")
                            val query = textInput
                            textInput = ""
                            messages.add("L.I.R.A.: Обрабатываю запрос: \"$query\"")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
                ) {
                    Text("Отправить", color = Color.White)
                }
            }
        }
    }
}
