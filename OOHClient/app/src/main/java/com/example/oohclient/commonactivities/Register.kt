package com.example.oohclient.commonactivities

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.oohclient.R
import com.example.oohclient.databinding.ActivityRegisterBinding
import com.example.oohclient.model.UserRegisterLoginModel

class Register : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var userRegisterLoginModel: UserRegisterLoginModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userRoleAdapter = ArrayAdapter.createFromResource(this,R.array.user_role,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        userRoleAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        binding.userRole.adapter = userRoleAdapter

        binding.register.setOnClickListener {
            registerUser()
        }

        binding.login.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }



    }

    private fun registerUser(){
        userRegisterLoginModel = UserRegisterLoginModel(
            userId = null,
            name = binding.name.text.toString(),
            email = binding.email.text.toString(),
            userRole = binding.userRole.selectedItem.toString(),
            password = binding.password.text.toString(),
            confirmPassword = binding.confirmPassword.text.toString()
        )

        Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show()
    }
}