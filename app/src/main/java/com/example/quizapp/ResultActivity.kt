package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var tv_name:TextView=findViewById(R.id.name)
        var score:TextView=findViewById(R.id.score)
        var pname=intent.getStringExtra("name")
        var scorre=intent.getIntExtra("total",0)
        var totalqnno=intent.getIntExtra("totalqn",0)
        val btnlast:Button=findViewById(R.id.btn_last)
        tv_name.text=pname
        score.text="you got $scorre/ $totalqnno"

        val intent= Intent(this,MainActivity::class.java)
        btnlast.setOnClickListener{
            startActivity(intent)
            finish()
        }








    }
}