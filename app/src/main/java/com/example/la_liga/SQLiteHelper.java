package com.example.la_liga;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "bdLiga.db";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EstructuraBBDD.SQL_CREATE_USUARIO);
        db.execSQL(EstructuraBBDD.SQL_CREATE_EQUIPOS);
        db.execSQL(EstructuraBBDD.SQL_CREATE_PARTIDOS);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(EstructuraBBDD.SQL_DELETE_USUARIO);
        db.execSQL(EstructuraBBDD.SQL_CREATE_USUARIO);
        db.execSQL(EstructuraBBDD.SQL_DELETE_EQUIPOS);
        db.execSQL(EstructuraBBDD.SQL_CREATE_EQUIPOS);
        db.execSQL(EstructuraBBDD.SQL_DELETE_PARTIDOS);
        db.execSQL(EstructuraBBDD.SQL_CREATE_PARTIDOS);
    }
}
