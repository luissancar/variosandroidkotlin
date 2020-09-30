package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var anterior=0
    var hayAnterior=false
    var pulsadoSuma=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ce.setOnClickListener {
            cero()
        }
        mas.setOnClickListener {
            suma()
        }

        igual.setOnClickListener {
            cero()
        }
    }
    fun numero(v : View){
        if (resultado.text.toString().equals("0"))
            resultado.text=""

        if (pulsadoSuma){
            pulsadoSuma=false
            resultado.text=""
        }
        val numero=findViewById<Button>(v.id)
        resultado.text=resultado.text.toString()+numero.text.toString()

    }

    fun cero(){
        resultado.text=getString(R.string.error)
    }

    fun suma() {
        if (hayAnterior){
            anterior=resultado.text.toString().toInt()+anterior
            resultado.text=anterior.toString()
        }
        else{
            anterior=resultado.text.toString().toInt()
        }
        hayAnterior=true
        pulsadoSuma=true

    }
}