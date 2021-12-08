package com.example.second_lab5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.second_lab5.databinding.FragmentSecondBinding


class SecondFragment : OptionedFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        super.onCreateView(inflater, container, savedInstanceState)
        val view = binding.root
        view.findViewById<Button>(R.id.bnToFirst).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_secondFragment_to_firstFragment)
        }
        view.findViewById<Button>(R.id.bnToThird).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_secondFragment_to_thirdFragment)
        }
        return view
    }
}