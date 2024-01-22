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
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class Clasificacion extends AppCompatActivity {
     ArrayAdapter<String> adapter;
     ListView listView;
    SQLiteDatabase db;
    SQLiteHelper helper;
    Cursor cursor;
    Cursor id;

    @Override
    @SuppressLint("Range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion2);

        helper = new SQLiteHelper(this);
        db = helper.getWritableDatabase();
        listView = findViewById(R.id.lista);
        listView.setAdapter(adapter);
        mostrarDatosEquipos();
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
        } else if (itemId == R.id.MonstarCiudad) {
            Intent i = new Intent(getApplicationContext(), Mostrar_city.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void mostrarDatosEquipos() {
        // Obtén una instancia de la base de datos en modo lectura
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();
        // Realiza una consulta para obtener los datos de la tabla "equipos"
        Cursor cursor = db.query(
                EstructuraBBDD.EstructurauEquipos.TABLE_EQUIPO,
                null,
                null,
                null,
                null,
                null,
                null
        );

        // Configura el adaptador con el cursor
        String[] from = {
                EstructuraBBDD.EstructurauEquipos.COLUMN_NOMBRE2,
                EstructuraBBDD.EstructurauEquipos.COLUMN_CIUDAD,
                EstructuraBBDD.EstructurauEquipos.COLUMN_FOTO,
                EstructuraBBDD.EstructurauEquipos.COLUMN_PUNTOS
        };

        int[] to = {
                R.id.nombre,
                R.id.ciudad,
                R.id.imagen,
                R.id.puntos,
        };

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(
                this,
                R.layout.activity_lista_equipos,
                cursor,
                from,
                to,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );

        // Configura el adaptador en el ListView
        listView.setAdapter(adaptador);

        // Cierra la base de datos después de usarla
        db.close();
    }
}