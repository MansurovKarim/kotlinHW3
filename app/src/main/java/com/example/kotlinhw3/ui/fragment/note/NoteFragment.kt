package com.example.kotlinhw3.ui.fragment.note

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinhw3.App
import com.example.kotlinhw3.R
import com.example.kotlinhw3.data.models.NoteModel
import com.example.kotlinhw3.databinding.FragmentNoteBinding
import com.example.kotlinhw3.ui.adapter.NoteAdapter
import com.example.kotlinhw3.ui.intetface.OnClickItem
import com.example.kotlinhw3.utils.PreferenceHelper


class NoteFragment : Fragment() , OnClickItem {

    private lateinit var binding: FragmentNoteBinding
    private val noteAdapter = NoteAdapter(this, this)
    private val sharedPreferences = PreferenceHelper()
    private var layoutManager = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        getData()
    }



    private fun initialize() = with(binding) {
        sharedPreferences.init(requireContext())
        if (sharedPreferences.isLinearLayout()) {
            rvNote.layoutManager = LinearLayoutManager(context)
        } else {
            rvNote.layoutManager = GridLayoutManager(context, 2)
        }
        rvNote.adapter = noteAdapter
    }

    private fun setupListener() {
        binding.btnDetail.setOnClickListener {
            findNavController().navigate(R.id.detailNoteFragment)
        }
        binding.btnChange.setOnClickListener {
            if(noteAdapter.currentList.isNotEmpty()) {
                layoutManager = !layoutManager
                if (layoutManager) {
                    sharedPreferences.layoutManager = true
                    binding.rvNote.layoutManager = LinearLayoutManager(context)
                } else {
                    sharedPreferences.layoutManager = false
                    binding.rvNote.layoutManager = GridLayoutManager(context, 2)
                }
            }
        }
    }

    private fun getData() {
        App.appDataBase?.noteDao()?.getAll()?.observe(viewLifecycleOwner) { listNote ->
            noteAdapter.submitList(listNote)
        }
    }


    override fun onLongClick(noteModel: NoteModel) {
        val builder = AlertDialog.Builder(requireContext())
        with(builder) {
            setTitle("Удалить заметку?")
            setPositiveButton("Удалить") { _, _ ->
                App.appDataBase?.noteDao()?.deleteNote(noteModel)
                getData()
            }
            setNegativeButton("Отмена") { dialog, _ ->
                dialog.cancel()
            }
            show()
        }
        builder.create()
    }

    override fun onClick(noteModel: NoteModel) {
        val action = noteModel.id?.let {
            NoteFragmentDirections.actionNoteFragmentToDetailNoteFragment(
                it
            )
        }
        if (action != null) {
            findNavController().navigate(action)
        }
    }
}