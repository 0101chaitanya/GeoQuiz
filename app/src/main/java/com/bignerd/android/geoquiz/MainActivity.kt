package com.bignerd.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.bignerd.android.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    //    private var counter = 0
//    private var loopVar = 0
    private lateinit var binding: ActivityMainBinding
    private  val quizViewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG,"onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"Got a QuizViewModel: $quizViewModel")

        binding.trueButton.setOnClickListener {
        checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
        checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
             quizViewModel.moveToNext()
            updateQuestion()

        }
    binding.previousButton.setOnClickListener {
        quizViewModel.moveToPrev()
        updateQuestion()

    }
        updateQuestion()

    }
    private fun updateQuestion() {

    val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)

    }

    private fun checkAnswer(userAction:Boolean){
        val correctAnswer = quizViewModel.answerOfCurrentQuestion
        val message =
            if( userAction == correctAnswer){

                resources.getString( R.string.correct_toast)

        } else {

            resources.getString( R.string.incorrect_toast)
        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

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