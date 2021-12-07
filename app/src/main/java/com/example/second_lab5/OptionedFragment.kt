package com.example.second_lab5

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.second_lab5.databinding.FragmentFirstBinding
import com.example.second_lab5.databinding.FragmentSecondBinding
import com.example.second_lab5.databinding.FragmentThirdBinding

abstract class OptionedFragment(private val choice: Int) : Fragment() {
    private lateinit var binding: ViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = if (choice == R.id.firstFragment) {
            FragmentFirstBinding.inflate(inflater, container, false)
        } else if (choice == R.id.secondFragment) {
            FragmentSecondBinding.inflate(inflater, container, false)
        } else {
            FragmentThirdBinding.inflate(inflater, container, false)
        }

        binding.root.findViewById<View>(R.id.bnToFirst2)?.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        binding.root.findViewById<View>(R.id.bnToFirst3)?.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        binding.root.findViewById<View>(R.id.bnToSecond1)?.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.root.findViewById<View>(R.id.bnToSecond3)?.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }

        binding.root.findViewById<View>(R.id.bnToThird2)?.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }


        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.aboutActivity) {
            Navigation.findNavController(binding.root).navigate(R.id.aboutActivity)
            true
        } else
            super.onOptionsItemSelected(item)
    }

}