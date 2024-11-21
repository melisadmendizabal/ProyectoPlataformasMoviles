package com.uvg.freetofeel.data.source

import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.DailyRecoModel

class DailyRecoDB {
private val dailyRecos: List<DailyRecoModel> = listOf(
    DailyRecoModel(title = R.string.dailyreco_title_example, body = R.string.dialyreco_text_example, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title1, body = R.string.dailyreco_text1, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title2, body = R.string.dailyreco_text2, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title3, body = R.string.dailyreco_text3, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title4, body = R.string.dailyreco_text4, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title5, body = R.string.dailyreco_text5, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title6, body = R.string.dailyreco_text6, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title7, body = R.string.dailyreco_text7, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title8, body = R.string.dailyreco_text8, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title9, body = R.string.dailyreco_text9, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title10, body = R.string.dailyreco_text10, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title11, body = R.string.dailyreco_text11, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title12, body = R.string.dailyreco_text12, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title13, body = R.string.dailyreco_text13, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title14, body = R.string.dailyreco_text14, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title15, body = R.string.dailyreco_text15, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title16, body = R.string.dailyreco_text16, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title17, body = R.string.dailyreco_text17, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title18, body = R.string.dailyreco_text18, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title19, body = R.string.dailyreco_text19, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title20, body = R.string.dailyreco_text20, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title21, body = R.string.dailyreco_text21, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title22, body = R.string.dailyreco_text22, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title23, body = R.string.dailyreco_text23, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title24, body = R.string.dailyreco_text24, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title25, body = R.string.dailyreco_text25, completed = "ok", points = 10 ),



    )

    fun getAllDailyRecos(): List<DailyRecoModel>{
        return dailyRecos
    }




}