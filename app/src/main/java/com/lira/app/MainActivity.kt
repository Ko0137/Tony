package com.lira.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                LiraChatScreen()
            }
        }
    }
}

@Composable
fun LiraChatScreen() {
    var textInput by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf("L.I.R.A. успешно запущена и готова к работе.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "L.I.R.A. Assistant",
            fontSize = 22.sp,
            color = Color(0xFF6200EE),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messages) { message ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFFF0F0F0),
                    shape = MaterialTheme.shapes.medium
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
                        messages.add("L.I.R.A.: Ответ на \"$query\"")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
            ) {
                Text("Отправить", color = Color.White)
            }
        }
    }
}
