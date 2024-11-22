package com.uvg.freetofeel.data.source

import com.uvg.freetofeel.R
import com.uvg.freetofeel.data.model.Challenge

class ChallengeDB {
    private val challenges: List<Challenge> = listOf(
        Challenge(title = R.string.challenge_emocional_title1, category = R.string.challenge_emocional_type, body = R.string.challenge_emocional_description1, filter = "emocional", image = "https://hevalia.com/wp-content/uploads/2024/02/social-media-2314696_640.jpg"),
        Challenge(title = R.string.challenge_emocional_title2, category = R.string.challenge_emocional_type, body = R.string.challenge_emocional_description2, filter = "emocional", image = "https://i.pinimg.com/736x/c9/b3/d8/c9b3d8e65510de7fadefe132946fc690.jpg"),
        Challenge(title = R.string.challenge_emocional_title3, category = R.string.challenge_emocional_type, body = R.string.challenge_emocional_description3, filter = "emocional", image = "https://i.pinimg.com/736x/33/cb/36/33cb36b83f3cec7904ff1011fcbf6bcc.jpg"),
        Challenge(title = R.string.challenge_emocional_title4, category = R.string.challenge_emocional_type, body = R.string.challenge_emocional_description4, filter = "emocional", image = "https://i.pinimg.com/736x/1b/80/6f/1b806fe21a31516e67b080abac389cd6.jpg"),
        Challenge(title = R.string.challenge_emocional_title5, category = R.string.challenge_emocional_type, body = R.string.challenge_emocional_description5, filter = "emocional", image = "https://i.pinimg.com/736x/83/11/30/8311302aff74bca83a02ebb71e77d495.jpg"),

        Challenge(title = R.string.challenge_fisico_title1, category = R.string.challenge_fisico_type, body = R.string.challenge_fisico_description1, filter = "fisico", image = "https://media.istockphoto.com/id/1139929498/es/vector/mujer-feliz-haciendo-ejercicio-en-el-parque-ilustraci%C3%B3n-vectorial-en-estilo-plano.jpg?s=612x612&w=0&k=20&c=L6gcnnyiOPc0qcLNxV7Nk2LVH9t9HPtseEj4euFJ0YE="),
        Challenge(title = R.string.challenge_fisico_title2, category = R.string.challenge_fisico_type, body = R.string.challenge_fisico_description2, filter = "fisico", image = "https://www.uc.cl/site/assets/files/10504/fitness-man-_-woman.700x532.jpg"),
        Challenge(title = R.string.challenge_fisico_title3, category = R.string.challenge_fisico_type, body = R.string.challenge_fisico_description3, filter = "fisico", image = "https://i.pinimg.com/236x/20/0c/13/200c1309daaa064a90332dc391ddeb59.jpg"),
        Challenge(title = R.string.challenge_fisico_title4, category = R.string.challenge_fisico_type, body = R.string.challenge_fisico_description4, filter = "fisico", image = "https://i.pinimg.com/736x/e7/f9/2a/e7f92aea343b909a587e63e7b7e20e1d.jpg"),
        Challenge(title = R.string.challenge_fisico_title5, category = R.string.challenge_fisico_type, body = R.string.challenge_fisico_description5, filter = "fisico", image = "https://i.pinimg.com/736x/cc/86/4d/cc864d8f0bdbc00e33a9e51f08e104bd.jpg"),

        Challenge(title = R.string.challenge_mental_title1, category = R.string.challenge_mental_type, body = R.string.challenge_mental_description1, filter = "mental", image = "https://lavozdexela.com/wp-content/uploads/2022/01/Salud-mental.png"),
        Challenge(title = R.string.challenge_mental_title2, category = R.string.challenge_mental_type, body = R.string.challenge_mental_description2, filter = "mental", image = "https://www.ayto-villacanada.es/wp-content/uploads/2023/04/imagen-cartel-jornada-de-la-salud.jpg"),
        Challenge(title = R.string.challenge_mental_title3, category = R.string.challenge_mental_type, body = R.string.challenge_mental_description3, filter = "mental", image = "https://www.cooperativaciencia.cl/wp-content/uploads/2023/10/iStock-1479494606-720x569.jpg"),
        Challenge(title = R.string.challenge_mental_title4, category = R.string.challenge_mental_type, body = R.string.challenge_mental_description4, filter = "mental", image = "https://i.pinimg.com/736x/6d/7a/e8/6d7ae8db12b83af303a696485d5316c3.jpg"),
        Challenge(title = R.string.challenge_mental_title5, category = R.string.challenge_mental_type, body = R.string.challenge_mental_description5, filter = "mental", image = "https://i.pinimg.com/736x/0b/1b/06/0b1b06e2004c8ad765c254d88d4c9cd7.jpg"),

        Challenge(title = R.string.challenge_espiri_title1, category = R.string.challenge_espiri_type, body = R.string.challenge_espiri_description1, filter = "espiri", image = "https://gccabd.co.in/wp-content/uploads/2024/10/SRC-IMAGE.jpg"),
        Challenge(title = R.string.challenge_espiri_title2, category = R.string.challenge_espiri_type, body = R.string.challenge_espiri_description2, filter = "espiri", image = "https://hacertfg.com/wp-content/uploads/2023/11/TFG-TRabajo-Social.webp"),
        Challenge(title = R.string.challenge_espiri_title3, category = R.string.challenge_espiri_type, body = R.string.challenge_espiri_description3, filter = "espiri", image = "https://i.pinimg.com/736x/37/69/50/376950b7eac9598ce89002fad0f97372.jpg"),
        Challenge(title = R.string.challenge_espiri_title4, category = R.string.challenge_espiri_type, body = R.string.challenge_espiri_description4, filter = "espiri", image = "https://i.pinimg.com/736x/7a/f1/32/7af13244baf6d394cf7e2ca93ea4d877.jpg"),
        Challenge(title = R.string.challenge_espiri_title5, category = R.string.challenge_espiri_type, body = R.string.challenge_espiri_description5, filter = "espiri", image = "https://i.pinimg.com/736x/f4/ad/b3/f4adb37717cbac14cbc0b5fee210d310.jpg"),
    )

    fun getAllChallenges(): List<Challenge>{
        return challenges
    }
}