package com.example.youin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.youin.databinding.FragmentAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * A simple [Fragment] subclass.
 */
class Account : Fragment() {

    //Firebase authentication stuff
    private lateinit var auth: FirebaseAuth


    var numClicks = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment



        auth = FirebaseAuth.getInstance()

        val binding = DataBindingUtil.inflate<FragmentAccountBinding>(
            inflater,
            R.layout.fragment_account, container, false
        )

        binding.foodView.loadUrl("https://grovecity.cafebonappetit.com/")

        binding.signoutButton.setOnClickListener { view ->
            if (numClicks == 1) {
                signOut()
            } else {
                numClicks++
                Toast.makeText(
                    activity, "Click Again to Sign Out",
                    Toast.LENGTH_SHORT
                ).show()

            }

        }

        return binding.root


    }

    private fun signOut() {
        auth.signOut()
        numClicks = 0
        updateUI(null)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            //this.view?.findNavController()?.navigate(R.id.action_signUpFragment_to_mainFeedFragment)
        } else {
            this.view?.findNavController()?.navigate(R.id.action_account_to_titleFragment)
        }

    }

}
