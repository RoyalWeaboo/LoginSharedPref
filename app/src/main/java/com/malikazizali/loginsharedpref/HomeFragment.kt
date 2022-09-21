package com.malikazizali.loginsharedpref

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.malikazizali.loginsharedpref.databinding.FragmentHomeBinding
import com.malikazizali.loginsharedpref.databinding.FragmentRegisterBinding

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var sp : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sp = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val name = sp.getString("fullname","")

        binding.tvFullname.text = "Hello, "+name+" !"

        binding.btnLogout.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

}