package com.example.miumg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miumg.entidad.cliente;

public class MainActivity extends AppCompatActivity {
    TextView tnombre ;
    TextView tapellido ;
    TextView tedad ;
    cliente cli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tnombre = (TextView) findViewById(R.id.txtNombre);
        tapellido = (TextView) findViewById(R.id.txtApellido);
        tedad = (TextView) findViewById(R.id.txtEdad);

        cli = new cliente();
        cli.setContext(this);

    }

    public void Guardar(View view){
        cli.setNombre(tnombre.getText().toString());
        cli.setApellido(tapellido.getText().toString());
        cli.setEdad(Integer.valueOf(tedad.getText().toString()));
        if (cli.Guardar()) {
            Toast.makeText(this, "Datos Guardados correctamente ", Toast.LENGTH_SHORT).show();
            verInfo();
        }
        else{
            Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
        }
    }


    private void verInfo(){
        Cursor cursor = cli.BuscarNombre();
        while(cursor.moveToNext()){
            String nombre = cursor.getString(0);
            Toast.makeText(MainActivity.this, nombre, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idItemMenu = item.getItemId();
        if (idItemMenu == R.id.action_actividad){
            Intent ii = new Intent(this, actividad.class);
            startActivity(ii);
        }else if (idItemMenu == R.id.action_version){
            Toast.makeText(this,"Ver. 1.01 ", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}