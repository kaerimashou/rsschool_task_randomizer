package com.courses.task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    val bundle:Bundle=Bundle()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val min = arguments?.getInt("minValue")
        val max = arguments?.getInt("maxValue")

        if (min != null && max!=null) {
            textResult.text= (min..max).random().toString()
        }
        button_second.setOnClickListener {
            bundle.putInt("prevResult",textResult.text.toString().toInt())
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment,bundle)
        }
    }
}