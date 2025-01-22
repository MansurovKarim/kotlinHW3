package com.example.kotlinhw3.ui.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlinhw3.R
import com.example.kotlinhw3.databinding.FragmentNoteBinding


class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root

        binding.btnDetail.setOnClickListener{
            findNavController().navigate(R.id.action_noteFragment_to_detailNoteFragment)
        }
    }
}