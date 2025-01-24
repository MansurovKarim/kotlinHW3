package com.example.kotlinhw3.ui.intetface

import com.example.kotlinhw3.data.models.NoteModel

interface OnClickItem {
    fun onLongClick(noteModel: NoteModel)

    fun onClick(noteModel: NoteModel)
}