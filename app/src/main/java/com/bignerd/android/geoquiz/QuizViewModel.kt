package com.bignerd.android.geoquiz

import androidx.lifecycle.ViewModel

private const val  TAG = "QuizViewModel"
class QuizViewModel:ViewModel() {

     private var questionBank = listOf(
        Question(R.string.question_australia,true),
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa,false),
        Question(R.string.question_americas,true),
        Question(R.string.question_asia,true),
    )
     private var currentIndex = 0//questionBank.size -1

    val answerOfCurrentQuestion:Boolean
    get()= questionBank[currentIndex].answer
    val currentQuestionText:Int
    get()=questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex = (currentIndex+1) % questionBank.size
    }
    fun moveToPrev(){
        currentIndex = if ( currentIndex == 0 ) questionBank.size -1 else
            currentIndex -1
    }


}