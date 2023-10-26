package com.example.proyecto2.entidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyecto2.db.DatosContract;
import com.example.proyecto2.db.DbHelper;

import java.sql.Date;
import java.sql.Time;

public class citas {
    private String nombre;
    private String vehiculo;
    private String tipoServicio;
    private Time hora;
    private Date fecha;
    Context context;
    private SQLiteDatabase db;
    DbHelper mDbHelper;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
            valor.put(DatosContract.citas.COLUMN_NAME_NOMBRE, nombre);
            valor.put(DatosContract.citas.COLUMN_NAME_VEHICULO, vehiculo);
            valor.put(DatosContract.citas.COLUMN_NAME_TIPOSERVICIO, tipoServicio);
            valor.put(String.valueOf(DatosContract.citas.COLUMN_NAME_HORA), hora.getTime());
            valor.put(String.valueOf(DatosContract.citas.COLUMN_NAME_FECHA), fecha.getDate());

            try{

                Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM citas WHERE hora = ? AND fecha = ?", new String[]{hora.toString(), fecha.toString()});

                if(cursor.getInt(0) > 0){
                    return false;
                }

                db.insert(DatosContract.citas.TABLE_NAME, null, valor);
                db.close();
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        }

    public Cursor BuscarNombre(){
        try{
            Cursor c;
            c = db.rawQuery("Select nombre, vehiculo, tipoServicio, hora, fecha from citas", null);
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
            c = db.rawQuery("Select nombre, vehiculo, tipoServicio, hora, fecha from citas", null);
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean HoraFechaDisponible() {
        String horaIngresada = String.valueOf(getHora());
        String fechaIngresada = String.valueOf(getFecha());

        // Realiza una consulta en la base de datos para verificar si la hora y fecha ya están ocupadas
        String[] args = {horaIngresada, fechaIngresada};
        Cursor cursor = db.rawQuery("SELECT * FROM citas WHERE hora = ? AND fecha = ?", args);

        boolean horaFechaDisponible = cursor.getCount() == 0; // Si el cursor no devuelve resultados, la hora y fecha están disponibles

        cursor.close();

        return horaFechaDisponible;
    }
}
