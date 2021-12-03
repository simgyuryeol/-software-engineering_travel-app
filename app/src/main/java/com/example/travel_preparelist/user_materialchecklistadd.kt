package com.example.travel_preparelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class user_materialchecklistadd : AppCompatActivity() {

    private val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myRef : DatabaseReference = database.getReference("message")


    private val data = ArrayList<DataVo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_materialchecklistadd)

        val price_button = findViewById<Button>(R.id.price_button)
        val meterialadd_button = findViewById<Button>(R.id.meterialadd_button)
        val material_content = findViewById<EditText>(R.id.material_content)


        var value=material_content.text
        price_button.setOnClickListener{
                val intent = Intent(this, user_pricechecklistadd::class.java)

                startActivity(intent)
            }

        meterialadd_button.setOnClickListener {
            val intent = Intent(this, user_checklist::class.java)

            myRef.push().child("prepare").setValue(value.toString())
            startActivity(intent)
        }

        }

    }
