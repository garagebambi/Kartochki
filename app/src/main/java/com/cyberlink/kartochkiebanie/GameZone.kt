package com.cyberlink.kartochkiebanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_game_zone.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class GameZone : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_zone)

        var moneta = (R.drawable.moneta)
        var rubin = (R.drawable.rubin)
        var kkk = (R.drawable.kkk)
        var devyatka = (R.drawable.devyatka)
        var nowOpen = -1

        var aword = listOf(oneA, twoA, threeA, fourA, fiveA, sixA, sevenA, eightA)
        var img = mutableListOf(moneta, moneta, rubin, rubin, kkk, kkk, devyatka, devyatka)

        img.shuffle()


        for (i in img.indices) {

            aword[i].setOnClickListener {

                aword[i].setImageResource(img[i])

                if (nowOpen == -1) {
                    nowOpen = i
                    aword[nowOpen].isEnabled = false

                } else {
                    println("Now open $nowOpen")
                    if (img[nowOpen] == img[i]) {
                        for (j in aword.indices) {
                            if (nowOpen != -1) {
                                aword[j].isEnabled = false
                            }
                        }
                        println("Now open $nowOpen")
                        GlobalScope.launch(Dispatchers.Main) {
                            delay(1000)
                            println("Now open $nowOpen")
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
                                winner.isVisible = true
                            }
                        }


                    } else {
                        for (j in aword.indices) {
                            if (nowOpen != -1) {
                                aword[j].isEnabled = false
                            }
                        }
                        println("Now open $nowOpen")
                        GlobalScope.launch(Dispatchers.Main) {
                            delay(1000)
                            println("Now open $nowOpen")
                            aword[i].setImageResource(R.drawable.worda)
                            aword[nowOpen].setImageResource(R.drawable.worda)
                            aword[nowOpen].isEnabled = true
                            nowOpen = -1
                            aword.forEach {
                                it.isEnabled = true
                            }


                        }
                    }
                }



                }
            }

                        restart.setOnClickListener {
                            for(i in aword.indices){
                                aword.forEach {
                                    it.setImageResource(R.drawable.worda)
                                    it.isEnabled = true
                                    it.isVisible = true
                                }
                            }
                            nowOpen = -1
                            winner.isVisible = false
                        }

        }
    }


//Игровое поле















