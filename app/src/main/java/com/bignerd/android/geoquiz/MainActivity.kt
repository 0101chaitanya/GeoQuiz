package com.bignerd.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.bignerd.android.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var trueButton:Button
    private lateinit var falseButton:Button
    private var once = false
    private var counter = 0
    private var loopVar = 0
    private lateinit var binding: ActivityMainBinding
    private var questionBank = listOf(
        Question(R.string.question_australia,true),
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa,false),
        Question(R.string.question_americas,true),
        Question(R.string.question_asia,true),
    )

    private var currentIndex = questionBank.size -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        //trueButton = findViewById(R.id.true_button)
        //falseButton = findViewById(R.id.false_button)
//        trueButton.setOnClickListener {
//            /*Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT)
//            .show()*/
//        Snackbar.make(it,R.string.correct_toast,Snackbar.LENGTH_LONG).show()
//        }
//        falseButton.setOnClickListener {
//        Snackbar.make(it,R.string.incorrect_toast,Snackbar.LENGTH_LONG).show()
//            /*Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show()*/
//        }
        binding.trueButton.setOnClickListener {
        checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
        checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
               updateQuestion(false)
        }
    binding.previousButton.setOnClickListener {

        updateQuestion(true)
    }
        updateQuestion(false)
    }
    private fun updateQuestion(reverse:Boolean) {
         if (reverse) {
             currentIndex =  if(currentIndex == 0) {
                 questionBank.size -1
             } else {
                 currentIndex -1
             }

             println("currentIndex: $currentIndex, questionBank: $questionBank")

        } else {
            currentIndex = if(currentIndex == questionBank.size-1) {
                0
            } else {
                (currentIndex+ 1)
            }

            println("currentIndex: $currentIndex, questionBank: $questionBank")

        }
        val questionTextResId: Int =    questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
        once = false
    }
    private fun checkAnswer(userAction:Boolean){
        loopVar++
        val correctAnswer = questionBank[currentIndex].answer
        val message =
            if( userAction == correctAnswer){
            counter++
                if(loopVar == 5){
                    val x = counter.toDouble()/loopVar
                    counter = 0
                    loopVar = 0
                    "${x*100} percent correct"
                }
                else resources.getString( R.string.correct_toast)

        } else {
                if(loopVar == 5){
                    val x = counter.toDouble()/loopVar
                    counter = 0
                    loopVar = 0
                    "${x*100} percent correct"

                }
            else resources.getString( R.string.incorrect_toast)
        }



        if(!once){
Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
      //  Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show()
        once = true
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() called")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume() called")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() called")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")

    }

}