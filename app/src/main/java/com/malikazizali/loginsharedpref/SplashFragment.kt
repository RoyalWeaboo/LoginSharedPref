package com.malikazizali.loginsharedpref

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.Navigation
import com.malikazizali.loginsharedpref.databinding.FragmentLoginBinding
import com.malikazizali.loginsharedpref.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    lateinit var binding : FragmentSplashBinding
    lateinit var sp : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sp = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val username = sp.getString("username","")
        val pass = sp.getString("pass","")

        Handler().postDelayed({
            if(username!="" && pass!="")
                Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_homeFragment)
            else
                Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment)
        }, 3000)
    }

}