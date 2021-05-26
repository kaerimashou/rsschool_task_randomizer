package com.courses.task1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    var bundle:Bundle=Bundle()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prevResult=arguments?.getInt("prevResult")
        if(prevResult==null){
            textPreviousResult.text="Previous result: 0"
        }else{
            textPreviousResult.text= "Previous result: $prevResult"
        }
        button_generate.setOnClickListener{
            val min=editTextMin.text.toString()
            val max=editTextMax.text.toString()
            if(editTextMin.text.toString().trim().isNotEmpty() && editTextMax.text.toString().trim().isNotEmpty()){
                if(editTextMin.text.toString().toInt()>editTextMax.text.toString().toInt()){
                    Toast.makeText(context,"Min value must be less than max value!",Toast.LENGTH_LONG).show()
                }else{
                    bundle.putInt("minValue",editTextMin.text.toString().toInt())
                    bundle.putInt("maxValue",editTextMax.text.toString().toInt())
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
                }
            }else{
                Toast.makeText(context,"Fill all fields!",Toast.LENGTH_LONG).show()
            }

        }
    }
}