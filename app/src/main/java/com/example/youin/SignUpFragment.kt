package com.example.youin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.youin.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSignUpBinding>(inflater,
                        R.layout.fragment_sign_up,container,false)

        binding.buttonConfirmAccount.setOnClickListener { view: View ->
            val email = binding.enterEmail.text.toString()
            val password = binding.enterPassword.text.toString()
            val passwordConfirm = binding.confirmPassword.text.toString()
            if (password == passwordConfirm){
                createAccount(email, password)
            }

        }

        return binding.root
    }

    private fun createAccount(email: String, password: String) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        //Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        updateUI(user)
                    }
                    else {
                        //If sign up fails, let user know
                        Toast.makeText(activity, "Unable to Create Account",
                                Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }

                }
    }

    private fun updateUI(user: FirebaseUser?){
        if (user != null) {
            this.view?.findNavController()?.navigate(R.id.action_signUpFragment_to_mainFeedFragment)
        }

    }


}
