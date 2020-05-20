package com.example.famous

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.people_activity.*


class PeopleActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_PERSON: Int = 10
        const val KEY_EXTRA_PERSON: String = "person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.people_activity)
        setUpUi()
    }
    private fun setUpUi() {
        add_btn.setOnClickListener{ startAddPersonActivity()}
        peopleDisplay.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        peopleDisplay.itemAnimator = DefaultItemAnimator()
        peopleDisplay.addItemDecoration(DividerItemDecoration(this,RecyclerView.VERTICAL))
        displayData()
    }

    private fun startAddPersonActivity() {
        val intent = Intent(this, AddPersonActivity::class.java)
        startActivityForResult(intent, REQUEST_PERSON)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
                REQUEST_PERSON->{ (peopleDisplay.adapter as PersonAdapter).refreshData(PeopleRepository.people)}
            }

    }

    private fun displayData() {
        val personListener = object: PersonInteractionListener{
            override fun onShowDetails(quotes: MutableList<String>, index: Int) {
                val quote = quotes[index]
                Toast.makeText(applicationContext, quote, Toast.LENGTH_SHORT).show()
            }
        }
        peopleDisplay.adapter = PersonAdapter(PeopleRepository.people, personListener)
    }
}
