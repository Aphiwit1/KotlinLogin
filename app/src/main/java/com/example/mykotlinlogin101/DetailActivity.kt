package com.example.mykotlinlogin101

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var username = intent.getStringExtra("username")
        var password = intent.getStringExtra("password")

        Toast.makeText(
            applicationContext,
            "Username: $username and Passoword: $password",
            Toast.LENGTH_LONG
        ).show()

        openCamera()
    }


    fun openCamera() {
        takePhotoButton.setOnClickListener {
            var takePhoto = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePhoto, 100) //wating for the result
        }
    }

    //check something when got info
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100) {
            var presentData =
                data?.extras?.get("data") as Bitmap  // Bitmap is a data type to received from camera
            showImageView.setImageBitmap(presentData)
        }
    }
}
