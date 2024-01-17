package com.example.la_liga;

import android.provider.BaseColumns;

import java.util.Date;

public class EstructuraBBDD_Partidos {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS "+ EstructuraBBDD_Partidos.EstructuraPartido.TABLE_PARTIDO +
                    "(" + EstructuraBBDD_Partidos.EstructuraPartido._ID + " integer PRIMARY KEY, "
                    + EstructuraBBDD_Partidos.EstructuraPartido.COLUMN_FECHA + " text, "
                    + EstructuraBBDD_Partidos.EstructuraPartido.COLUMN_EQUIPO1 + " gmail, "
                    + EstructuraBBDD_Partidos.EstructuraPartido.COLUMN_EQUIPO1 + " gmail, "
                    + EstructuraBBDD_Partidos.EstructuraPartido.COLUMN_PUNTUACION2 + " gmail, "
                    + EstructuraBBDD_Partidos.EstructuraPartido.COLUMN_PUNTUACION2 + " text);";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS  " + EstructuraBBDD.EstructuraLiga.TABLE_USUARIO;

    private EstructuraBBDD_Partidos() {}

    /* Clase interna que define la estructura de la tabla de operas */
    public static class EstructuraPartido implements BaseColumns {
        public static final String TABLE_PARTIDO = "Partido";
        public static final Date COLUMN_FECHA = new Date();
        public static final String COLUMN_EQUIPO1 = "Equipo1";
        public static final String COLUMN_EQUIPO2 = "Equipo2";
        public static final Integer COLUMN_PUNTUACION1 = Integer.valueOf("Puntuacion_equipo1");
        public static final Integer COLUMN_PUNTUACION2 = Integer.valueOf("Puntuacion_equipo2");
    }
}
