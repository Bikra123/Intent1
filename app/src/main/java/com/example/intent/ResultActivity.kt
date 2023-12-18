package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rdGr: RadioGroup
    private lateinit var btn: Button


    companion object{
        const val SELECTED_VALUE = "selected_value"
        const val RESULT = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        rdGr = findViewById(R.id.rd_group)
        btn = findViewById(R.id.btn_result)
        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_result){
            if(rdGr.checkedRadioButtonId > 0){
                var value = 0
                when(rdGr.checkedRadioButtonId){
                    R.id.rd_50 -> value = 50

                    R.id.rd_100 -> value = 100

                    R.id.rd_150 -> value = 150

                    R.id.rd_200 -> value = 200
                }

                val resultIntent = Intent()
                resultIntent.putExtra(SELECTED_VALUE,0)
                setResult(RESULT,resultIntent)
                finish()
            }
        }
    }
}