package com.example.teladecadastro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
    private lateinit var textviw: TextView

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
        textviw = findViewById(R.id.textViewUserInput)
        editTextTitle = findViewById(R.id.editTextTitle)
        botaoC = findViewById(R.id.botaoC)
        botaoL = findViewById(R.id.botaoL)

        val titulos = mutableListOf<String>()

        botaoC.setOnClickListener{
            val userInput = editTextTitle.text.toString()//obter oq o user digitou

            when {
//                se nao tiver vazio
                userInput.isNotEmpty() -> {
                    //add no array
                    titulos.add(userInput)
                    //listar na textviw tudo que o usuario cadastrar
                    listarfilmes(titulos, textviw)

                }
             //se nao clicar sem cadastrar, aparece notificaçao
                else ->   Toast.makeText(this, "Por favor, insira um texto", Toast.LENGTH_SHORT).show()



            }//inicializar
            editTextTitle.text.clear()


            botaoL.setOnClickListener {

              titulos.clear()
                textviw.text = ""

            }
            }

    }
    }
private fun listarfilmes(titulos: MutableList<String>, textViw: TextView) {
    var titlos = titulos.joinToString(separator = "\n")
    textViw.text = titlos
}