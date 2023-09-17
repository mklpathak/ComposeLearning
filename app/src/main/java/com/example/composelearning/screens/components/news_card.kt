package com.example.composelearning.screens.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composelearning.generated.Article
import com.example.composelearning.utils.LifecycleComposable
import com.example.composelearning.utils.onPause
import com.example.composelearning.utils.onResume

@Composable
fun NewsCard(article: Article, onClick:(article: Article)->Unit) {

    LifecycleComposable {

        onPause {
            Log.d("LifeCycle","onPause")
        }

        onResume {
            Log.d("LifeCycle","onResume")

        }

    }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                onClick(article)
            }

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = article.title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            article.description?.let {
                Text(text = article.description, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
