package com.example.kotlinhw3.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.kotlinhw3.data.models.NoteModel
import com.example.kotlinhw3.ui.intetface.OnClickItem

class NoteAdapter(
    private val onLongClickItem: OnClickItem,
    private val onClickItem: OnClickItem
) : ListAdapter<NoteModel, NoteAdapter.ViewHolder>(DiffCallBack()) {


    class DiffCallBack : DiffUtil.ItemCallback<NoteModel>(){
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(private val binding: ItemNoteBinding) : {

    }
}