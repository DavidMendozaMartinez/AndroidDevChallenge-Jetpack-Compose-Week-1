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
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.PuppyExtendedData
import com.example.androiddevchallenge.ui.PuppyImage
import com.example.androiddevchallenge.ui.PuppyName

@Composable
fun DetailScreen(
    puppy: Puppy,
    onAdoptButtonClicked: (Puppy) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column {
            PuppyImage(imageId = puppy.imageId)
            Spacer(Modifier.height(16.dp))
            PuppyName(
                name = puppy.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
            PuppyExtendedData(
                puppy = puppy,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            AdoptionInstructions(name = puppy.name)
            Spacer(Modifier.height(36.dp))
            AdoptButton(puppy = puppy, onAdoptButtonClicked = { onAdoptButtonClicked(puppy) })
        }
    }
}

@Composable
private fun AdoptButton(
    puppy: Puppy,
    onAdoptButtonClicked: (Puppy) -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onAdoptButtonClicked(puppy) },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
    ) {
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            painter = painterResource(id = R.drawable.ic_paw),
            contentDescription = null
        )
        Text(text = stringResource(id = R.string.button_adopt))
    }
}

@Composable
private fun AdoptionInstructions(
    name: String,
    modifier: Modifier = Modifier
) {
    val emailStyle = MaterialTheme.typography.body1.toSpanStyle().copy(
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.primary
    )
    val text = buildAnnotatedString {
        append(stringResource(R.string.adoption_instructions_first_part, name))
        withStyle(emailStyle) {
            append(stringResource(id = R.string.adoption_instructions_email))
        }
        append(stringResource(R.string.adoption_instructions_second_part))
    }
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        modifier = modifier.padding(top = 16.dp, start = 24.dp, end = 24.dp)
    )
}
