package com.example.youin



import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.youin.databinding.FragmentCreateNewPostBinding
import kotlinx.android.synthetic.main.fragment_create_new_post.*
import java.util.*



/**
 * A simple [Fragment] subclass.
 */
class CreateNewPost : Fragment() {

    private lateinit var  binding: FragmentCreateNewPostBinding
    private lateinit var viewModel: CreateNewPostViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {


        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_create_new_post,container,false)


        viewModel = ViewModelProviders.of(this).get(CreateNewPostViewModel::class.java)


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val locations = resources.getStringArray(R.array.Locations)

        var spinner = binding.eventLocation
        if (spinner != null) {
            val adapter = ArrayAdapter(activity!!, android.R.layout.simple_spinner_item, locations)
            spinner.adapter = adapter


        }

        binding.eventTimeButton.setOnTimeChangedListener { _, hour, minute -> var hour = hour
            var am_pm = ""

            when {hour == 0 -> { hour += 12
                am_pm = "AM"
            }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> { hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }
            if (binding.eventTime != null) {
                val hour = if (hour < 10) "0" + hour else hour
                val min = if (minute < 10) "0" + minute else minute

                var msg = "$hour : $min $am_pm"
                viewModel.eventTime = msg
                binding.eventTime.text = msg
                binding.eventTime.visibility = ViewGroup.VISIBLE
            }

        }

        binding.uploadImage.setOnClickListener {
            pickImageFromGallery()
        }

        binding.eventDateButton.setOnClickListener {

            val dpd = DatePickerDialog(
                activity!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    binding.eventDate.text= "$dayOfMonth/$monthOfYear/$year"
                    viewModel.eventDate = binding.eventDate.text.toString()
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
            viewModel.newPoster = data?.data.toString()
    }

    override fun onResume() {
        super.onResume()
        binding.eventDate.text = viewModel.eventDate
        binding.eventTime.text = viewModel.eventTime
        binding.newPoster.setImageURI(viewModel.newPoster.toUri())



    }

}
