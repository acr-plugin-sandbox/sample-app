package com.example.sample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sample.FeatureFlags

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()
    Column(modifier = Modifier.padding(24.dp)) { 
        Text(text = state.title, style = MaterialTheme.typography.headlineSmall)
        if (FeatureFlags.SHOW_UPGRADE_BANNER) {
            Text(text = "Upgrade to unlock offline mode")
        }
    }
}
