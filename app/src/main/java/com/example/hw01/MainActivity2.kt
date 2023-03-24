package com.example.hw01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intent?.extras?.let {
            //使用it.getInt來接收數值
            val textView1 = findViewById<TextView>(R.id.textViewResult1)
            val name = it.getString("key1")
            val gender = it.getString("key2")
            val button2 = findViewById<Button>(R.id.button2)
            val size = findViewById<EditText>(R.id.enterSize).text
            val color = findViewById<EditText>(R.id.enterColor).text
            //使用it.getInt it.getString接收資料

            //建立Bundle數值用setResult傳回MainActivity
            button2.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("key1", name)
                bundle.putString("key2", gender)
                bundle.putString("key3", size.toString())
                bundle.putString("key4", color.toString())
                val intent = Intent().putExtras(bundle)
                setResult(Activity.RESULT_OK, intent.putExtras(bundle))
                //Bundle數值用setResult傳回MainActivity
                finish()//結束週期
            }
        }
    }
}