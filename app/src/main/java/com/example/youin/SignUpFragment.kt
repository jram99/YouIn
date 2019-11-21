package com.example.youin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.youin.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSignUpBinding>(inflater,
                        R.layout.fragment_sign_up,container,false)

        binding.confirmAccount.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_signUpFragment_to_mainFeedFragment)
        }

        return binding.root
    }



}
