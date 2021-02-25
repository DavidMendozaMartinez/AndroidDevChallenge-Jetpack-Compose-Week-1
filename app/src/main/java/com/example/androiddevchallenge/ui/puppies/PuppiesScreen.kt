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
package com.example.androiddevchallenge.ui.puppies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.PuppyImage
import com.example.androiddevchallenge.ui.PuppyName
import com.example.androiddevchallenge.ui.PuppySimplifiedData

@Composable
fun PuppiesScreen(
    items: List<Puppy>,
    onItemClicked: (Puppy) -> Unit
) {
    Column {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items = items) { puppy ->
                PuppyRow(
                    puppy = puppy,
                    onItemClicked = { onItemClicked(puppy) },
                    modifier = Modifier.fillParentMaxWidth()
                )
            }
        }
    }
}

@Composable
fun PuppyRow(
    puppy: Puppy,
    onItemClicked: (Puppy) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(modifier) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClicked(puppy) }
            ) {
                val padding = Modifier.padding(horizontal = 16.dp)

                PuppyImage(imageId = puppy.imageId)
                Spacer(Modifier.height(16.dp))
                PuppyName(name = puppy.name, modifier = padding)
                PuppySimplifiedData(puppy = puppy, modifier = padding)
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}
