package com.example.philipplacknertheessentialsofindustrylevel

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirebaseNoteDatabase {
    val db = FirebaseFirestore.getInstance()

    suspend fun saveNote(note: Note) {
        db.collection("notes")
            .document(note.title)
            .set(note)
            .await()
    }

    suspend fun getNote(title: String): Note? {
        return db.collection("notes")
            .document(title)
            .get()
            .await()
            .toObject(Note::class.java)
    }
}