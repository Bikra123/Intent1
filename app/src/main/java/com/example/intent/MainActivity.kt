package com.example.intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result ->
        if (result.resultCode == ResultActivity.result && result.data != null){
            val selectedValue =
                result.data?.getIntExtra(ResultActivity.selected_value,0)
            tvResult.text = "Hasil: $selectedValue"
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.btn)
        button.setOnClickListener(this)
        val buttonData : Button = findViewById(R.id.pindahData)
        buttonData.setOnClickListener(this)
        val buttonParcel : Button = findViewById(R.id.btn_parcel)
        buttonParcel.setOnClickListener(this)
        val buttonDial : Button = findViewById(R.id.dial_number)
        buttonDial.setOnClickListener(this)
        val buttonResult: Button = findViewById(R.id.btn_finalResult)
        buttonResult.setOnClickListener(this)

        tvResult = findViewById(R.id.result)
    }

    override fun onClick(v: View?){
        when (v?.id){
            R.id.btn -> {
                val move = Intent(this@MainActivity, MoreActivity::class.java)
                startActivity(move)
            }
            R.id.pindahData -> {
                val move = Intent(this@MainActivity,DataActivity::class.java)
                move.putExtra(DataActivity.extra_name,"Bikra")
                move.putExtra(DataActivity.extra_age,18)
                startActivity(move)
            }
            R.id.btn_parcel -> {
                val move = Intent(this@MainActivity,ParcelActivity::class.java)
                val person = Person("Bikra Abna",18,"bikrabn@gmail.com","Temanggung")
                move.putExtra(ParcelActivity.extra_person,person)
                startActivity(move)
            }
            R.id.dial_number -> {
                val phone ="01234567890"
                val move = Intent(Intent.ACTION_VIEW, Uri.parse("tel: $phone"))
                startActivity(move)
            }
            R.id.btn_finalResult -> {
                val move = Intent(this@MainActivity,ResultActivity::class.java)
                resultLauncher.launch(move)
            }
        }
    }
}