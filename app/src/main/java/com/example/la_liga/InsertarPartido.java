package com.example.la_liga;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertarPartido extends AppCompatActivity {
    EditText jornada;
    EditText fecha;
    EditText equipo1;
    EditText equipo2;
    EditText puntos1;
    EditText puntos2;
    SQLiteDatabase db;
    SQLiteHelper helper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_partido);
        jornada=findViewById(R.id.id_jornada);
        fecha=findViewById(R.id.id_fecha);
        equipo1=findViewById(R.id.id_equipo1);
        equipo2=findViewById(R.id.id_equipo2);
        puntos1=findViewById(R.id.id_puntos1);
        puntos2=findViewById(R.id.id_puntos2);
        helper= new SQLiteHelper(this);
        db=helper.getWritableDatabase();

    }
    public void registrar (View view) {
        db=helper.getReadableDatabase();
        String name = jornada.getText().toString();
        boolean existeUsuario = existeUsuario(name);
        if (jornada.getText().toString().equals("") || fecha.getText().toString().equals("") || equipo1.getText().toString().equals("") ||
                equipo2.getText().toString().equals("") || puntos1.getText().toString().equals("") || puntos2.getText().toString().equals("")) {
            Toast.makeText(this, "Rellena todos los campos para poder Registrate", Toast.LENGTH_LONG).show();
        }  else if (existeUsuario == true) {
            Toast.makeText(this, "Ese Partido ya exixte", Toast.LENGTH_LONG).show();
        } else {
            insertar(jornada.getText().toString(), fecha.getText().toString(), equipo1.getText().toString(), equipo2.getText().toString(), puntos1.getText().toString(), puntos2.getText().toString());
        }
    }
    private void insertar(String jornada, String fecha, String equipo1, String equipo2, String puntos1, String puntos2) {

        ContentValues values= new ContentValues();
        values.put("Jornada", jornada);
        values.put("Fecha", fecha);
        values.put("Equipo1", equipo1);
        values.put("Equipo2", equipo2);
        values.put("Puntuacion_equipo1", puntos1);
        values.put("Puntuacion_equipo2", puntos2);
        db.insert("Partido",null, values);
    }
    public boolean existeUsuario(String nombreBuscado) {
        Cursor cursor = db.rawQuery("SELECT jornada FROM Partido WHERE jornada = ?", new String[]{nombreBuscado});
        boolean existe = cursor.moveToFirst();
        return existe;
    }
}
