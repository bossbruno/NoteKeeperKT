package com.example.notekeeperkt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notekeeperkt.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {


    private lateinit var binding: ActivityNoteListBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
binding = ActivityNoteListBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.fab.setOnClickListener { view ->
            val activityintent = Intent(this, MainActivity::class.java)
            startActivity(activityintent)

        }

        binding.listItems.layoutManager = LinearLayoutManager(this)
        binding.listItems.adapter = NoteRecycleAdapter(this,DataManager.notes)


    }

    override fun onResume() {
        super.onResume()
      binding.listItems.adapter?.notifyDataSetChanged()
    }



    }