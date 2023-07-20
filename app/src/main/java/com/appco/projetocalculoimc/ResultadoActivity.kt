package com.appco.projetocalculoimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appco.projetocalculoimc.databinding.ActivityMainBinding
import com.appco.projetocalculoimc.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            val imc = peso / (altura * altura)

            with(binding) {

                imageVoltar.setOnClickListener {
                    finish()
                }

                realizarOutroCalculo.setOnClickListener {
                    finish()
                }

                textPesoInformado.text = "Peso informado: $peso Kg"
                textAlturaInformada.text = "Altura informada: $altura m"
                textImc.text = "Seu IMC: $imc"

                textResultado.text = when {
                    imc < 18.5 -> "Você está Abaixo do peso"
                    imc in 18.5..24.9 -> "Você está com peso Normal"
                    imc in 25.0..29.9 -> "Você está em Sobrepeso"
                    imc in 30.0..39.9 -> "Você está em Obesidade"
                    else -> "O resultado não se enquadra em nenhuma categoria conhecida."
                }
            }

        }
    }
}