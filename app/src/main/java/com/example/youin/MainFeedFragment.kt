package com.example.youin


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youin.databinding.FragmentMainFeedBinding
import com.example.youin.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.list_selection_view_holder.view.*

/**
 * A simple [Fragment] subclass.
 */
class MainFeedFragment : Fragment() {

    //Firebase authentication stuff
    private lateinit var auth: FirebaseAuth


    var numClicks = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainFeedBinding>(inflater,
            R.layout.fragment_main_feed,container,false)

        binding.testImage1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFeedFragment_to_careerFairFragment)
        }

        binding.testImage2.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_mainFeedFragment_to_homecomingFragment)
        }

        //button action for creating new post
        binding.floatingActionButton.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_mainFeedFragment_to_createNewPost)
        }

        binding.humeImageMain.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFeedFragment_to_humeFragment)
        }

        binding.commencementImageMain.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFeedFragment_to_commencementFragment)
        }


        binding.buttonSignOut.setOnClickListener{
            if (numClicks == 1){
                signOut()
            }
            else{
                numClicks++
                Toast.makeText(activity, "Click Again to Sign Out",
                        Toast.LENGTH_SHORT).show()

            }
        }

        return binding.root
    }

    private fun signOut() {
        auth.signOut()
        numClicks = 0
        updateUI(null)
    }

    private fun updateUI(user: FirebaseUser?){
        if (user != null) {
            //this.view?.findNavController()?.navigate(R.id.action_signUpFragment_to_mainFeedFragment)
        }
        else {
            this.view?.findNavController()?.navigate(R.id.action_mainFeedFragment_to_titleFragment)
        }

    }

}
