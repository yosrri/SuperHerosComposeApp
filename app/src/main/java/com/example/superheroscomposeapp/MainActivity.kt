package com.example.superheroscomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroscomposeapp.ui.theme.SuperHeroesComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroesComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    SuperHeroesApp(
                        name = R.string.app_name
                    )
                }
            }
        }
    }
}

@Composable
fun SuperHeroesApp(@StringRes name: Int, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(name) }
    ) { innerPadding ->
        HeroList(HeroesRepository.heroes, contentPadding = innerPadding)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(@StringRes name: Int, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SuperHeroesAppPreview() {
    SuperHeroesComposeAppTheme {
        SuperHeroesApp(R.string.app_name)
    }
}