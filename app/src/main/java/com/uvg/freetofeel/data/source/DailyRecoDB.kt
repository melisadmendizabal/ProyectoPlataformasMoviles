package com.uvg.freetofeel.data.source

import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.DailyRecoModel

class DailyRecoDB {
private val dailyRecos: List<DailyRecoModel> = listOf(
    DailyRecoModel(title = R.string.dailyreco_title_example, body = R.string.dialyreco_text_example, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title_example, body = R.string.dialyreco_text_example, completed = "ok", points = 10 ),
    DailyRecoModel(title = R.string.dailyreco_title_example, body = R.string.dialyreco_text_example, completed = "ok", points = 10 )

)

    fun getAllDailyRecos(): List<DailyRecoModel>{
        return dailyRecos
    }

//    fun getDailyRecoById(id: Int): DailyRecoModel {
//        return dailyRecos.first {it.id}
//    }


}