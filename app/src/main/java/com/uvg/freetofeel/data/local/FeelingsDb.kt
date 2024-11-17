package com.uvg.freetofeel.data.local

import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.Feeling

class FeelingsDb{
private val feelings: List<Feeling> = listOf(
    Feeling(title =R.string.sunTalk_example_title, body = R.string.sunTalk_example_text, emotion = " "),
    Feeling(title = R.string.sunTalk_sad1_title, body = R.string.sunTalk_sad1_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad2_title, body = R.string.sunTalk_sad2_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad3_title, body = R.string.sunTalk_sad3_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad4_title, body = R.string.sunTalk_sad4_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad5_title, body = R.string.sunTalk_sad5_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad6_title, body = R.string.sunTalk_sad6_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad7_title, body = R.string.sunTalk_sad7_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad8_title, body = R.string.sunTalk_sad8_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad9_title, body = R.string.sunTalk_sad9_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad10_title, body = R.string.sunTalk_sad10_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad11_title, body = R.string.sunTalk_sad11_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad12_title, body = R.string.sunTalk_sad12_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad13_title, body = R.string.sunTalk_sad13_body, emotion = "Sad"),
    Feeling(title = R.string.sunTalk_sad14_title, body = R.string.sunTalk_sad14_body, emotion = "Sad"),

    Feeling(title = R.string.sunTalk_angry1_title, body = R.string.sunTalk_angry1_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry2_title, body = R.string.sunTalk_angry2_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry3_title, body = R.string.sunTalk_angry3_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry4_title, body = R.string.sunTalk_angry4_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry5_title, body = R.string.sunTalk_angry5_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry6_title, body = R.string.sunTalk_angry6_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry7_title, body = R.string.sunTalk_angry7_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry8_title, body = R.string.sunTalk_angry8_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry9_title, body = R.string.sunTalk_angry9_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry10_title, body = R.string.sunTalk_angry10_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry11_title, body = R.string.sunTalk_angry11_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry12_title, body = R.string.sunTalk_angry12_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry13_title, body = R.string.sunTalk_angry13_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry14_title, body = R.string.sunTalk_angry14_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry15_title, body = R.string.sunTalk_angry15_body, emotion = "Angry"),
    Feeling(title = R.string.sunTalk_angry16_title, body = R.string.sunTalk_angry16_body, emotion = "Angry"),

    Feeling(title = R.string.sunTalk_bored1_title, body = R.string.sunTalk_bored1_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored2_title, body = R.string.sunTalk_bored2_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored3_title, body = R.string.sunTalk_bored3_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored4_title, body = R.string.sunTalk_bored4_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored5_title, body = R.string.sunTalk_bored5_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored6_title, body = R.string.sunTalk_bored6_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored7_title, body = R.string.sunTalk_bored7_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored8_title, body = R.string.sunTalk_bored8_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored9_title, body = R.string.sunTalk_bored9_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored10_title, body = R.string.sunTalk_bored10_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored11_title, body = R.string.sunTalk_bored11_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored12_title, body = R.string.sunTalk_bored12_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored13_title, body = R.string.sunTalk_bored13_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored14_title, body = R.string.sunTalk_bored14_body, emotion = "Bored"),
    Feeling(title = R.string.sunTalk_bored15_title, body = R.string.sunTalk_bored15_body, emotion = "Bored"),

    Feeling(title = R.string.sunTalk_restless1_title, body = R.string.sunTalk_restless1_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless2_title, body = R.string.sunTalk_restless2_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless3_title, body = R.string.sunTalk_restless3_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless4_title, body = R.string.sunTalk_restless4_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless5_title, body = R.string.sunTalk_restless5_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless6_title, body = R.string.sunTalk_restless6_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless7_title, body = R.string.sunTalk_restless7_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless8_title, body = R.string.sunTalk_restless8_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless9_title, body = R.string.sunTalk_restless9_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless10_title, body = R.string.sunTalk_restless10_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless11_title, body = R.string.sunTalk_restless11_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless12_title, body = R.string.sunTalk_restless12_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless13_title, body = R.string.sunTalk_restless13_body, emotion = "Restless"),
    Feeling(title = R.string.sunTalk_restless14_title, body = R.string.sunTalk_restless14_body, emotion = "Restless"),

    Feeling(title = R.string.sunTalk_happy1_title, body = R.string.sunTalk_happy1_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy2_title, body = R.string.sunTalk_happy2_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy3_title, body = R.string.sunTalk_happy3_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy4_title, body = R.string.sunTalk_happy4_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy5_title, body = R.string.sunTalk_happy5_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy6_title, body = R.string.sunTalk_happy6_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy7_title, body = R.string.sunTalk_happy7_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy8_title, body = R.string.sunTalk_happy8_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy9_title, body = R.string.sunTalk_happy9_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy10_title, body = R.string.sunTalk_happy10_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy11_title, body = R.string.sunTalk_happy11_body, emotion = "Happy"),
    Feeling(title = R.string.sunTalk_happy12_title, body = R.string.sunTalk_happy12_body, emotion = "Happy"),

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