package com.krashkrosh748199.implicitintents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val btnFirst=findViewById<Button>(R.id.btnTakePhoto)
        btnFirst.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type="image/jpeg"
                startActivityForResult(it,0)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode==Activity.RESULT_OK && requestCode==0){
            val uri = data?.data
            val ivFirst=findViewById<ImageView>(R.id.ivPhoto)
            ivFirst.setImageURI(uri)
        }

    }
}