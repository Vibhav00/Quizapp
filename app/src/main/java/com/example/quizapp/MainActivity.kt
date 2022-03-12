package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart:Button=findViewById(R.id.btn_start)
        val tvinput:EditText=findViewById(R.id.tvinput)

        btnStart.setOnClickListener {
            if(tvinput.text.isNotEmpty())
            {

                val intent=Intent(this,QuizQuestionsactivity::class.java)
                intent.putExtra("name",tvinput.text.toString())
                startActivity(intent)

                finish()
            }
            else
            {
                Toast.makeText(this, "not entered anything", Toast.LENGTH_SHORT).show()
            }
        }
    }
}