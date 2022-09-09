package com.jithins.mynotes.feature_note.domain.use_case

import com.jithins.mynotes.feature_note.domain.model.Note
import com.jithins.mynotes.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}