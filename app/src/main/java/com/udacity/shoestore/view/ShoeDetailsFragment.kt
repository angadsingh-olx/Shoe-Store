package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.listeners.ShoeDetailsClickListener
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment: Fragment(), ShoeDetailsClickListener {

    private lateinit var viewBinding: FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_shoe_details, container, false)
        viewBinding.lifecycleOwner = this
        viewBinding.clickListener = this
        viewBinding.shoe = Shoe()
        return viewBinding.root
    }

    override fun onCancel() {
        viewBinding.root.findNavController().navigateUp()
    }

    override fun onSave() {
        viewBinding.shoe?.size = viewBinding.shoeSizeEdt.text.toString().toDouble()
        viewBinding.root.findNavController().navigate(
            ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment(
                viewBinding.shoe!!
            )
        )
    }
}