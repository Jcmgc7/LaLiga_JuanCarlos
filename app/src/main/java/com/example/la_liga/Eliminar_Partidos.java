package com.example.la_liga;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Eliminar_Partidos extends AppCompatActivity {
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
        setContentView(R.layout.activity_eliminar_partidos);

        jornada = findViewById(R.id.id_nombre);
        equipo1 = findViewById(R.id.id_equipo1);
        equipo2 = findViewById(R.id.id_equipo2);
        puntos1 = findViewById(R.id.id_puntos1);
        puntos2 = findViewById(R.id.id_puntos2);
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

        Button eliminarButton = findViewById(R.id.button3);
        eliminarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarPartido();
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

    private void eliminarPartido() {
        String jornadaPartido = jornada.getText().toString();
        db = helper.getWritableDatabase();
        db.delete("Partido", "Jornada = ?", new String[]{jornadaPartido});
        Toast.makeText(this, "Partido eliminado correctamente", Toast.LENGTH_SHORT).show();
        limpiarCampos();
    }

    private void limpiarCampos() {
        jornada.setText("");
        equipo1.setText("");
        equipo2.setText("");
        puntos1.setText("");
        puntos2.setText("");
        fecha.setText("");
    }

    public void salir(View view) {
        startActivity(new Intent(Eliminar_Partidos.this, Clasificacion.class));
    }
}
