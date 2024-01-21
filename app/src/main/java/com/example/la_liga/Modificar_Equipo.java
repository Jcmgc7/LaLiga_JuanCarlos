package com.example.la_liga;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Modificar_Equipo extends AppCompatActivity {
    EditText nombreEquipo;
    EditText ciudad;
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
            buscarEquipo(equipoBuscado);
        }
    }

    @SuppressLint("Range")
    private void buscarEquipo(String nombreEquipo) {
        Cursor cursor = db.rawQuery("SELECT * FROM Equipos WHERE Nombre = ?", new String[]{nombreEquipo});

        if (cursor.moveToFirst()) {
            ciudad.setText(cursor.getString(cursor.getColumnIndex("Ciudad")));
            puntos.setText(cursor.getString(cursor.getColumnIndex("Puntos")));
        } else {
            Toast.makeText(this, "Equipo no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificar(View view) {
        String nombreEquipoModif = nombreEquipo.getText().toString();
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Ciudad", ciudad.getText().toString());
        values.put("Puntos", puntos.getText().toString());
        int filasModificadas = db.update("Equipos", values, "Nombre = ?", new String[]{nombreEquipoModif});
        Toast.makeText(this, "Equipo modificado correctamente", Toast.LENGTH_SHORT).show();
        limpiarCampos();
    }

    public void salir(View view) {
        startActivity(new Intent(Modificar_Equipo.this, Clasificacion.class));
    }

    private void limpiarCampos() {
        ciudad.setText("");
        puntos.setText("");
    }
}
