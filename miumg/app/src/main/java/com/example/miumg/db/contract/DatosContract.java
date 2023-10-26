package com.example.miumg.db.contract;

import android.provider.BaseColumns;

public class DatosContract {

    public static abstract class Clientes implements BaseColumns{
        public static  final String TABLE_NAME = "cliente";
        public static  final String COLUMN_NAME_NOMBRE = "nombre";
        public static  final String COLUMN_NAME_APELLIDO = "apellido";
        public static  final String COLUMN_NAME_EDAD = "edad";
    }

    public static  final String SQL_CREATE_ENTRIES =
            pr.CREATE_TABLE + Clientes.TABLE_NAME + " (" +
                    Clientes._ID + pr.INTEGER_TYPE + pr.PRIMARY_KEY + pr.AUTO_INCREMENT + pr.COMMA_SEP +
                    Clientes.COLUMN_NAME_NOMBRE + pr.TEXT_TYPE + pr.COMMA_SEP +
                    Clientes.COLUMN_NAME_APELLIDO + pr.TEXT_TYPE + pr.COMMA_SEP +
                    Clientes.COLUMN_NAME_EDAD + pr.INTEGER_TYPE + " )";

    public static final String SQL_DELETE_ETRIES =
            pr.DROP_TABLE + Clientes.TABLE_NAME;

}
