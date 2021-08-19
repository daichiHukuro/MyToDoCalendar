package com.example.mytodocalendar

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CaleMainPanel:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cale_main)

        val home:FloatingActionButton=findViewById(R.id.cale_main_home)
        home.setOnClickListener { view->
            finish()
        }
    }
}