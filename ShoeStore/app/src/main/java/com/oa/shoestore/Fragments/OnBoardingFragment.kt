package com.oa.shoestore.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.oa.shoestore.R
import com.oa.shoestore.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentOnBoardingBinding =
            FragmentOnBoardingBinding.inflate(inflater, container, false)
        binding.toInstructions.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_onBoardingFragment_to_instructionFragment))

        return binding.root
    }
}