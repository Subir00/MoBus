package com.example.mobus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class BusRoutes : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_routes)

        val button = findViewById<Button>(R.id.btn_logOut)
        val textView = findViewById<TextView>(R.id.user_details)

        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!
        if(user==null)
        {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
        else{
            textView.setText(user.email)
        }

        button.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}