package com.oa.shoestore.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.oa.shoestore.models.Shoe
import com.oa.shoestore.R
import com.oa.shoestore.databinding.FragmentEditShoesBinding
import com.oa.shoestore.viewModels.ShoeListViewModel

class EditShoesFragment : Fragment() {
    private lateinit var shoeViewModel: ShoeListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentEditShoesBinding =
            FragmentEditShoesBinding.inflate(inflater, container, false)

        shoeViewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.viewModel = shoeViewModel
        binding.shoeInput = Shoe("", "", "", "")
        shoeViewModel.added.observe(viewLifecycleOwner, Observer { isAdded ->
            if (isAdded) {
                findNavController().navigate(R.id.action_editShoesFragment_to_shoesListFragment)
                shoeViewModel.setAddedToFalse()
            }
        })

        binding.cancel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_editShoesFragment_to_shoesListFragment))
        return binding.root
    }

}