package com.example.miumg.entidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.miumg.db.contract.DatosContract;
import com.example.miumg.db.contract.DbHelper;

public class cliente {
    private String nombre;
    private String apellido;
    private int edad;
    Context context;
    private SQLiteDatabase db;
    DbHelper mDbHelper;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public boolean Guardar(){
        try{
            mDbHelper = new DbHelper(context);
            db = mDbHelper.getWritableDatabase();
            ContentValues valor = new ContentValues();
            valor.put(DatosContract.Clientes.COLUMN_NAME_NOMBRE, nombre);
            valor.put(DatosContract.Clientes.COLUMN_NAME_APELLIDO, apellido);
            valor.put(DatosContract.Clientes.COLUMN_NAME_EDAD, edad);
            db.insert(DatosContract.Clientes.TABLE_NAME,null,valor);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cursor BuscarNombre(){
        try{
            Cursor c;
            c = db.rawQuery("Select nombre, apellido, edad from cliente", null);
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Cursor Verinfo(Context con){
        try{
            mDbHelper = new DbHelper(con);
            db = mDbHelper.getWritableDatabase();
            Cursor c;
            c = db.rawQuery("Select nombre, apellido, edad from cliente", null);
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
