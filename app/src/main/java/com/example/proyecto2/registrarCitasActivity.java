package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import com.example.proyecto2.db.DatosContract;
import com.example.proyecto2.entidad.citas;

public class registrarCitasActivity extends AppCompatActivity {

    TextView tnombre ;
    TextView tvehiculo ;
    TextView tservicio ;
    TextView thora;
    TextView tfecha;
    citas cli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_citas);

        Button volvermenu1 = findViewById(R.id.tregresar1);

        // Configura un Listener de clic para el botón
        volvermenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registrarCitasActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        tnombre = (TextView) findViewById(R.id.tnombre);
        tvehiculo = (TextView) findViewById(R.id.tvehiculo);
        tservicio = (TextView) findViewById(R.id.tservicio);
        thora = (TextView) findViewById(R.id.thora);
        tfecha = (TextView) findViewById(R.id.tfecha);

        cli = new citas();
        cli.setContext(this);
    }

    public void Guardar(View view){
        try {
            cli.setNombre(tnombre.getText().toString());
            cli.setVehiculo(tvehiculo.getText().toString());
            cli.setTipoServicio(tservicio.getText().toString());

            // Obteniendo la hora y fecha ingresadas por el usuario
            String horaIngresadaStr = thora.getText().toString();
            String fechaIngresadaStr = tfecha.getText().toString();

            // Realizando la conversión de String a tipos de datos TIME y DATE
            SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");

            Date horaIngresada = horaFormat.parse(horaIngresadaStr);
            Date fechaIngresada = fechaFormat.parse(fechaIngresadaStr);

            // Estableciendo la hora y fecha en el objeto 'cli'
            cli.setHora(Time.valueOf(String.valueOf(new Time(horaIngresada.getTime()))));
            cli.setFecha(java.sql.Date.valueOf(String.valueOf(new Date(fechaIngresada.getTime()))));

            if (cli.HoraFechaDisponible()) {
                // Verifica si la hora y fecha ya están reservadas
                SQLiteDatabase db = openOrCreateDatabase("citas.db", MODE_PRIVATE, null);
                String consulta = "SELECT * FROM citas WHERE fecha = ? AND hora = ?";
                Cursor cursor = db.rawQuery(consulta, new String[]{cli.getFecha().toString(), cli.getHora().toString()});

                if (cursor.getCount() == 0) {
                    // Si no están reservadas, entonces procede a insertarlas
                    cli.Guardar();
                    db.close();
                    Toast.makeText(this, "Datos Guardados correctamente", Toast.LENGTH_SHORT).show();
                    verInfo();
                } else {
                    // Si están reservadas, muestra un mensaje al usuario
                    cursor.close();
                    db.close();
                    Toast.makeText(this, "La hora seleccionada ya está ocupada en esta fecha.", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Si la hora seleccionada ya está ocupada, muestra un mensaje al usuario
                Toast.makeText(this, "La hora seleccionada ya está ocupada en esta fecha.", Toast.LENGTH_SHORT).show();
            }
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("Error", "Error al guardar la cita: " + e.getMessage());
        }
    }

    private void verInfo(){
        try {
            Cursor cursor = cli.Verinfo(this);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(DatosContract.citas.COLUMN_NAME_NOMBRE));
                    // ... obtén los demás campos de la base de datos de manera similar
                    Log.d("Cita", "Nombre: " + nombre);
                    // ... log de los demás campos
                }
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Error", "Error al mostrar información: " + e.getMessage());
        }
    }

}