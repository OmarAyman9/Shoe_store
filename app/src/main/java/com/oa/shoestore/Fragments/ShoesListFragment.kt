package com.oa.shoestore.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.oa.shoestore.models.Shoe
import com.oa.shoestore.R
import com.oa.shoestore.databinding.FragmentShoesListBinding
import com.oa.shoestore.databinding.ShoeRowBinding
import com.oa.shoestore.viewModels.ShoeListViewModel

class ShoesListFragment : Fragment() {
    private lateinit var viewModel: ShoeListViewModel
    lateinit var binding: FragmentShoesListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //show Option Menu
        setHasOptionsMenu(true)
        //Initialize Binding
        binding =
            FragmentShoesListBinding.inflate(inflater, container, false)

        //Initialize View Mode and use it
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        viewModel.shoeList.observe(viewLifecycleOwner) {
            it.forEach { shoe ->
                addView(shoe)
            }
        }

        //OnClick Listeners
        binding.addShoe.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_editShoesFragment))
        return binding.root
    }

    private fun addView(s: Shoe) {
        val shoeRowBinding = ShoeRowBinding.inflate(layoutInflater,binding.shoesListLayout,false)
        shoeRowBinding.shoeData= s
        binding.shoesListLayout.addView(shoeRowBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logoutItem -> {
                findNavController().navigate(R.id.action_shoesListFragment_to_loginFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}