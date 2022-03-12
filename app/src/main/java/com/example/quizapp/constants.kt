package com.example.quizapp

object constants {


    fun getQuestions():ArrayList<Question>
    {
        val questionList=ArrayList<Question>()

        val ques1= Question(
            1,"which country does it bolong to ",
            R.drawable.ic_flag_of_india,"argentina","austrelia","india","austria"
        ,3
        )


        // 2

        val ques2= Question(
            2,"which country does it bolong to ",
            R.drawable.ic_flag_of_argentina,"argentina","austrelia","india","austria"
            ,1
        )
      //3

        val ques3= Question(
            3,"which country does it bolong to ",
            R.drawable.ic_flag_of_australia,"argentina","austrelia","india","austria"
            ,2
        )
     //4
        val ques4= Question(
            4,"which country does it bolong to  ",
            R.drawable.ic_flag_of_belgium,"argentina","austrelia","india","belegium"
            ,4
        )




        questionList.add(ques1)
        questionList.add(ques2)
        questionList.add(ques3)
        questionList.add(ques4)
        return questionList

    }




}


