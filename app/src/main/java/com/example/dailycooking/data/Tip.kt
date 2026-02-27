package com.example.dailycooking.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    val dayNumber: Int,
    @StringRes val titleResId: Int,
    @DrawableRes val imageResId: Int,
    @StringRes val shortDescriptionResId: Int,
    @StringRes val fullDescriptionResId: Int
)
