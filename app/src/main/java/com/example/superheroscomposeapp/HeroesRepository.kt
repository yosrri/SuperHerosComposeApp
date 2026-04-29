package com.example.superheroscomposeapp

import com.example.superheroscomposeapp.model.HeroModel

object HeroesRepository {
    val heroes = listOf(
        HeroModel(
            name = R.string.hero1,
            description = R.string.description1,
            image = R.drawable.android_superhero1,
        ),
        HeroModel(
            name = R.string.hero2,
            description = R.string.description2,
            image = R.drawable.android_superhero2,
        ),
        HeroModel(
            name = R.string.hero3,
            description = R.string.description3,
            image = R.drawable.android_superhero3,
        ),
        HeroModel(
            name = R.string.hero4,
            description = R.string.description4,
            image = R.drawable.android_superhero4,
        ),
        HeroModel(
            name = R.string.hero5,
            description = R.string.description5,
            image = R.drawable.android_superhero5,
        ),
        HeroModel(
            name = R.string.hero6,
            description = R.string.description6,
            image = R.drawable.android_superhero6,
        ),
    )
}