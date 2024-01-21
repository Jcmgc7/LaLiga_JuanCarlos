package com.example.la_liga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Clasificacion extends AppCompatActivity {
     ArrayAdapter<String> adapter;
     ListView listView;
    SQLiteDatabase db;
    SQLiteHelper helper;
    Cursor cursor;
    @Override
    @SuppressLint("Range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion2);

        helper = new SQLiteHelper(this);
        db = helper.getWritableDatabase();
        int x = 1;

        ArrayList<String> datos = new ArrayList();
        do {
            cursor = db.rawQuery("SELECT * FROM Equipos WHERE _id = ?", new String[]{String.valueOf(x)});
            if (cursor.moveToNext()) {  // Cambiado de moveToFirst a moveToNext
                String nombreEquipo = cursor.getString(cursor.getColumnIndex("Nombre"));
                String puntosEquipo = cursor.getString(cursor.getColumnIndex("Puntos"));
                datos.add(x + "º Nombre:" + nombreEquipo + " | Puntos:" + puntosEquipo);
            }
            x = x + 1;
        } while (cursor.moveToNext());

        // Crear el adaptador
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);

        // Obtener la referencia al ListView y establecer el adaptador
        listView = findViewById(R.id.lista);
        listView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.InsertarEquipo) {
            Intent i = new Intent(getApplicationContext(), InsertarEquipo.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.InsertarPartidos) {
            Intent i = new Intent(getApplicationContext(), InsertarPartido.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.EliminarEquipos) {
            Intent i = new Intent(getApplicationContext(), Eliminar_Equipo.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.EliminarPartido) {
            Intent i = new Intent(getApplicationContext(), Eliminar_Partidos.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.ModificarPartidos) {
            Intent i = new Intent(getApplicationContext(), Modificar_Partido.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.ModificarEquipos) {
            Intent i = new Intent(getApplicationContext(), Modificar_Equipo.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.MostrarEquipos) {
            Intent i = new Intent(getApplicationContext(), Mostrar_Equipos.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}