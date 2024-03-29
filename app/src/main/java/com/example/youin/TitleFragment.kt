package com.example.youin


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.youin.databinding.FragmentTitle2Binding
import com.example.youin.databinding.FragmentTitle2BindingImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTitle2Binding>(inflater, R.layout.fragment_title2,container,false)
        binding.buttonMakeAccount.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_signUpFragment)
        }

        binding.buttonSignIn.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            signIn(username, password)
        }

        return binding.root
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(user: FirebaseUser?){
        if (user != null){
            this.view?.findNavController()?.navigate(R.id.action_titleFragment_to_mainFeedFragment)
        }

    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(activity, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }

                }
    }





}
