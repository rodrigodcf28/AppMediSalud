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

class Log : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log)

        val btnLogin = findViewById<AppCompatButton>(R.id.buttonLogin)
        val nameLogin = findViewById<AppCompatEditText>(R.id.username)
        val ppLogin = findViewById<AppCompatEditText>(R.id.password)
        val btnregistro = findViewById<AppCompatTextView>(R.id.signUpText)

       btnLogin.setOnClickListener {

           val name = nameLogin.text.toString()
           val password = ppLogin.text.toString()

           if(name.isEmpty()){

              nameLogin.error = "Ingresa un Nombre de Usuario Valido"

           }

           if (password.isEmpty()){

               ppLogin.error = "Ingresa una contrasena"

           }

           if (password.isNotEmpty() && name.isNotEmpty()){

               val intent = Intent(this, MainActivity::class.java)
               startActivity(intent)
               val text = "Inicio de Sesion Exitoso"
               val duration = Toast.LENGTH_SHORT
               val toast = Toast.makeText(this, text, duration)
               toast.show()

           }



        }

        btnregistro.setOnClickListener{

            val intent = Intent(this, Reg::class.java)
            startActivity(intent)

        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}