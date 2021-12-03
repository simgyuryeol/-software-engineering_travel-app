package com.example.travel_preparelist

import android.content.Intent
import android.media.session.PlaybackState
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.widget.Button
import android.widget.CursorAdapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class user_checklist : AppCompatActivity() {


    private lateinit var databaseRef : DatabaseReference
    private val title_array = ArrayList<DataVo>()

    private val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myRef : DatabaseReference = database.getReference("message")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_checklist)

        val checklist = findViewById<RecyclerView>(R.id.checklist)
        val textView = findViewById<TextView>(R.id.textView)
        val add_button = findViewById<Button>(R.id.add_button)
        val delete_button = findViewById<Button>(R.id.delete_button)




        add_button.setOnClickListener {
            val intent = Intent(this,user_materialchecklistadd::class.java)
            //intent.putExtra("value",title_array)
            myRef.setValue(title_array)

            startActivity(intent)
        }



        databaseRef = FirebaseDatabase.getInstance().reference


        myRef.addValueEventListener(object:ValueEventListener{ //값이 바뀌면 계속 실행 addValueEventListener

            override fun onCancelled(error: DatabaseError) {

            }
            override fun onDataChange(snapshot: DataSnapshot) {

                for (data in snapshot.children){


                    title_array.add(DataVo(data.child("prepare").value.toString()))
                    checklist.adapter = RecyclerViewAdapter(title_array)

                }
            }
        })

        databaseRef.addListenerForSingleValueEvent(object:ValueEventListener{ //한번만 실행 addListenerForSingleValueEvent
            override fun onCancelled(error: DatabaseError) {

            }
            override fun onDataChange(snapshot: DataSnapshot) {

                for (data in snapshot.child("sex").child(intent.getStringExtra("sex").toString()).children){ //성별

                    title_array.add(DataVo(data.getValue().toString()))
                    checklist.adapter = RecyclerViewAdapter(title_array)
                }
                for (data in snapshot.child("object").child(intent.getStringExtra("object").toString()).children){ //여행목적


                    title_array.add(DataVo(data.getValue().toString()))
                    checklist.adapter = RecyclerViewAdapter(title_array)
                }
                for (data in snapshot.child("season").child(intent.getStringExtra("season").toString()).children){ //계절


                    title_array.add(DataVo(data.getValue().toString()))

                    checklist.adapter = RecyclerViewAdapter(title_array)
                }


            }
        })

        //val dataList = arrayListOf(
         //       DataVo()
        //)


        checklist.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false) //유저 리사이클럴뷰
        checklist.setHasFixedSize(true)
        checklist.adapter = RecyclerViewAdapter(title_array)

    }
}