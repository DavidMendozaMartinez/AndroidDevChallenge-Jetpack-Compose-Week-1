package com.example.androiddevchallenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    val name: String,
    val gender: String,
    val age: Int,
    val birthday: String,
    val breed: String,
    val temperament: String,
    val imageId: Int
) : Parcelable