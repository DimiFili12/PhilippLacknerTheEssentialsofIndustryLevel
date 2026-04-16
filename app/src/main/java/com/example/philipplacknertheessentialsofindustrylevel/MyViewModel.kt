package com.example.philipplacknertheessentialsofindustrylevel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel(
    private val firebaseNoteDatabase: FirebaseNoteDatabase
): ViewModel() {
    var note by mutableStateOf<Note?>(null)
        private set

    init {

    }

    private fun loadNoteWithTitle(title: String) {
        viewModelScope.launch {
            note = firebaseNoteDatabase.getNote(title = title)
        }
    }
}