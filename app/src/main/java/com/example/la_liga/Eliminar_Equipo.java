package com.example.la_liga;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Eliminar_Equipo extends AppCompatActivity {
    EditText nombreEquipo;
    EditText ciudad;
    ImageView foto;
    EditText puntos;
    SQLiteDatabase db;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_equip);

        nombreEquipo = findViewById(R.id.id_nombre);
        ciudad = findViewById(R.id.id_puntos2);
        puntos = findViewById(R.id.id_equipo2);

        helper = new SQLiteHelper(this);
        db = helper.getWritableDatabase();
    }

    public void buscar(View view) {
        String equipoBuscado = nombreEquipo.getText().toString();

        if (equipoBuscado.equals("")) {
            Toast.makeText(this, "Introduce un nombre de equipo para buscar", Toast.LENGTH_SHORT).show();
        } else {
            buscar(equipoBuscado);
        }
    }

    @SuppressLint("Range")
    private void buscar(String nombreEquipo) {
        Cursor cursor = db.rawQuery("SELECT * FROM Equipos WHERE Nombre = ?", new String[]{nombreEquipo});

        if (cursor.moveToFirst()) {
            ciudad.setText(cursor.getString(cursor.getColumnIndex("Ciudad")));
            puntos.setText(cursor.getString(cursor.getColumnIndex("Puntos")));
        } else {
            Toast.makeText(this, "Equipo no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(View view) {
        String equipoEliminar = nombreEquipo.getText().toString();

        if (equipoEliminar.equals("")) {
            Toast.makeText(this, "Introduce un nombre de equipo para eliminar", Toast.LENGTH_SHORT).show();
        } else {
            // Eliminar el equipo de la base de datos
            db.delete("Equipos", "Nombre=?", new String[]{equipoEliminar});
            Toast.makeText(this, "Equipo eliminado con éxito", Toast.LENGTH_SHORT).show();

            // Limpiar los campos después de eliminar
            nombreEquipo.setText("");
            ciudad.setText("");
            puntos.setText("");
        }
    }

    public void salir(View view) {
        startActivity(new Intent(Eliminar_Equipo.this, Clasificacion.class));
    }
}
