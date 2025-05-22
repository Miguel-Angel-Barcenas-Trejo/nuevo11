package com.empresa.vclaminationsmantenimiento

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText

class reporte2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporte2) // Vincula el layout `activity_reporte` con esta actividad

        // Inicializar los elementos del diseño
        val etFecha = findViewById<EditText>(R.id.etFecha)
        val etReporte = findViewById<EditText>(R.id.etReporte)
        val etTurno = findViewById<EditText>(R.id.etTurno)
        val buttonText = intent.getStringExtra("buttonText") ?: "Sin título" // Obtener el texto del botón presionado
        val etMaquina = findViewById<EditText>(R.id.etMaquina) // Referencia al EditText

        etMaquina.setText(buttonText) // Establecer el nombre del botón como texto del EditText

        val etResponsable = findViewById<EditText>(R.id.etResponsable)
        val etTipoReporte = findViewById<EditText>(R.id.etTipoReporte)
        val etParoMaquina = findViewById<EditText>(R.id.etParoMaquina)
        val etTipoFalla = findViewById<EditText>(R.id.etTipoFalla)
        val etCausaRaiz = findViewById<EditText>(R.id.etCausaRaiz)
        val etActividad = findViewById<EditText>(R.id.etActividad)
        val etHoraReporte = findViewById<EditText>(R.id.etHoraReporte)
        val etHoraInicio = findViewById<EditText>(R.id.etHoraInicio)
        val etHoraFinal = findViewById<EditText>(R.id.etHoraFinal)
        val etTiempoTotal = findViewById<EditText>(R.id.etTiempoTotal)
        val etRequerimientos = findViewById<EditText>(R.id.etRequerimientos)
        val etObservaciones = findViewById<EditText>(R.id.etObservaciones)

        val btnEnviarCorreo = findViewById<Button>(R.id.btnDescargar)

        // Configurar la lógica para los botones
        btnEnviarCorreo.setOnClickListener {
            // Lógica para enviar el reporte por correo
        }
    }
}

