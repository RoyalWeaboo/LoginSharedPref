package com.malikazizali.loginsharedpref

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.malikazizali.loginsharedpref.databinding.FragmentHomeBinding
import com.malikazizali.loginsharedpref.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var sp : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sp = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            validateLogin(view)
        }

        binding.tvRegister.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }

    fun validateLogin(view : View){
        val inputUsername = binding.etLoginUsername.text.toString()
        val inputPass = binding.etLoginPassword.text.toString()

        val username = sp.getString("username","x")
        val pass = sp.getString("pass","x")
        if (inputUsername == username && inputPass == pass) {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
        }
        else{
            Toast.makeText(context, "Wrong Username or Password", Toast.LENGTH_LONG).show()
        }
    }

}