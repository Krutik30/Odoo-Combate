package com.example.oohclient.commonactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.oohclient.R
import com.example.oohclient.advertiseractivities.AdvertiserMainActivity
import com.example.oohclient.databinding.ActivityLoginBinding
import com.example.oohclient.model.UserRegisterLoginModel

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userRegisterLoginModel: UserRegisterLoginModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            loginUser()
        }

        binding.register.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }

    }

    private fun loginUser(){
        userRegisterLoginModel = UserRegisterLoginModel(
            userId = null,
            name = null,
            email = binding.email.text.toString(),
            userRole = null,
            password = binding.password.text.toString(),
            confirmPassword = null
        )

        Toast.makeText(this, "User Login", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this, AdvertiserMainActivity::class.java))
    }
}