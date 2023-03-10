package com.example.worldfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isEmpty
import com.example.worldfactory.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            super.onBackPressed()
        }

        binding.buttonSignup.setOnClickListener {
            if (binding.textInputLayoutName.editText?.text.toString().isEmpty() || binding.textInputLayoutEmail.editText?.text.toString().isEmpty() || binding.textInputLayoutPassword.editText?.text.toString().isEmpty()){
              val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Login error!")
                dialogBuilder.setMessage("Some of your fields does not contain any text.")
                dialogBuilder.show()
            } else {
                val intent = Intent(this@LoginActivity, WordActivity::class.java)
                startActivity(intent)
            }
        }
    }
}