package com.example.variascosas

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Surface
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rotacion = windowManager.defaultDisplay.rotation
        if (rotacion == Surface.ROTATION_0 || rotacion == Surface.ROTATION_180) {
            button.isEnabled = false
            editTextTextPersonName.afterTextChanged {

                button.isEnabled = editTextTextPersonName.text.isNotEmpty()

            }
        }
        else
            {
            //...hacer lo que quiera con la pantalla horizontal
        }

        }




    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }
}