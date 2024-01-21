package com.example.la_liga;

import android.provider.BaseColumns;

import java.util.Date;

public class EstructuraBBDD_Partidos {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS "+ EstructuraLiga.TABLE_PARTIDO +
                    "(" + EstructuraLiga._ID + " integer PRIMARY KEY, "
                    + EstructuraLiga.COLUMN_JORNADA + " Jornada, "
                    + EstructuraLiga.COLUMN_FECHA + " Fecha, "
                    + EstructuraLiga.COLUMN_EQUIPO1 + " Equipo1, "
                    + EstructuraLiga.COLUMN_EQUIPO2 + " Equipo2, "
                    + EstructuraLiga.COLUMN_PUNTUACION1 + " Puntos1, "
                    + EstructuraLiga.COLUMN_PUNTUACION2 + " Puntos2);";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS  " + EstructuraLiga.TABLE_PARTIDO;

    private EstructuraBBDD_Partidos() {}

    public static class EstructuraLiga implements BaseColumns {
        public static final String TABLE_PARTIDO = "Partido";
        public static final String COLUMN_JORNADA = "Jornada";
        public static final String COLUMN_FECHA = "Fecha";
        public static final String COLUMN_EQUIPO1 = "Equipo1";
        public static final String COLUMN_EQUIPO2 = "Equipo2";
        public static final Integer COLUMN_PUNTUACION1 = Integer.valueOf("Puntuacion_equipo1");
        public static final Integer COLUMN_PUNTUACION2 = Integer.valueOf("Puntuacion_equipo2");
    }
}
