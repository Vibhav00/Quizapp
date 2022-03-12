package com.example.quizapp

data class Question(
    val id:Int,
    val question:String,
    val image: Int,
    val optionone:String,
    val optiontwo:String,
    val optiontree:String,
    val optionfour:String,
    val corrAns:Int

)
