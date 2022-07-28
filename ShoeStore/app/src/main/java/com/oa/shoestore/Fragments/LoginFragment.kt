package com.oa.shoestore.Fragments

import android.os.Binder
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.oa.shoestore.R
import com.oa.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_onBoardingFragment))
        binding.button2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_onBoardingFragment))

        return binding.root
    }

}