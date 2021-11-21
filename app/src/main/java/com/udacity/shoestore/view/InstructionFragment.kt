package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.listeners.BindingClickListener

class InstructionFragment: Fragment(), BindingClickListener {

    private lateinit var viewBinding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_instruction, container, false)

        viewBinding.clickListener = this

        return viewBinding.root
    }

    override fun onClick() {
        viewBinding.root.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
    }
}