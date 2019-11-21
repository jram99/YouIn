package com.example.youin



import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.youin.databinding.FragmentCreateNewPostBinding
import java.util.*



/**
 * A simple [Fragment] subclass.
 */
class CreateNewPost : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentCreateNewPostBinding>(inflater,
            R.layout.fragment_create_new_post,container,false)


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        binding.eventDateButton.setOnClickListener {
            Toast.makeText(activity,"Rocking",
                Toast.LENGTH_SHORT).show()

            val dpd = DatePickerDialog(activity!!, DatePickerDialog.OnDateSetListener {
                    view, year, monthOfYear, dayOfMonth ->
                binding.eventDate.text = ("$dayOfMonth/$monthOfYear/$year")
            }, year, month, day)
            dpd.show()
        }



/*
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { p0, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "MM/dd/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                binding.eventDate.text = sdf.format(cal.getTime())

                print("Yea this works too")
            }

        binding.eventDateButton.setOnClickListener {

            DatePickerDialog(context!!, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
                print("this totally works")
        } */



        // Inflate the layout for this fragment
        return binding.root
    }

}
