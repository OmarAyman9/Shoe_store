package com.oa.shoestore.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.oa.shoestore.R
import com.oa.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionBinding = FragmentInstructionBinding.inflate(inflater, container, false)
        binding.toShoesList.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_instructionFragment_to_shoesListFragment))
        return binding.root
    }
}