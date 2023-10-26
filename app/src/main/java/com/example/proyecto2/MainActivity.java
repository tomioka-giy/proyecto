package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //PARA IR A LA PANTALLA DE REGISTRAR CITAS.
        Button botonIrAActividad2 = findViewById(R.id.btnAgendar);

        // Configura un Listener de clic para el botón
        botonIrAActividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, registrarCitasActivity.class);
                startActivity(intent);
            }
        });

        //PARA IR A LA PANTALLA DE VER CITAS
        Button btnIrAActividad2 = findViewById(R.id.btnCitas);
        btnIrAActividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,verCitasActivity.class);
                startActivity(intent);
            }
        });
    }
}