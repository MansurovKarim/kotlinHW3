package com.example.kotlinhw3.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlinhw3.ui.fragment.onBoard.onBoardPagerFragment
import com.example.kotlinhw3.ui.fragment.onBoard.onBoardPagerFragment.Companion.ARG_ONBOARD_POSITION

class onBoardAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = onBoardPagerFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
    }
}