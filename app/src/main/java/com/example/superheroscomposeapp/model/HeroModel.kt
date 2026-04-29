package com.example.superheroscomposeapp.model

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class HeroModel(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
