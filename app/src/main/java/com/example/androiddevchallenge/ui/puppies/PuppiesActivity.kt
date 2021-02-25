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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.PuppyRepository
import com.example.androiddevchallenge.ui.theme.MyTheme

class PuppiesActivity : AppCompatActivity() {

    private val viewModel by viewModels<PuppiesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    PuppiesScreen(
                        items = viewModel.puppies,
                        onItemClicked = viewModel::onItemClicked
                    )
                }
            }
        }

        viewModel.navigateToDetails.observe(this) {
            it.getContentIfNotHandled()?.let { }
        }
    }
}

@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        PuppiesScreen(
            items = PuppyRepository().getPuppies(),
            onItemClicked = {}
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}