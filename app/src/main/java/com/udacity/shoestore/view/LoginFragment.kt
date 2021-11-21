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
import com.udacity.shoestore.listeners.LoginClickListener

class LoginFragment: Fragment(), LoginClickListener {

    private lateinit var viewBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_login, container, false)
        viewBinding.clickListener = this
        return viewBinding.root
    }

    override fun onSignIn() {
        viewBinding.root.findNavController()
            .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }

    override fun onSignUp() {
        viewBinding.root.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }
}