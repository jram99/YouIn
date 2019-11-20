package com.example.youin



import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.databinding.DataBindingUtil
import com.example.youin.databinding.FragmentCreateNewPostBinding
import java.text.SimpleDateFormat
import java.util.*



/**
 * A simple [Fragment] subclass.
 */
class CreateNewPost : Fragment() {

    var cal = Calendar.getInstance()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentCreateNewPostBinding>(inflater,
            R.layout.fragment_create_new_post,container,false)

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { p0, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "MM/dd/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                binding.eventDate.text = sdf.format(cal.getTime())
            }

        binding.eventDateButton.setOnClickListener {
            DatePickerDialog(context!!, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_new_post, container, false)
    }

}
