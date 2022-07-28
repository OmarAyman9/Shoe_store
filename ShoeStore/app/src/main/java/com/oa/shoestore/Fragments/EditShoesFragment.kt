package com.oa.shoestore.Fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.oa.shoestore.Models.Shoe
import com.oa.shoestore.R
import com.oa.shoestore.databinding.FragmentEditShoesBinding
import com.oa.shoestore.databinding.FragmentShoesListBinding
import com.oa.shoestore.viewModels.ShoeListViewModel

class EditShoesFragment : Fragment() {
    private lateinit var shoe: Shoe
    private lateinit var viewModel: ShoeListViewModel
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

        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.addShoe.setOnClickListener {
            if (binding.shoeNameET.text.isEmpty() ||
                binding.shoeCompanyET.text.isEmpty() || binding.shoeSizeET.text.isEmpty() || binding.shoeDescET.text.isEmpty()
            ) {
                Toast.makeText(requireContext(),"Please Add Data", Toast.LENGTH_LONG).show()
            }else{
                val shoeName: String = binding.shoeNameET.text.toString()
                val shoeCompany = binding.shoeCompanyET.text.toString()
                val shoeSize: Int = binding.shoeSizeET.text.toString().toInt()
                val shoeDesc = binding.shoeDescET.text.toString()
                val shoe = Shoe(shoeName, shoeCompany, shoeSize, shoeDesc)
                viewModel.addToShoesList(shoe)
                findNavController().navigate(R.id.action_editShoesFragment_to_shoesListFragment)
            }

        }
        binding.cancel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_editShoesFragment_to_shoesListFragment))
        return binding.root
    }

}