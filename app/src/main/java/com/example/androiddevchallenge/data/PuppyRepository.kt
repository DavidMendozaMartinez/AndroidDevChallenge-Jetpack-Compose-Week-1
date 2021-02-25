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
            "Mongrel",
            "Naughty",
            R.drawable.puppy_4
        ),
        Puppy(
            "Garland",
            "Male",
            3,
            "03/2017",
            "Pit Bull Terrier",
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