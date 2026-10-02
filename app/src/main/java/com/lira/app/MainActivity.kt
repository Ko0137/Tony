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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                LiraSimpleChatScreen()
            }
        }
    }
}

@Composable
fun LiraSimpleChatScreen() {
    var textInput by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf("L.I.R.A. активна и готова к работе.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Шапка
        Text(
            text = "L.I.R.A. Assistant",
            fontSize = 20.sp,
            color = Color(0xFF6200EE),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )

        // Список сообщений
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messages) { message ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFEFEFEF))
                        .padding(12.dp)
                ) {
                    Text(
                        text = message,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Строка ввода
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = textInput,
                onValueChange = { textInput = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Введите сообщение...") },
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (textInput.isNotBlank()) {
                        messages.add("Вы: $textInput")
                        val query = textInput
                        textInput = ""
                        messages.add("L.I.R.A.: Эхо -> $query")
                    }
                }
            ) {
                Text("Отправить")
            }
        }
    }
}
