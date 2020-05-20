package com.example.famous

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_person.*


class AddPersonActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_person)
        setUpUi()
    }
    private fun setUpUi() = save_btn.setOnClickListener{ returnPerson() }
    private fun returnPerson() {
        val name = name_et?.text.toString()
        //val name = name_et.text.toString()
        val born = born_et.text.toString()
        val died = death_et.text.toString()
        val description = description_et.text.toString()
        val image = image_et.text.toString()
        if (name.isNullOrBlank() || born.isNullOrBlank() || died.isNullOrBlank() || description.isNullOrBlank() || image.isNullOrBlank()) {
            Toast.makeText(applicationContext, "Fill all fields.", Toast.LENGTH_SHORT).show()
        }

        val newPerson = InspiringPerson(name,born,died,description,image)
        PeopleRepository.add(newPerson)
        val returnIntent = Intent()
        returnIntent.putExtra(PeopleActivity.KEY_EXTRA_PERSON, "person")
        this.setResult(Activity.RESULT_OK, returnIntent)
        this.finish()
    }
}