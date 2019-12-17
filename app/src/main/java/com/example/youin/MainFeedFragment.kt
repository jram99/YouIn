package com.example.youin


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.youin.databinding.FragmentMainFeedBinding
import com.example.youin.databinding.FragmentSignUpBinding
import kotlinx.android.synthetic.main.fragment_main_feed.view.*
import java.io.File

/**
 * A simple [Fragment] subclass.
 */
class MainFeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainFeedBinding>(inflater,
            R.layout.fragment_main_feed,container,false)

        binding.testImage1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFeedFragment_to_careerFairFragment)
        }

        binding.testImage2.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFeedFragment_to_homecomingFragment)
        }


        binding.testImage3.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFeedFragment_to_swimFragment)
        }

        binding.floatingActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFeedFragment_to_createNewPost)
        }


        return binding.root
    }


}
