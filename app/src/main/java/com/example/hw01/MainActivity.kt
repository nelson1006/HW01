package com.example.hw01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val bundle = Bundle()
        val entername = findViewById<EditText>(R.id.enterName).text
        val entergender = findViewById<EditText>(R.id.enterGender).text
        button.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            bundle.putString("key1",entername.toString())
            bundle.putString("key2",entergender.toString())
            intent.putExtras(bundle)
            startActivityForResult(intent, 1)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    //建立onActivityResult function接收從MainActivity2傳回的數值並顯示
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        //判斷Intent值不能為空，檢查資料是否有數值
        data?.extras?.let{
            if (requestCode == 1 && resultCode == RESULT_OK)//判斷requestCode==1與Activity Result正常
            {
                //顯示送回資料
                findViewById<TextView>(R.id.textViewResult).text=
                "Name: ${it.getString("key1")}\n\n"+"Gender: ${it.getString("key2")}\n\n"+"Size: ${it.getString("key3")}\n\n"+"Color: ${it.getString("key4")}\n\n"
            }
        }
    }
}