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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.PuppyRepository
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.util.Event

class PuppiesViewModel : ViewModel() {
    private val puppyRepository = PuppyRepository()

    var puppies by mutableStateOf(puppyRepository.getPuppies().shuffled())
        private set

    private val _navigateToDetails = MutableLiveData<Event<Puppy>>()
    val navigateToDetails: LiveData<Event<Puppy>> get() = _navigateToDetails

    fun onItemClicked(item: Puppy) {
        _navigateToDetails.value = Event(item)
    }
}
