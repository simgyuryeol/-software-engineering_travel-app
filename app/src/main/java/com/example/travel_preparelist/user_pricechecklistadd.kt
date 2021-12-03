package com.example.travel_preparelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class user_pricechecklistadd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_pricechecklistadd)

        val material_button = findViewById<Button>(R.id.material_button)
        val priceadd_button = findViewById<Button>(R.id.priceadd_button)

        material_button.setOnClickListener{
            val intent = Intent(this,user_materialchecklistadd::class.java)
            intent.putExtra("sex",intent.getStringExtra("sex").toString())
            intent.putExtra("season",intent.getStringExtra("object").toString())
            intent.putExtra("object",intent.getStringExtra("season").toString())
            startActivity(intent)
        }

        priceadd_button.setOnClickListener {
            val intent = Intent(this,user_checklist::class.java)
            intent.putExtra("sex",intent.getStringExtra("sex").toString())
            intent.putExtra("season",intent.getStringExtra("object").toString())
            intent.putExtra("object",intent.getStringExtra("season").toString())
            startActivity(intent)
        }

    }
}