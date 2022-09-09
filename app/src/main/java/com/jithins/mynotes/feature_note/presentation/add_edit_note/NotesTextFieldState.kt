package com.jithins.mynotes.feature_note.presentation.add_edit_note

data class NotesTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)