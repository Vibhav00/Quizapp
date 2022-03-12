package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewOnReceiveContentListener
import com.example.quizapp.R

class QuizQuestionsactivity : AppCompatActivity(),View.OnClickListener{

    private var progressbar:ProgressBar?=null
    private var correctansno:Int=0
    private var tvprogress:TextView?=null
    private  var tvquestionn:TextView?=null
    private var imageview:ImageView?=null
    private var opn1:TextView?=null
    private var opn2:TextView?=null
    private var opn3:TextView?=null
    private var opn4:TextView?=null
    private var correcopn:TextView?=null
    private var btn_smbt:Button?=null
   private var questionList:ArrayList<Question>?=null
    private var currentposition = 1
    private var mselectedoption=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questionsactivity)

        progressbar=findViewById(R.id.progressbarr)
        tvprogress=findViewById(R.id.tv_progress)
        tvquestionn=findViewById(R.id.tv_ques)
        imageview=findViewById(R.id.iv_image)
        opn1=findViewById(R.id.tv_option_one)
        opn2=findViewById(R.id.tv_option_two)
        opn3=findViewById(R.id.tv_option_three)
        opn4=findViewById(R.id.tv_option_four)
        btn_smbt=findViewById(R.id.btn_smt)
        questionList=constants.getQuestions()
      opn1?.setOnClickListener(this)
        opn2?.setOnClickListener(this)
        opn3?.setOnClickListener(this)
        opn4?.setOnClickListener(this)
        btn_smbt?.setOnClickListener(this)
        setQuestion()


    }

    private fun setQuestion() {
        defaultOptionView()

        val question: Question = questionList!![currentposition - 1]
        imageview?.setImageResource(question.image)
        progressbar?.progress = currentposition
        tvquestionn?.text=question.question
        tvprogress?.text = "$currentposition/${questionList?.size}"
        opn1?.text = question.optionone
        opn2?.text = question.optiontwo
        opn3?.text = question.optiontree
        opn4?.text = question.optionfour


        if(currentposition==questionList!!.size){
            btn_smbt?.setText("FINISH")

        }else
        {
            btn_smbt?.setText("NEXT")
        }
    }


    private fun defaultOptionView()
    {
        val options= ArrayList<TextView>()
        opn1?.let { options.add(0,it) }
        opn2?.let { options.add(1,it) }
        opn3?.let { options.add(2,it) }
        opn4?.let { options.add(3,it) }
        for(i in options)
        {
            i.setTextColor(Color.parseColor("#FF0000"))
            i.typeface= Typeface.DEFAULT
           i.background=ContextCompat.getDrawable(this, R.drawable.backgrandkkkk)
           //
        }

    }


   private  fun selectedoptionView(tv:TextView,selectedoption:Int)
   {
    defaultOptionView()
       mselectedoption=selectedoption
       tv.setTextColor(Color.parseColor("#363A43"))
       tv.setTypeface(tv.typeface,Typeface.BOLD)
       tv.background=ContextCompat.getDrawable(this, R.drawable.selected_option_boarder_bg)
   }










    override fun onClick(v: View?) {
       when(v?.id)
       {
       R.id.tv_option_one->{
               opn1?.let{
                   selectedoptionView(it,1)
               }
           }




           R.id.tv_option_two->{
               opn2?.let{
                   selectedoptionView(it,2)
               }
           }


           R.id.tv_option_three->{
               opn3?.let{
                   selectedoptionView(it,3)
               }
           }

           R.id.tv_option_four->{
               opn4?.let{
                   selectedoptionView(it,4)
               }
           }
           R.id.btn_smt->{


               if(mselectedoption==0)
               {
                   currentposition++
                   if(currentposition<=questionList!!.size)
                   {
                       setQuestion();
                   }
                   else
                   {
                       var name=intent.getStringExtra("name")
                        val intent= Intent(this,ResultActivity::class.java)

                       intent.putExtra("name",name)
                       intent.putExtra("total",correctansno)
                       intent.putExtra("totalqn",questionList?.size)
                       startActivity(intent)
                       finish()

                   }



               }
               else
               {
                  val question=questionList!![currentposition-1]
                 if(question?.corrAns!=mselectedoption)
                 {
                     ansview(mselectedoption,R.drawable.wrong_option_boarder_bg)

                 }
                   else
                 {
                     correctansno++;
                 }
                   ansview(question.corrAns,R.drawable.correct_option_boarder_bg)
                   if(currentposition==questionList?.size)
                   {
                       btn_smbt?.text="finish"
                   }
                   else
                   {
                       btn_smbt?.text="go to next"
                   }

                   mselectedoption=0;



               }










           }

       }



    }



    fun ansview(answer:Int,drawbleview:Int)
    {
        when(answer)
        {
            1->{
                opn1?.background=ContextCompat.getDrawable(
                    this,drawbleview
                )
            }
            2->{
                opn2?.background=ContextCompat.getDrawable(
                    this,drawbleview
                )
            }
            3->{
                opn3?.background=ContextCompat.getDrawable(
                    this,drawbleview
                )
            }
            4->{
                opn4?.background=ContextCompat.getDrawable(
                    this,drawbleview
                )
            }





        }


    }










}