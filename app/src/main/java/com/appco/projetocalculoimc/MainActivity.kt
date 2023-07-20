package com.appco.projetocalculoimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appco.projetocalculoimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonCalcularImc.setOnClickListener {

                val peso = textInputPeso.text.toString()
                val altura = textInputAltura.text.toString()

                if (peso.isNotEmpty() && altura.isNotEmpty()) {
                    val intent = Intent(applicationContext, ResultadoActivity::class.java)
                    intent.putExtra("peso", peso.toDouble())
                    intent.putExtra("altura", altura.toDouble())
                    startActivity(intent)
                }else {
                    if (peso.isEmpty() && altura.isEmpty()) {
                        textInputPeso.error = "Informe o seu peso."
                        textInputAltura.error = "Informe a sua altura."
                    }else if (peso.isEmpty()) {
                        textInputPeso.error = "Informe o seu peso."
                    }else if (altura.isEmpty()) {
                        textInputAltura.error = "Informe a sua altura."
                    }
                }
            }
        }
    }
}