package com.example.superheroscomposeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroscomposeapp.model.HeroModel
import com.example.superheroscomposeapp.ui.theme.SuperHeroesComposeAppTheme

@Composable
fun HeroList(
    items: List<HeroModel>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(modifier = modifier, contentPadding = contentPadding) {
        items(items) { item ->
            ListItem(item)
        }
    }
}

@Composable
fun ListItem(item: HeroModel, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .height(72.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = dimensionResource(R.dimen.padding_small))
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(item.name),
                    style = MaterialTheme.typography.displaySmall
                )

                Text(
                    text = stringResource(item.description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                modifier = Modifier
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.small),
                painter = painterResource(item.image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview("List Item", showBackground = true)
@Composable
private fun ListItemPreview() {
    SuperHeroesComposeAppTheme {
        ListItem(
            item = HeroesRepository.heroes[0],
        )
    }
}

@Preview("Heroes List", showBackground = true)
@Composable
private fun HeroesScreenPreview() {
    SuperHeroesComposeAppTheme {
        HeroList(
            items = HeroesRepository.heroes,
        )
    }
}