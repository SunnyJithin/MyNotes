package com.jithins.mynotes.feature_note.presentation.util

import com.jithins.mynotes.feature_note.domain.model.Note
import com.jithins.mynotes.feature_note.domain.util.NoteOrder
import com.jithins.mynotes.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)