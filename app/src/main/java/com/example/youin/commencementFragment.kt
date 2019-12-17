package com.example.youin


import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.youin.databinding.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class commencementFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentCommencementBinding>(inflater,
            R.layout.fragment_commencement,container,false)


        binding.commencementImage.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_EDIT, CalendarContract.Events.CONTENT_URI).apply {
                val beginTime: Calendar = Calendar.getInstance().apply {
                    set(2020, 5, 15, 7, 30)
                }
                val endTime = Calendar.getInstance().apply {
                    set(2020, 5, 15, 10, 30)
                }
                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime)
                putExtra(CalendarContract.Events.TITLE, "Grove City Commencement 2020")
                putExtra(CalendarContract.Events.EVENT_LOCATION, "Grove City College, Grove City, PA")
            }
            startActivity(intent)

            Toast.makeText(context,"GCC Commencement will be added to calendar",Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }


}
