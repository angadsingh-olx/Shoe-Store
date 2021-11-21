package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment: Fragment(), View.OnClickListener {

    private lateinit var viewBinding: FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_details, container, false)
        viewBinding.actionSave.setOnClickListener(this)
        viewBinding.actionCancel.setOnClickListener(this)
        return viewBinding.root
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.actionSave -> {
                if (viewBinding.shoeNameEdt.text.isNullOrEmpty()||
                    viewBinding.shoeSizeEdt.text.isNullOrEmpty()||
                    viewBinding.companyNameEdt.text.isNullOrEmpty()||
                    viewBinding.descriptionEdt.text.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), getString(R.string.label_empty_error), Toast.LENGTH_LONG).show()
                    return
                }

                val shoeData = Shoe(
                    viewBinding.shoeNameEdt.text.toString(),
                    viewBinding.shoeSizeEdt.text.toString().toDouble(),
                    viewBinding.companyNameEdt.text.toString(),
                    viewBinding.descriptionEdt.text.toString()
                )
                viewBinding.root.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment(shoeData))
            }

            R.id.actionCancel -> {
                viewBinding.root.findNavController().navigateUp()
            }
        }
    }
}