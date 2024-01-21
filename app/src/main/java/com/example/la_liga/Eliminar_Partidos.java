package com.example.la_liga;

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
                buscar(jornadaPartido);
            }
        });

        Button eliminarButton = findViewById(R.id.button3);
        eliminarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar();
            }
        });
    }

    private void buscar(String jornadaPartido) {
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Partidos WHERE Jornada = ?", new String[]{jornadaPartido});

        if (cursor.moveToFirst()) {
            equipo1.setText(cursor.getString(cursor.getColumnIndex("Equipo1")));
            equipo2.setText(cursor.getString(cursor.getColumnIndex("Equipo2")));
            puntos1.setText(cursor.getString(cursor.getColumnIndex("Puntos1")));
            puntos2.setText(cursor.getString(cursor.getColumnIndex("Puntos2")));
            fecha.setText(cursor.getString(cursor.getColumnIndex("Fecha")));
        } else {
            Toast.makeText(this, "Partido no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminar() {
        String jornadaPartido = jornada.getText().toString();
        if (!jornadaPartido.isEmpty()) {
            db = helper.getWritableDatabase();
            int filasEliminadas = db.delete("Partidos", "Jornada = ?", new String[]{jornadaPartido});
            if (filasEliminadas > 0) {
                Toast.makeText(this, "Partido eliminado correctamente", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            } else {
                Toast.makeText(this, "No se pudo eliminar el partido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Ingrese una jornada válida", Toast.LENGTH_SHORT).show();
        }
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
