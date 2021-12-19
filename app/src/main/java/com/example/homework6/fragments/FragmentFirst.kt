package com.example.homework6.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.homework6.R

class FragmentFirst : Fragment(R.layout.fragment_first) {

    private lateinit var Addnote : EditText
    private lateinit var Button : Button
    private lateinit var textView2 : TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        Addnote = view.findViewById(R.id.Addnote)
        val sharedPreferances = requireActivity()
            .getSharedPreferences("pref", Context.MODE_PRIVATE)

        val text = sharedPreferances.getString("note", "")
        textView2.text = text
        Button.setOnClickListener(){
            var note = Addnote.text.toString()
            var text = textView2.text.toString()
            var result = note + "\n" + text
            textView2.text = result
            sharedPreferances.edit().putString("note", result).apply()
        }
    }
    private fun init(){
        Addnote = requireView().findViewById(R.id.Addnote)
        Button = requireView().findViewById(R.id.Button)
        textView2 = requireView().findViewById(R.id.textView)
    }
}