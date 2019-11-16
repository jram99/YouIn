package com.example.youin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.youin.databinding.FragmentTitle2Binding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTitle2Binding>(inflater, R.layout.fragment_title2,container,false)

        binding.makeAccount.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_signUpFragment)
        }

        binding.button.setOnClickListener { view: View ->
            var username = binding.username.text
            var password = binding.password.text
            if(username.isNotEmpty() and password.isNotEmpty()) {
                view.findNavController().navigate(R.id.action_titleFragment_to_mainFeedFragment)
            }
        }

        return binding.root
    }


}
