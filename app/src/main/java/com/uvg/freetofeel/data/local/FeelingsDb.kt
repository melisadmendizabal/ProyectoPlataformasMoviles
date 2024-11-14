package com.uvg.freetofeel.data.local

import androidx.compose.ui.res.stringResource
import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.Feeling

class FeelingsDb{
private val feelings: List<Feeling> = listOf(
    Feeling(title =R.string.sunTalk_example_title, body = R.string.sunTalk_example_text, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_sad1_title, body = R.string.sunTalk_sad1_body, emotion = "Sad")

)

    fun getAllFeelings(): List<Feeling>{
        return feelings
    }

    fun getAllFeelingsByEmotion(emotion:String): List<Feeling>{
        return feelings.filter { it.emotion == emotion }
    }

    fun getSingleRandomFeelingByEmotion(feelingList:List<Feeling>):Feeling{
        return feelingList.random()
    }
}