package com.example.apppuntosdecimas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //constantes
        //val tiempoEst = (horasEst/60) + minutosEst
        val tarifaBase = 2850
        val maxMinutos=25
        val minAdd=28
        var pagoTotal=0

        //componentes
        val txtInputHoras = findViewById<EditText>(R.id.txtInputHoras)
        val txtInputMinutos = findViewById<EditText>(R.id.txtInputMinutos)
        val btnCalcula = findViewById<Button>(R.id.btnCalcula)
        val outPago = findViewById<TextView>(R.id.txvOutPago)

        //boton calcula
        btnCalcula.setOnClickListener {
            //presenta horas minutos
            val txtHoras= txtInputHoras.text.toString()
            val txtMinutos= txtInputMinutos.text.toString()
            Toast.makeText(this, "Horas: $txtHoras, Minutos: $txtMinutos", Toast.LENGTH_SHORT).show()

            //PROCESO
            val hora=txtHoras.toIntOrNull() ?: 0
            val minuto= txtMinutos.toIntOrNull() ?: 0
            val tiempoMinutos= (hora*60) + minuto
            val txtTiempoMin = tiempoMinutos.toString()

            //REGLAS DEL NEGOCIO
            if (tiempoMinutos>0 && tiempoMinutos<=maxMinutos){
                pagoTotal= tarifaBase
            } else {
                pagoTotal= tarifaBase +(minAdd*(tiempoMinutos-maxMinutos))
            }
            val txtPagar= pagoTotal.toString()
            val mensaje="DEBE CANCELAR: $" + txtPagar

            //PRESENTA
                //tiempo
                    Toast.makeText(this,"tiempo total en minutos: $txtTiempoMin",Toast.LENGTH_LONG).show()
                //pago
                    Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
                    outPago.text=mensaje

        }
    }
}
