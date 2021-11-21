package com.udacity.shoestore.view

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ListItemShoeBinding
import com.udacity.shoestore.listeners.BindingClickListener
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeDetailsViewModel

class ShoeListFragment: Fragment(), BindingClickListener {

    private lateinit var viewBinding: FragmentShoeListBinding

    private val shoeDetailsViewModel: ShoeDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_shoe_list, container, false)

        viewBinding.viewModel = shoeDetailsViewModel

        viewBinding.clickListener= this

        shoeDetailsViewModel.shoeListLiveData.observe(viewLifecycleOwner, { shoes ->
            for (shoe in shoes) {
                addShoeToList(shoe)
            }
        })

        if (arguments?.getParcelable<Shoe>("shoeData") != null) {
            val shoe = arguments?.getParcelable<Shoe>("shoeData")
            shoeDetailsViewModel.addShoe(shoe!!)
        }

        setHasOptionsMenu(true)

        return viewBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    fun addShoeToList(shoe: Shoe) {
        val binding = DataBindingUtil.inflate<ListItemShoeBinding>(layoutInflater, R.layout.list_item_shoe, viewBinding.shoeList, false)
        binding.shoeData = shoe
        viewBinding.shoeList.addView(binding.root)
    }

    override fun onClick() {
        viewBinding.root.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
    }
}