package com.example.famous

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_person.view.*
import kotlin.random.Random


class PersonAdapter(
    people: MutableList<InspiringPerson>,
    personListener: PersonInteractionListener
): RecyclerView.Adapter<PersonHolder>() {
    private val people: MutableList<InspiringPerson> = mutableListOf()
    private val personListener: PersonInteractionListener
    init {
        this.people.addAll(people)
        this.personListener = personListener
    }
    fun refreshData(people: MutableList<InspiringPerson>) {
        this.people.clear()
        this.people.addAll(people)
        this.notifyDataSetChanged()
    }
    override fun getItemCount(): Int = people.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val peopleView = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonHolder(peopleView)
    }
    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val person = people[position]
        holder.bind(person, personListener)
    }
}
class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(person: InspiringPerson, personListener: PersonInteractionListener) {
        itemView.name.text = person.name
        itemView.born.text = person.born
        itemView.passed.text = person.passed
        itemView.description.text = person.description
        Picasso.get()
            .load(person.image)
            .fit()
            .placeholder(R.drawable.ic_person)
            .error(android.R.drawable.stat_notify_error)
            .into(itemView.img)

        itemView.setOnClickListener {
            val quotes = person.quotes
            val index = Random.nextInt(quotes.size)
            personListener.onShowDetails(quotes, index) }
        }

}