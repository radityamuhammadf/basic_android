package com.example.pembekalan_siakadstechoq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog


class RegisterActivity : AppCompatActivity() {
    private val dialogDisplayDuration=1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val register = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.submit_registration)
        register.setOnClickListener{
            registrationSuccessful()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registrationSuccessful(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Berhasil")
        builder.setMessage("Registrasi Telah Berhasil, Silakan Login Ulang")
        val dialog: AlertDialog=builder.create()
        dialog.show()
        Handler().postDelayed({dialog.dismiss()},dialogDisplayDuration)
    }
}