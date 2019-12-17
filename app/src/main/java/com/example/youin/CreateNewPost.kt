package com.example.youin



import android.app.Activity.RESULT_OK
import android.app.DatePickerDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.ViewGroupBindingAdapter.setListener
import com.example.youin.databinding.FragmentCreateNewPostBinding
import kotlinx.android.synthetic.main.fragment_create_new_post.*
import java.io.*
import java.util.*
import java.util.jar.Manifest



/**
 * A simple [Fragment] subclass.
 */
class CreateNewPost : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {


        val binding = DataBindingUtil.inflate<FragmentCreateNewPostBinding>(inflater,
            R.layout.fragment_create_new_post,container,false)


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)



        binding.uploadImage.setOnClickListener {
            pickImageFromGallery()
        }

        binding.eventDateButton.setOnClickListener {
            Toast.makeText(
                activity, "Rocking",
                Toast.LENGTH_SHORT
            ).show()

            val dpd = DatePickerDialog(
                activity!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    binding.eventDate.text = ("$dayOfMonth/$monthOfYear/$year")
                },
                year,
                month,
                day
            )
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

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT);
        intent.type = "image/*";
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            newPoster.setImageURI(data?.data)
    }

}
