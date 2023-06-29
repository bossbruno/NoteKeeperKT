package com.example.notekeeperkt

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.example.notekeeperkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var notePosition = positionnotset
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterCourses = ArrayAdapter<TopicInfo>(this,android.R.layout.simple_spinner_dropdown_item,
            DataManager.headings.values.toList())
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


     val spinner=   findViewById<Spinner>(R.id.spinnerCourses)
        spinner.adapter = adapterCourses


        notePosition = savedInstanceState?.getInt(NOTE_POSITION, positionnotset)?:
            intent.getIntExtra(NOTE_POSITION, positionnotset)
      if (notePosition != positionnotset)
            displaynote()
else
      {
try{
    DataManager.notes.add(NoteInfo())
    notePosition = DataManager.notes.lastIndex
}
catch (e:Exception){
    Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
} }


        val savebtn = findViewById<Button>(R.id.button_save)
        savebtn.setOnClickListener {
            saveNote()
            val activityintent = Intent(this, NoteListActivity::class.java)
            startActivity(activityintent)
        Toast.makeText(this,"Note Saved", Toast.LENGTH_SHORT).show()
        }

        binding.buttonDelete.setOnClickListener {
deletNote()
            val activityintent = Intent(this, NoteListActivity::class.java)
            startActivity(activityintent)
           Toast.makeText(this,"Note Deleted", Toast.LENGTH_SHORT).show()

        }
    }




    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NOTE_POSITION, notePosition)
    }

    private fun displaynote() {
        val note = DataManager.notes[notePosition]
        binding.textNoteTitle.setText(note.title)
        binding.textNoteText.setText(note.text)

        val courseposition = DataManager.headings.values.indexOf(note.course)
        binding.spinnerCourses.setSelection(courseposition)

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)

        return true
    }


    private fun saveNote() {
        try{

            val note = DataManager.notes[notePosition]
            note.title=    binding.textNoteTitle.text.toString()
            note.text = binding.textNoteText.text.toString()
            note.course = binding.spinnerCourses.selectedItem as TopicInfo}
        catch (e:Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }







   private fun deletNote(){



       try {
           val notes = notePosition
           DataManager.notes.removeAt(notes)
       }
       catch (e:Exception){
           Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
       }

   }


}