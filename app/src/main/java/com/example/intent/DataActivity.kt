package com.example.intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DataActivity : AppCompatActivity(){

    companion object{
        const val extra_age = "extra_age"
        const val extra_name = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val dataReceived: TextView =findViewById(R.id.data_received)

        val name = intent.getStringExtra(extra_name)
        val age = intent.getIntExtra(extra_age,0)

        val text = "Nama : $name Umur: $age"
        dataReceived.text = text
    }
}