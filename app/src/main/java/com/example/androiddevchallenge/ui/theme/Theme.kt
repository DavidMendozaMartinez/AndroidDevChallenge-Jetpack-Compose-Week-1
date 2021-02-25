/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Green200,
    primaryVariant = Green400,
    onPrimary = Black900,
    secondary = Green200,
    secondaryVariant = Green400,
    onSecondary = Black900,
    background = Black800,
    onBackground = White200,
    surface = Black800,
    onSurface = White200,
    error = Cyan500,
    onError = Black900
)

private val LightColorPalette = lightColors(
    primary = Green400,
    primaryVariant = Green600,
    onPrimary = Black800,
    secondary = Green400,
    secondaryVariant = Green600,
    onSecondary = Black800,
    background = White200,
    onBackground = Black800,
    surface = White200,
    onSurface = Black800,
    error = Cyan500,
    onError = Black900
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}