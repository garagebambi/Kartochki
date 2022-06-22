package com.cyberlink.kartochkiebanie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.cyberlink.kartochkiebanie.Counters.check
import com.cyberlink.kartochkiebanie.Counters.count
import kotlinx.android.synthetic.main.activity_game_zone.*
import kotlinx.android.synthetic.main.activity_setings.*
import kotlinx.android.synthetic.main.activity_start_screen.*

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        if (Backgraunds.bg == 0){

            startBg.setBackgroundResource(R.drawable.firstbg)
        }else{
            startBg.setBackgroundResource(R.drawable.secondbg)
        }

        btnPlay.setOnClickListener {
            val intent = Intent(this@StartScreen , GameZone::class.java)
            startActivity(intent)
        }

        btnSettings.setOnClickListener {
            val intent = Intent(this@StartScreen , Setings::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finish()
        }

        btnMinus.setOnClickListener {
            check--
            count--
            counter.text = count.toString()
            if (count < 5){
                btnMinus.isEnabled = false
            }
            if (count < 12){
                btnPlus.isEnabled = true
            }

        }
        btnPlus.setOnClickListener {
            check++
            count++
            counter.text = count.toString()
            if (count > 11){
                btnPlus.isEnabled = false
            }

            if (count > 4){
                btnMinus.isEnabled = true
            }

        }


    }

    override fun onResume() {
        super.onResume()

        if (Backgraunds.bg == 0){

            startBg.setBackgroundResource(R.drawable.firstbg)
        }else{
            startBg.setBackgroundResource(R.drawable.secondbg)
        }

    }
}