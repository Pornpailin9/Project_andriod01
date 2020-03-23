package com.example.fragment_listview

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_fragment_login.view.*

class fragment_login : Fragment() {


    private var password: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_fragment_login, container, false)
        val button :Button = view.findViewById(R.id.button_login)
        button.setOnClickListener {
            var username:EditText = view.findViewById(R.id.username)
            var password:EditText = view.findViewById(R.id.password)
            Toast.makeText(context,"Welcome to BlackPink Land",Toast.LENGTH_LONG).show()

            val listview = fragment_listview()
            val fm =fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer,listview,"listview")
            transaction.addToBackStack("listview")
            transaction.commit()
        }

        return view
    }



}

