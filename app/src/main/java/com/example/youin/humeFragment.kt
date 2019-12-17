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
import com.example.youin.databinding.FragmentHomecomingBinding
import com.example.youin.databinding.FragmentHumeBinding
import com.example.youin.databinding.FragmentSignUpBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class humeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHumeBinding>(inflater,
            R.layout.fragment_hume,container,false)


        binding.humeImage.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_EDIT, CalendarContract.Events.CONTENT_URI).apply {
                val beginTime: Calendar = Calendar.getInstance().apply {
                    set(2019, 11, 6, 7, 30)
                }
                val endTime = Calendar.getInstance().apply {
                    set(2019, 11, 6, 10, 30)
                }
                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime)
                putExtra(CalendarContract.Events.TITLE, "A Chat with Brit Hume")
                putExtra(CalendarContract.Events.EVENT_LOCATION, "Grove City, PA")
            }
            startActivity(intent)

            Toast.makeText(context,"Brit Hume chat will be added to calendar",Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }


}
