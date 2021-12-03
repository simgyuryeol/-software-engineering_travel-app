package com.example.travel_preparelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class user_information_checking : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_information_checking)

        val save_button = findViewById<Button>(R.id.save_button)

        val sex_radio_group = findViewById<RadioGroup>(R.id.sex_radio_group)
        val season_radio_group = findViewById<RadioGroup>(R.id. season_radio_group)
        val travel_radio_group = findViewById<RadioGroup>(R.id. travel_radio_group)

        var sex=""
        sex_radio_group.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {

                R.id.sex_button_man -> sex = "남"
                R.id.sex_button_woman -> sex = "여"
            }
        }

        var season=""
        season_radio_group.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {

                R.id.radio_button_spring -> season = "spring"
                R.id.radio_button_summer -> season = "summer"
                R.id.radio_button_fall -> season = "fall"
                R.id.radio_button_winter -> season = "winter"

            }
        }

        var travelobject=""
        travel_radio_group.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {

                R.id.object_radiobox_picnic -> travelobject = "picnic"
                R.id.object_radiobox_swimming -> travelobject = "swimming"
                R.id.object_radiobox_camping -> travelobject = "camping"
                R.id.object_radiobox_climbing -> travelobject = "climbing"

            }
        }



        save_button.setOnClickListener {
            val intent = Intent(this,user_checklist::class.java)

            intent.putExtra("sex",sex)
            intent.putExtra("season",season)
            intent.putExtra("object",travelobject)

            startActivity(intent)
        }
    }
}