package com.example.second_lab5

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.navigation.Navigation
import com.example.second_lab5.databinding.FragmentFirstBinding

class FirstFragment : OptionedFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        super.onCreateView(inflater, container, savedInstanceState)
        val view = binding.root
        view.findViewById<Button>(R.id.bnToSecond).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return view
    }
}