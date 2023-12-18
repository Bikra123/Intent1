package com.example.intent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ParcelActivity : AppCompatActivity() {

    companion object{
        const val extra_person = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcel)

        val parcelReceived: TextView = findViewById(R.id.parcel_received)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(extra_person, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(extra_person)
        }

        if (person != null){
            val text = "Name: ${person.name.toString()} \n Email: ${person.email.toString()} \n Umur: ${person.age.toString()} \n Asal: ${person.city.toString()}"
            parcelReceived.text = text
        }
    }
}