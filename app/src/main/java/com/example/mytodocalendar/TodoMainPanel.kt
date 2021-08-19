package com.example.mytodocalendar

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoMainPanel :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_main)
        //FloatingActionButton
        val home:FloatingActionButton=findViewById(R.id.todo_main_home)
        home.setOnClickListener { view->
            finish()
        }
    }
}