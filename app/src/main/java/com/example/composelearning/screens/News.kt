package com.example.composelearning.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composelearning.generated.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun News() {
    Scaffold(topBar = { Text(text = "Hello") }, content = { padding ->
        Box(modifier = Modifier.padding(paddingValues = padding))
    })
}