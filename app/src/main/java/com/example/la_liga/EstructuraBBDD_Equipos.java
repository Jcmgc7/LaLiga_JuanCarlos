package com.example.la_liga;

import android.provider.BaseColumns;

public class EstructuraBBDD_Equipos {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS "+ EstructuraLiga.TABLE_EQUIPO +
                    "(" + EstructuraLiga._ID + " integer PRIMARY KEY, "
                    + EstructuraLiga.COLUMN_NOMBRE + " text, "
                    + EstructuraLiga.COLUMN_CIUDAD + " text, "
                    + EstructuraLiga.COLUMN_FOTO + " text, "
                    + EstructuraLiga.COLUMN_PUNTOS + " integer);";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS  " + EstructuraLiga.TABLE_EQUIPO;

    private EstructuraBBDD_Equipos() {}

    public static class EstructuraLiga implements BaseColumns {
        public static final String TABLE_EQUIPO = "Equipos";
        public static final String COLUMN_NOMBRE = "Nombre";
        public static final String COLUMN_CIUDAD = "Ciudad";
        public static final String COLUMN_FOTO = "Foto";
        public static final Integer COLUMN_PUNTOS = Integer.valueOf("Puntos");
    }
}
