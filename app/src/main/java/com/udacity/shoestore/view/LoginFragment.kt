package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment: Fragment(), View.OnClickListener {

    private lateinit var viewBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_login, container, false)
        viewBinding.actionSignIn.setOnClickListener(this)
        viewBinding.actionSignUp.setOnClickListener(this)
        return viewBinding.root
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.actionSignIn, R.id.actionSignUp -> {
                viewBinding.root.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnboardingFragment())
            }
        }
    }
}