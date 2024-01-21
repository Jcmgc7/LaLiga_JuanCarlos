package com.example.la_liga;

import android.provider.BaseColumns;

public class EstructuraBBDD {
    public static final String SQL_CREATE_USUARIO =
            "CREATE TABLE IF NOT EXISTS " + EstructuraUsuarios.TABLE_USUARIO +
                    "(" + EstructuraUsuarios._ID + " integer PRIMARY KEY, "
                    + EstructuraUsuarios.COLUMN_NOMBRE + " text, "
                    + EstructuraUsuarios.COLUMN_GMAIL + " text, "
                    + EstructuraUsuarios.COLUMN_CONTRASENA + " text);";
    public static final String SQL_CREATE_EQUIPOS =
                    "CREATE TABLE IF NOT EXISTS " + EstructurauEquipos.TABLE_EQUIPO +
                    "(" + EstructurauEquipos._ID + " integer PRIMARY KEY, "
                    + EstructurauEquipos.COLUMN_NOMBRE2 + " text, "
                    + EstructurauEquipos.COLUMN_CIUDAD + " text, "
                    + EstructurauEquipos.COLUMN_FOTO + " text, "
                    + EstructurauEquipos.COLUMN_PUNTOS + " text);";
    public static final String SQL_CREATE_PARTIDOS =
                    "CREATE TABLE IF NOT EXISTS " + EstructuraPartidos.TABLE_PARTIDO +
                    "(" + EstructuraPartidos._ID + " integer PRIMARY KEY, "
                    + EstructuraPartidos.COLUMN_JORNADA + " Jornada, "
                    + EstructuraPartidos.COLUMN_FECHA + " Fecha, "
                    + EstructuraPartidos.COLUMN_EQUIPO1 + " Equipo1, "
                    + EstructuraPartidos.COLUMN_EQUIPO2 + " Equipo2, "
                    + EstructuraPartidos.COLUMN_PUNTUACION1 + " Puntos1, "
                    + EstructuraPartidos.COLUMN_PUNTUACION2 + " Puntos2);";
    public static final String SQL_DELETE_USUARIO =
            "DROP TABLE IF EXISTS " + EstructuraUsuarios.TABLE_USUARIO + "; ";
    public static final String SQL_DELETE_EQUIPOS =
                    "DROP TABLE IF EXISTS " + EstructurauEquipos.TABLE_EQUIPO + "; ";
    public static final String SQL_DELETE_PARTIDOS =
                    "DROP TABLE IF EXISTS " + EstructuraPartidos.TABLE_PARTIDO + ";";
    private EstructuraBBDD() {}

    public static class EstructuraUsuarios implements BaseColumns {
        //Tabla Usuario
        public static final String TABLE_USUARIO = "Usuario";
        public static final String COLUMN_NOMBRE = "Nombre";
        public static final String COLUMN_GMAIL = "Gmail";
        public static final String COLUMN_CONTRASENA = "Contrasena";
    }
    public static class EstructurauEquipos implements BaseColumns {
        public static final String TABLE_EQUIPO = "Equipos";
        public static final String COLUMN_NOMBRE2 = "Nombre";
        public static final String COLUMN_CIUDAD = "Ciudad";
        public static final String COLUMN_FOTO = "Foto";
        public static final String COLUMN_PUNTOS = "Puntos";
    }
    public static class EstructuraPartidos implements BaseColumns {
        public static final String TABLE_PARTIDO = "Partido";
        public static final String COLUMN_JORNADA = "Jornada";
        public static final String COLUMN_FECHA = "Fecha";
        public static final String COLUMN_EQUIPO1 = "Equipo1";
        public static final String COLUMN_EQUIPO2 = "Equipo2";
        public static final String COLUMN_PUNTUACION1 = "Puntuacion_equipo1";
        public static final String COLUMN_PUNTUACION2 = "Puntuacion_equipo2";
    }
}
