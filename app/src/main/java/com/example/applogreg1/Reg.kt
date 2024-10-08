package com.example.applogreg1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Reg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reg2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSingup = findViewById<AppCompatButton>(R.id.buttonSignUp)
        val LogBtn = findViewById<AppCompatTextView>(R.id.loginText)
        val regName = findViewById<AppCompatEditText>(R.id.fullname)
        val regMail = findViewById<AppCompatEditText>(R.id.email)
        val regUser = findViewById<AppCompatEditText>(R.id.username)
        val regPassword = findViewById<AppCompatEditText>(R.id.password)

        btnSingup.setOnClickListener{

            val name = regName.text.toString()
            val password = regPassword.text.toString()
            val email = regMail.text.toString()
            val username = regUser.text.toString()

            if (name.isEmpty()){

                regName.error = "Ingresa tu nombre"

            }
            if (username.isEmpty()){

                regUser.error = "Ingresa un usuario Valido"

            }
            if (email.isEmpty()){

                regMail.error ="Ingresa un Correo existente"


            }
            if (password.isEmpty()){

                regPassword.error = "Ingrese una contrasena valida"

            }

            if (name.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty() && username.isNotEmpty()){

                val intent = Intent(this, Log::class.java)
                startActivity(intent)
                val text = "Registro Exitoso"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, text, duration)
                toast.show()
            }



        }

        LogBtn.setOnClickListener{

            val intent = Intent(this, Log::class.java)
            startActivity(intent)


        }




    }



}