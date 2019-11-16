package com.example.youin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.youin.databinding.FragmentSignUpBinding

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSignUpBinding>(inflater,
                        R.layout.fragment_sign_up,container,false)

        return binding.root
    }


}
