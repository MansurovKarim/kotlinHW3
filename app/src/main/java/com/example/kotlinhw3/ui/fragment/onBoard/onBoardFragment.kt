package com.example.kotlinhw3.ui.fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinhw3.R
import com.example.kotlinhw3.databinding.FragmentOnBoardBinding
import com.example.kotlinhw3.ui.adapter.onBoardAdapter
import com.example.kotlinhw3.utils.PreferenceHelper

class onBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var sharedPreference: PreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreference = PreferenceHelper()
        sharedPreference.init(requireContext())

        if (sharedPreference.isOnBoardingCompleted()) {
            findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
        }else{
            initialize()
            setupListener()
        }
    }


    private fun initialize() {
        binding.viewPager.adapter = onBoardAdapter(this)
    }

    private fun setupListener() = with(binding.viewPager) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
                    binding.TVSkip.visibility = View.INVISIBLE
                } else {
                    binding.TVSkip.visibility = View.VISIBLE
                }
            }
        })
        binding.TVSkip.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 2, true)
            }
        }
        binding.btnNavigate.setOnClickListener {
            sharedPreference.setOnBoardingCompleted(true)
            findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
        }
    }
}
