package com.example.oohclient.commonactivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.oohclient.R
import com.example.oohclient.databinding.ActivityRegisterBinding
import com.example.oohclient.model.UserRegisterLoginModel
import org.json.JSONException
import java.lang.reflect.Method
import org.json.JSONObject

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

        if(userRegisterLoginModel.password!=userRegisterLoginModel.confirmPassword){
            Toast.makeText(this,"Both passwords are different. Try again", Toast.LENGTH_LONG).show()
        }
        else{
            val queue = Volley.newRequestQueue(this@Register)

            val request: StringRequest =
                object : StringRequest(
                    Method.POST, "https://odoo-combate.onrender.com/auth/signup",
                    Response.Listener { response ->
                        try {
                            val jsonObject = JSONObject(response!!)

                            val status = jsonObject.get("status").toString()
                            val message = jsonObject.get("message").toString()
                            if(status=="201"){
                                startActivity(Intent(this@Register, Login::class.java))
                                finish()
                            }
                            else{
                                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                            }
                        } catch (e: JSONException) {
                            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show()
                        }
                    }, Response.ErrorListener { error ->
                        Toast.makeText(this, error.message.toString(), Toast.LENGTH_SHORT).show()
                    }) {
                    override fun getParams(): Map<String, String> {

                        val params: MutableMap<String, String> = HashMap()

                        params["email"] = userRegisterLoginModel.email.toString()
                        params["name"] = userRegisterLoginModel.name.toString()
                        params["password"] = userRegisterLoginModel.password.toString()
                        params["role"] = userRegisterLoginModel.userRole.toString()

                        return params
                    }
                }
            queue.add(request)
        }




    }
}