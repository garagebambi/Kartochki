package com.cyberlink.kartochkiebanie

import android.bluetooth.le.AdvertiseSettings
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_game_zone.*
import kotlinx.android.synthetic.main.activity_setings.*

class Setings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setings)
        if (Backgraunds.bg == 0){

            settingsBg.setBackgroundResource(R.drawable.firstbg)
        }else{
            settingsBg.setBackgroundResource(R.drawable.secondbg)
        }



        btnClassic.setOnClickListener {
            Backgraunds.bg = 0
            settingsBg.setBackgroundResource(R.drawable.firstbg)
        }

        btnNight.setOnClickListener {
            Backgraunds.bg = 1
            settingsBg.setBackgroundResource(R.drawable.secondbg)
        }

        btnInfo.setOnClickListener {
            val intent = Intent(this@Setings , Info::class.java)
            startActivity(intent)
        }

    }
}