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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import java.util.Locale

@Composable
fun PuppyImage(
    imageId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .heightIn(max = 240.dp)
            .fillMaxWidth()
    )
}

@Composable
fun PuppyName(
    name: String,
    modifier: Modifier = Modifier
) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = name.toUpperCase(Locale.getDefault()),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primaryVariant,
            modifier = modifier
        )
    }
}

@Composable
fun PuppySimplifiedData(
    puppy: Puppy,
    modifier: Modifier = Modifier
) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = "${puppy.gender}  •  ${puppy.breed}",
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
    }
}

@Composable
fun PuppyExtendedData(
    puppy: Puppy,
    modifier: Modifier = Modifier
) {
    Column(Modifier.fillMaxWidth()) {
        PuppySimplifiedData(
            puppy = puppy,
            modifier = modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "${stringResource(id = R.string.age, puppy.age)} (${puppy.birthday})",
            modifier = modifier.padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.temperament, puppy.temperament),
            modifier = modifier.padding(bottom = 16.dp)
        )
    }
}
