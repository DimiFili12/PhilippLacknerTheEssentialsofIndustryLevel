package com.example.philipplacknertheessentialsofindustrylevel

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


interface NoteDatabase {
    suspend fun saveNote(note: Note)
    suspend fun getNote(title: String): Note?
}

class NoteDatabaseFake: NoteDatabase {
    override suspend fun saveNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun getNote(title: String): Note? {
        TODO("Not yet implemented")
    }
}

class YourCustomNoteDatabase(
    private val api: JustAnExampleApi
): NoteDatabase {
    override suspend fun saveNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun getNote(title: String): Note? {
        TODO("Not yet implemented")
    }
}

class FirebaseNoteDatabase: NoteDatabase {
    val db = FirebaseFirestore.getInstance()

    override suspend fun saveNote(note: Note) {
        db.collection("notes")
            .document(note.title)
            .set(note)
            .await()
    }

    override suspend fun getNote(title: String): Note? {
        return db.collection("notes")
            .document(title)
            .get()
            .await()
            .toObject(Note::class.java)
    }
}