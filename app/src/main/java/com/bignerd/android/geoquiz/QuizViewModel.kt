package com.bignerd.android.geoquiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val  TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY =  "CURRENT_INDEX_KEY"
class QuizViewModel(private val savedInstanceHandle:
                    SavedStateHandle):ViewModel() {
    private var currentIndex:Int //questionBank.size -1
    get() = savedInstanceHandle[CURRENT_INDEX_KEY] ?: 0
    set(value) {
        savedInstanceHandle[CURRENT_INDEX_KEY] = value
    }
     private var questionBank = listOf(
        Question(R.string.question_australia,true),
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa,false),
        Question(R.string.question_americas,true),
        Question(R.string.question_asia,true),
    )

    val answerOfCurrentQuestion:Boolean
    get()= questionBank[currentIndex].answer
    val currentQuestionText:Int
    get()=questionBank[currentIndex].textResId
    fun moveToNext(){
  //  Log.d(TAG,"Updating question text",Exception())
       currentIndex = (currentIndex+1) % questionBank.size
    }
    fun moveToPrev(){
        currentIndex = if ( currentIndex == 0 ) questionBank.size -1 else
            currentIndex -1
    }


}