package com.example.la_liga;

import android.provider.BaseColumns;

public class EstructuraBBDD_Equipos {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS "+ EstructuraBBDD_Equipos.EstructuraEquipo.TABLE_EQUIPO +
                    "(" + EstructuraBBDD_Equipos.EstructuraEquipo._ID + " integer PRIMARY KEY, "
                    + EstructuraBBDD_Equipos.EstructuraEquipo.COLUMN_NOMBRE + " text, "
                    + EstructuraBBDD_Equipos.EstructuraEquipo.COLUMN_CIUDAD + " text, "
                    + EstructuraBBDD_Equipos.EstructuraEquipo.COLUMN_FOTO + " text),"
                    + EstructuraBBDD_Equipos.EstructuraEquipo.COLUMN_PUNTOS + " integer);";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS  " + EstructuraBBDD.EstructuraLiga.TABLE_USUARIO;

    private EstructuraBBDD_Equipos() {}

    /* Clase interna que define la estructura de la tabla de operas */
    public static class EstructuraEquipo implements BaseColumns {
        public static final String TABLE_EQUIPO = "Equipos";
        public static final String COLUMN_NOMBRE = "Nombre";
        public static final String COLUMN_CIUDAD = "Ciudad";
        public static final String COLUMN_FOTO = "Foto";
        public static final Integer COLUMN_PUNTOS = Integer.valueOf("Puntos");
    }
}
