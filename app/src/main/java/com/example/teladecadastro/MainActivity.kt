package com.example.teladecadastro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ButtonBarLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editTextTitle: EditText;
    private lateinit var botaoC: Button
    private lateinit var botaoL:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        editTextTitle = findViewById(R.id.editTextTitle)
        botaoC = findViewById(R.id.botaoC)
        botaoL = findViewById(R.id.botaoL)

        botaoC.setOnClickListener{
            val userInput = editTextTitle.text.toString()//obter oq o user digitou

            when {
                userInput.isNotEmpty() ->  Toast.makeText(this, userInput, Toast.LENGTH_SHORT).show()
                else -> editTextTitle.error = "Por favor, insira um texto"

            }//inicializar


            botaoL.setOnClickListener {
                editTextTitle.text.clear()
            }
            }

    }
    }
