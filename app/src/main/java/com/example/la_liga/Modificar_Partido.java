package com.example.la_liga;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Modificar_Partido extends AppCompatActivity {
    EditText jornada;
    EditText equipo1;
    EditText equipo2;
    EditText puntos1;
    EditText puntos2;
    EditText fecha;
    SQLiteDatabase db;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_partidos);

        jornada = findViewById(R.id.id_nombre);
        equipo1 = findViewById(R.id.id_equipo1);
        equipo2 = findViewById(R.id.id_puntos);
        puntos1 = findViewById(R.id.id_puntos1);
        puntos2 = findViewById(R.id.id_ciudad);
        fecha = findViewById(R.id.id_fecha);
        helper = new SQLiteHelper(this);
        db = helper.getWritableDatabase();

        Button buscarButton = findViewById(R.id.button4);
        buscarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jornadaPartido = jornada.getText().toString();
                buscarPartido(jornadaPartido);
            }
        });

        Button modificarButton = findViewById(R.id.button3);
        modificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarPartido();
            }
        });
    }

    @SuppressLint("Range")
    private void buscarPartido(String jornadaPartido) {
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Partido WHERE jornada = ?", new String[]{jornadaPartido});

        if (cursor.moveToFirst()) {
            equipo1.setText(cursor.getString(cursor.getColumnIndex("Equipo1")));
            equipo2.setText(cursor.getString(cursor.getColumnIndex("Equipo2")));
            puntos1.setText(cursor.getString(cursor.getColumnIndex("Puntuacion_equipo1")));
            puntos2.setText(cursor.getString(cursor.getColumnIndex("Puntuacion_equipo2")));
            fecha.setText(cursor.getString(cursor.getColumnIndex("Fecha")));
        } else {
            Toast.makeText(this, "Partido no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    private void modificarPartido() {
        String jornadaPartido = jornada.getText().toString();
        if (!jornadaPartido.isEmpty()) {
            db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Equipo1", equipo1.getText().toString());
            values.put("Equipo2", equipo2.getText().toString());
            values.put("Puntuacion_equipo1", puntos1.getText().toString());
            values.put("Puntuacion_equipo2", puntos2.getText().toString());
            values.put("Fecha", fecha.getText().toString());

            int filasModificadas = db.update("Partido", values, "jornada = ?", new String[]{jornadaPartido});
            if (filasModificadas > 0) {
                Toast.makeText(this, "Partido modificado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No se pudo modificar el partido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Ingrese una jornada válida", Toast.LENGTH_SHORT).show();
        }
    }

    public void salir(View view) {
        startActivity(new Intent(Modificar_Partido.this, Clasificacion.class));
    }
}
