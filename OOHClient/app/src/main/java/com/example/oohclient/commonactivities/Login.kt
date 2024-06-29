package com.example.oohclient.commonactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.oohclient.R
import com.example.oohclient.advertiseractivities.AdvertiserMainActivity
import com.example.oohclient.databinding.ActivityLoginBinding
import com.example.oohclient.model.UserRegisterLoginModel
import com.example.oohclient.spaceowneractivities.SpaceOwnerMainActivity
import org.json.JSONException
import org.json.JSONObject

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
            finish()
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

        val queue = Volley.newRequestQueue(this@Login)

        val request: StringRequest =
            object : StringRequest(
                Method.POST, "https://odoo-combate.onrender.com/auth/login",
                Response.Listener { response ->
                    try {
                        val jsonObject = JSONObject(response!!)

                        val status = jsonObject.get("status").toString()
                        val message = jsonObject.get("message").toString()

                        if(status=="200"){
                            val role = jsonObject.getJSONObject("payload").get("role")
                            val sharedPref = getSharedPreferences("Auth", MODE_PRIVATE)
                            val editor = sharedPref.edit()
                            editor.putBoolean("isLogged",true)
                            editor.putString("email",userRegisterLoginModel.email)
                            editor.apply()

                            if(role=="Advertiser"){
                                startActivity(Intent(this@Login,AdvertiserMainActivity ::class.java))
                                finish()
                            }
                            else{
                                startActivity(Intent(this@Login, SpaceOwnerMainActivity::class.java))
                                finish()
                            }
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
                    params["password"] = userRegisterLoginModel.password.toString()

                    return params
                }
            }
        queue.add(request)
    }
}