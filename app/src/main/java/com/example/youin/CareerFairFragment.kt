package com.example.youin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.youin.databinding.FragmentCareerFairBinding
import com.example.youin.databinding.FragmentSignUpBinding

/**
 * A simple [Fragment] subclass.
 */
class CareerFairFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentCareerFairBinding>(inflater,
            R.layout.fragment_career_fair,container,false)

        return binding.root
    }


}
