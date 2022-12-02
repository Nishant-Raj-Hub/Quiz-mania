package com.example.quizappblueprint

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var currentPosition = 1
    private var mCorrectAnswers = 0
    var questionsList = Constants.getQuestions()
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        loadQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    public fun loadQuestion( ) {
        val question = questionsList[currentPosition - 1]

        defaultOptionsView()
        if(currentPosition == questionsList.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour

        progressBar.progress = currentPosition
        tv_progress.text = "$currentPosition / ${questionsList.size}"
    }

    public fun defaultOptionsView(){                        //PROBLEM MIGHT OCCUR
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one->{
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two->{
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three->{
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four->{
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0){
                    currentPosition++

                    when {
                        currentPosition <= questionsList.size -> {
                            loadQuestion()
                        }
                        else -> {
                            Toast.makeText(
                                this,
                                "You've successufully completed the quiz",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }else{
                    val question = questionsList?.get(currentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(currentPosition == questionsList.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
                if(currentPosition>=questionsList.size){
                    val userName = intent.getStringExtra("userName")
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("correctAnswers", mCorrectAnswers)
                    intent.putExtra("userName", userName)                  //name from main activity to quez activity to result activity
                    intent.putExtra("totalQuestions", questionsList.size)
                    startActivity(intent)
                    finish()
                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1->{
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

}