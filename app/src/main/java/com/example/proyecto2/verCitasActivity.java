package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyecto2.db.DatosContract;
import com.example.proyecto2.entidad.citas;

import java.util.ArrayList;
import java.util.List;

public class verCitasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_citas);

        Button volvermenu1 = findViewById(R.id.botonVolver);

        // Configura un Listener de clic para el botón
        volvermenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(verCitasActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        citas cita = new citas();
        cita.setContext(this); // Asegúrate de que el contexto sea el contexto de tu actividad

        ListView listView = findViewById(R.id.tlistaCitas);

        // Obtén los datos de las citas
        try {
            Cursor cursor = cita.Verinfo(this);

            if (cursor != null) {
                List<String> citasList = new ArrayList<>();

                while (cursor.moveToNext()) {
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(DatosContract.citas.COLUMN_NAME_NOMBRE));
                    @SuppressLint("Range") String vehiculo = cursor.getString(cursor.getColumnIndex(DatosContract.citas.COLUMN_NAME_VEHICULO));
                    @SuppressLint("Range") String tipoServicio = cursor.getString(cursor.getColumnIndex(DatosContract.citas.COLUMN_NAME_TIPOSERVICIO));
                    @SuppressLint("Range") String hora = cursor.getString(cursor.getColumnIndex(String.valueOf(DatosContract.citas.COLUMN_NAME_HORA)));
                    @SuppressLint("Range") String fecha = cursor.getString(cursor.getColumnIndex(String.valueOf(DatosContract.citas.COLUMN_NAME_FECHA)));

                    String citaDetails = "Nombre: " + nombre + "\nVehículo: " + vehiculo + "\nServicio: " + tipoServicio + "\nHora: " + hora + "\nFecha: " + fecha;
                    citasList.add(citaDetails);
                }

                // Crea un adaptador personalizado para mostrar los detalles de las citas
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, citasList);

                // Asigna el adaptador al ListView
                listView.setAdapter(adapter);
            }

            cursor.close();
        } catch (Exception e) {
            // Maneja la excepción de acuerdo a tus necesidades
            e.printStackTrace();
            Toast.makeText(this, "Ocurrió un error al obtener las citas.", Toast.LENGTH_SHORT).show();
        }


    }
}