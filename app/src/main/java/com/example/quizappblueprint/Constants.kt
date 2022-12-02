package com.example.quizappblueprint

object Constants {
    fun getQuestions(): ArrayList<Question>{
        val questionsList  = ArrayList<Question>()
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.argentina,
            "Argentina", "Fuji",
            "Japan", "Austria",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            1, "What country does this flag belong to?",
            R.drawable.australia,
            "Argentina", "australia",
            "Brazil", "Austria",
            2
        )
        questionsList.add(que2)

        val que3 = Question(
            1, "What country does this flag belong to?",
            R.drawable.belgium,
            "Argentina", "Australia",
            "Armenia", "Belgium",
            4
        )
        questionsList.add(que3)

        val que4 = Question(
            1, "What country does this flag belong to?",
            R.drawable.brazil,
            "Fiji", "India",
            "Brazil", "Austria",
            3
        )
        questionsList.add(que4)

        val que5 = Question(
            1, "What country does this flag belong to?",
            R.drawable.denmark,
            "Denmark", "Kuwait",
            "Armenia", "Germany",
            1
        )
        questionsList.add(que5)

        val que6 = Question(
            1, "What country does this flag belong to?",
            R.drawable.fiji,
            "India", "Fiji",
            "Denmark", "Armenia",
            2
        )
        questionsList.add(que6)

        val que7 = Question(
            1, "What country does this flag belong to?",
            R.drawable.germany,
            "Argentina", "Germany",
            "Armenia", "Kuwait",
            2
        )
        questionsList.add(que7)

        val que8 = Question(
            1, "What country does this flag belong to?",
            R.drawable.india,
            "Argentina", "Australia",
            "India", "Austria",
            3
        )
        questionsList.add(que8)

        val que9 = Question(
            1, "What country does this flag belong to?",
            R.drawable.kuwait,
            "Fuji", "Belgium",
            "Germany", "kuwait",
            4
        )
        questionsList.add(que9)
        return questionsList
    }
}