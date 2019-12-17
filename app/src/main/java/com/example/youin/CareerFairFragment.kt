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
import com.example.youin.databinding.FragmentCareerFairBinding
import com.example.youin.databinding.FragmentSignUpBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class CareerFairFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentCareerFairBinding>(inflater,
            R.layout.fragment_career_fair,container,false)


        binding.testImage1.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_EDIT, CalendarContract.Events.CONTENT_URI).apply {
                val beginTime: Calendar = Calendar.getInstance().apply {
                    set(2019, 2, 19, 7, 30)
                }
                val endTime = Calendar.getInstance().apply {
                    set(2019, 2, 19, 10, 30)
                }
                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime)
                putExtra(CalendarContract.Events.TITLE, "Career Fair")
                putExtra(CalendarContract.Events.EVENT_LOCATION, "IM Room")
            }
            startActivity(intent)

            Toast.makeText(context,"Career Fair will be added to calendar",Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }


}
