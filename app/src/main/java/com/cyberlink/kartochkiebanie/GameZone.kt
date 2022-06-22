package com.cyberlink.kartochkiebanie

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.cyberlink.kartochkiebanie.Backgraunds.bg
import com.cyberlink.kartochkiebanie.Counters.check
import com.cyberlink.kartochkiebanie.Counters.count
import kotlinx.android.synthetic.main.activity_game_zone.*
import kotlinx.android.synthetic.main.activity_start_screen.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class GameZone : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_zone)

        counterGame.text = count.toString()

            if (bg == 0){

                gameZoneBg.setBackgroundResource(R.drawable.firstbg)
            }else{
                gameZoneBg.setBackgroundResource(R.drawable.secondbg)
            }

        var bizon = (R.drawable.bizonimg)
        var cat = (R.drawable.catimg)
        var eagle = (R.drawable.eagleimg)
        var kon = (R.drawable.konimg)
        var nowOpen = -1

        var aword = listOf(oneA, twoA, threeA, fourA, fiveA, sixA, sevenA, eightA)
        var img = mutableListOf(bizon, bizon, cat, cat, eagle, eagle, kon, kon)

        img.shuffle()


        for (i in img.indices) {

            aword[i].setOnClickListener {

                aword[i].setImageResource(img[i])

                if (nowOpen == -1) {
                    nowOpen = i
                    aword[nowOpen].isEnabled = false

                } else {
                    if (img[nowOpen] == img[i]) {
                        for (j in aword.indices) {
                            if (nowOpen != -1) {
                                aword[j].isEnabled = false
                            }
                        }
                        GlobalScope.launch(Dispatchers.Main) {
                            delay(1000)
                            aword[nowOpen].isInvisible = true
                            aword[nowOpen].isEnabled = true
                            aword[i].isInvisible = true
                            nowOpen = -1
                            aword.forEach {
                                it.isEnabled = true
                            }
                            var gameEnd = true
                            for (i in aword.indices){
                                if(aword[i].isVisible){
                                    gameEnd = false
                                    break
                                }
                            }
                            if(gameEnd == true){
                                winner.text = "You win!"
                                winner.isVisible = true
                            }
                        }


                    } else {
                        for (j in aword.indices) {
                            if (nowOpen != -1) {
                                aword[j].isEnabled = false
                            }
                        }
                        GlobalScope.launch(Dispatchers.Main) {
                            delay(1000)
                            aword[i].setImageResource(R.drawable.aimg)
                            aword[nowOpen].setImageResource(R.drawable.aimg)
                            aword[nowOpen].isEnabled = true
                            nowOpen = -1
                            aword.forEach {
                                it.isEnabled = true
                            }
                            count--
                            counterGame.text = count.toString()
                            if (count == 0){
                                winner.text = "You Lose"
                                winner.isVisible = true
                                aword.forEach {
                                    it.isVisible = false
                                }
                            }
                        }
                    }
                }



            }
        }

                        btnRestart.setOnClickListener {
                            for(i in aword.indices){
                                aword.forEach {
                                    it.setImageResource(R.drawable.aimg)
                                    it.isEnabled = true
                                    it.isVisible = true
                                }
                            }
                            nowOpen = -1
                            winner.isVisible = false
                            count = check
                            counterGame.text = check.toString()
                            img.shuffle()

                        }

    }
}


















