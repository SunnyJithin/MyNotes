package com.jithins.mynotes.feature_note.domain.use_case

import androidx.compose.ui.text.toLowerCase
import com.jithins.mynotes.feature_note.domain.model.Note
import com.jithins.mynotes.feature_note.domain.repository.NoteRepository
import com.jithins.mynotes.feature_note.domain.util.NoteOrder
import com.jithins.mynotes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

class GetNotesUseCase(private val repository: NoteRepository) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Color -> notes.sortedBy { it.timeStamp }
                    }
                }
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Color -> notes.sortedByDescending { it.timeStamp }
                    }
                }
            }

        }
    }
}