package com.application.cameraapp

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var cam_id:Button
    lateinit var img_id:ImageView

    companion object{
        private const val pic_id=123
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cam_id=findViewById(R.id.camera_button)
        img_id=findViewById(R.id.click_image)

        cam_id.setOnClickListener{
            val camera_intent =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camera_intent,
                com.application.cameraapp.MainActivity.Companion.pic_id
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== pic_id){
            val photo=data!!.extras!!["data"] as Bitmap?
            img_id.setImageBitmap(photo)
        }
    }


}