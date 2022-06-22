package com.cyberlink.kartochkiebanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_zone.*
import kotlinx.android.synthetic.main.activity_info.*

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        if (Backgraunds.bg == 0) {

            infoBg.setBackgroundResource(R.drawable.firstbg)
        } else {
            infoBg.setBackgroundResource(R.drawable.secondbg)
        }
        val cat = R.drawable.catimg
        val bizon = R.drawable.bizonimg
        val eagle = R.drawable.eagleimg
        val kon = R.drawable.konimg
        val animals = listOf(cat, bizon, eagle, kon)

        val catText = R.string.cat_text
        val bizonText = R.string.bizon_text
        val eagleText = R.string.eagle_text
        val konText = R.string.kon_text
        val animalstext = listOf(catText, bizonText, eagleText, konText)
        var counterText = 1
        var counterAnimals = 1
        btnNext.setOnClickListener {

            animal.setImageResource(animals[counterAnimals])
            counterAnimals++
            if (counterAnimals > 3){
                counterAnimals = 0
            }

            animalText.setText(animalstext[counterText])
            counterText++
            if (counterText > 3){
                counterText = 0
            }



        }

    }
}