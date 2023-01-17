package com.example.dz63month.repository

import com.example.dz63month.data.TextModel

class TextRepository {
    private var textList = mutableListOf<TextModel>()

    fun getListOfText(): MutableList<TextModel>{
        textList.add(TextModel("Continue"))
        textList.add(TextModel("Switching Protocols"))
        textList.add(TextModel("loshari"))
        textList.add(TextModel("Ayana"))
        textList.add(TextModel("Salim"))
        textList.add(TextModel("Ibragim"))
        textList.add(TextModel("Lilia"))
        textList.add(TextModel("Jafar"))
        textList.add(TextModel("Bakai"))
        textList.add(TextModel("Argen"))
        textList.add(TextModel("Tanzilia"))
        textList.add(TextModel("Elina"))
        textList.add(TextModel("Kama"))
        textList.add(TextModel("njnjnj"))
        textList.add(TextModel("njnjnj1"))
        textList.add(TextModel("njnjnj2"))
        textList.add(TextModel("njnjnj3"))
        textList.add(TextModel("njnjnj4"))
        textList.add(TextModel("njnjnj5"))
        return textList
    }
}