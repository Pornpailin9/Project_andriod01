package com.example.fragment_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val fragment_first = fragment_login()
    val manager = supportFragmentManager;
    val transaction = manager.beginTransaction();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transaction.replace(R.id.contentContainer,fragment_first,"fragment_login")
        transaction.addToBackStack("fragment_login")
        transaction.commit()
    }
    override fun onBackPressed() {

        val manager = supportFragmentManager.findFragmentById(R.id.contentContainer)

        if (manager is fragment_login ) {
            finish()
        }
        else{
            super.onBackPressed();
        }

    }

}
