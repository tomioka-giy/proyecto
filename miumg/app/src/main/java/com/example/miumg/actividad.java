package com.example.miumg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.miumg.entidad.cliente;

public class actividad extends AppCompatActivity {
    cliente cli;
    ArraySet<String> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);

        cli = new cliente();
        results = new ArraySet<>();
        verInfo();
    }

    private void verInfo(){
        Cursor c = cli.Verinfo(this);
        if (c != null ) {
            if  (c.moveToFirst()) {
                do {
                    String firstName = c.getString(c.getColumnIndex("nombre"));
                    int age = c.getInt(c.getColumnIndex("edad"));
                    results.add("" + firstName + ",edad: " + age);
                }while (c.moveToNext());
            }
        }
        c.close();


    }





}