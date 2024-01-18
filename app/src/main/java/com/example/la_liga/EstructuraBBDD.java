package com.example.la_liga;

import android.provider.BaseColumns;

public class EstructuraBBDD {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS "+ EstructuraLiga.TABLE_USUARIO +
                    "(" + EstructuraLiga._ID + " integer PRIMARY KEY, "
                    + EstructuraLiga.COLUMN_NOMBRE + " text, "
                    + EstructuraLiga.COLUMN_GMAIL + " text, "
                    + EstructuraLiga.COLUMN_CONTRASENA + " text);";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS  " + EstructuraLiga.TABLE_USUARIO;

    private EstructuraBBDD() {}

    /* Clase interna que define la estructura de la tabla de operas */
    public static class EstructuraLiga implements BaseColumns {
        public static final String TABLE_USUARIO = "Usuario";
        public static final String COLUMN_NOMBRE = "Nombre";
        public static final String COLUMN_GMAIL = "Gmail";
        public static final String COLUMN_CONTRASENA = "Contrasena";
    }
}
