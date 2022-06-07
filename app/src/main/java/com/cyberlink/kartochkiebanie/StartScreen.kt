package com.cyberlink.kartochkiebanie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start_screen.*

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        play.setOnClickListener {
            val intent = Intent(this@StartScreen , GameZone::class.java)
            startActivity(intent)
        }
        info.setOnClickListener {
            val intent = Intent(this@StartScreen , Info::class.java)
            startActivity(intent)
        }

        exit.setOnClickListener {
            finish()
        }

    }
}