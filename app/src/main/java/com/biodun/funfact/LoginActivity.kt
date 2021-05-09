package com.biodun.funfact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signIn()

    }

    private fun signIn() {

        val email = findViewById<TextInputEditText>(R.id.email_edit_text)
        val password = findViewById<TextInputEditText>(R.id.password_edit_text)
        val signInButton = findViewById<MaterialButton>(R.id.next_button)

        signInButton.setOnClickListener(){
            if (email.text.toString().isNullOrEmpty() || password.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Email or Password is not provided", Toast.LENGTH_LONG).show()
            }else {
                if (email.text.toString() == "zuritask@gmail.com" && password.text.toString() == "zuri123"){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}

