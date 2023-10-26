package com.example.proyecto2.db;

import android.provider.BaseColumns;

import java.sql.Date;
import java.sql.Time;

public class DatosContract {
    public static abstract class citas implements BaseColumns {
        public static final String TABLE_NAME = "citas";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_VEHICULO = "vehiculo";
        public static final String COLUMN_NAME_TIPOSERVICIO = "tipoServicio";
        public static final String COLUMN_NAME_HORA = "hora";
        public static final String COLUMN_NAME_FECHA = "fecha";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + citas.TABLE_NAME + " (" +
                    citas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    citas.COLUMN_NAME_NOMBRE + " TEXT, " +
                    citas.COLUMN_NAME_VEHICULO + " TEXT, " +
                    citas.COLUMN_NAME_TIPOSERVICIO + " TEXT, " +
                    citas.COLUMN_NAME_HORA + " TIME CHECK(hora >= '08:00' AND hora <= '18:00'), " +
                    citas.COLUMN_NAME_FECHA + " DATE, " +
                    "UNIQUE(" + citas.COLUMN_NAME_FECHA + ", " + citas.COLUMN_NAME_HORA + "))";

    public static final String SQL_DELETE_ETRIES =
            "DROP TABLE IF EXISTS " + citas.TABLE_NAME;
}
