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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy

class PuppyRepository {

    fun getPuppies(): List<Puppy> = listOf(
        Puppy(
            "Raki",
            "Female",
            8,
            "10/2012",
            "Mongrel",
            "Playful",
            R.drawable.puppy_1
        ),
        Puppy(
            "Mac Alan",
            "Male",
            5,
            "03/2015",
            "Mongrel",
            "Shy",
            R.drawable.puppy_2
        ),
        Puppy(
            "Zora",
            "Female",
            12,
            "02/2009",
            "Warren hound",
            "Shy",
            R.drawable.puppy_3
        ),
        Puppy(
            "Rucha",
            "Female",
            7,
            "06/2013",
            "Pit Bull Terrier",
            "Naughty",
            R.drawable.puppy_4
        ),
        Puppy(
            "Garland",
            "Male",
            3,
            "03/2017",
            "Mongrel",
            "Naughty",
            R.drawable.puppy_5
        ),
        Puppy(
            "Izan",
            "Male",
            5,
            "08/2015",
            "Mongrel",
            "Shy",
            R.drawable.puppy_6
        ),
        Puppy(
            "Deneb",
            "Female",
            11,
            "01/2010",
            "Mongrel",
            "Naughty",
            R.drawable.puppy_7
        )
    )
}
