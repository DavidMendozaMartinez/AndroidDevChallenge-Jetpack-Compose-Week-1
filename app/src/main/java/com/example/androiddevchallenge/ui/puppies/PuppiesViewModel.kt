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