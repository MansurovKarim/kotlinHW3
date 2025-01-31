package com.example.kotlinhw3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinhw3.data.models.NoteModel
import com.example.kotlinhw3.databinding.ItemNoteBinding
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

    class ViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: NoteModel){
            binding.txtTitle.text = item.title
            binding.txtDecription.text = item.description
            itemView.setBackgroundResource(item.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnLongClickListener {
            onLongClickItem.onLongClick(getItem(position))
            true
        }
        holder.itemView.setOnClickListener {
            onClickItem.onClick(getItem(position))
        }
    }
}