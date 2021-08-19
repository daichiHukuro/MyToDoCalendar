package com.example.mytodocalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todo_main:Button= findViewById(R.id.main_todo)
        var cale_main:Button= findViewById(R.id.main_cale)

        todo_main.setOnClickListener { view->
            val intent:Intent=Intent(this,TodoMainPanel::class.java)
            startActivity(intent)
        }
        cale_main.setOnClickListener { view->
            val intent:Intent=Intent(this,CaleMainPanel::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}