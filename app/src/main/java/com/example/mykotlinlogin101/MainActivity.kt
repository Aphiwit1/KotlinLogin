package com.example.mykotlinlogin101

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickLogin(view: View) {
        val username = usernameTextView.text.toString()
        val password = passwordTextView.text.toString()

        if (username == "Aphiwit" && password == "123456") {
            var intenToDetail = Intent(this@MainActivity, DetailActivity::class.java)
            intenToDetail.putExtra("username", username)
            intenToDetail.putExtra("password", password)
            startActivity(intenToDetail)
        } else {
            Toast.makeText(applicationContext, "Username or Password is not correct", Toast.LENGTH_LONG).show()
        }

    }

    fun onClickRegister(view: View) {
        Toast.makeText(applicationContext, "Register  Clicked", Toast.LENGTH_LONG).show()
    }


}
