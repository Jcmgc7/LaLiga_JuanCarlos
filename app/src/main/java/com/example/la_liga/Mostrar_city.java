package com.example.la_liga;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;

public class Mostrar_city extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteHelper helper;
    ListView listViewEquipos;
    EditText ciudadEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_nom_city);

        listViewEquipos = findViewById(R.id.lista_equipos);
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();
        ciudadEditText = findViewById(R.id.id_ciudad);
    }

    public void buscar(View view) {
        String ciudadBuscada = ciudadEditText.getText().toString().trim();

        if (!ciudadBuscada.isEmpty()) {
            mostrarEquiposPorCiudad(ciudadBuscada);
        } else {
            Toast.makeText(this, "Introduce una ciudad para buscar", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("Range")
    private void mostrarEquiposPorCiudad(String ciudad) {
        // Realizar la consulta para obtener los equipos de la ciudad
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Equipos WHERE Ciudad = ?", new String[]{ciudad});

        // Adaptar el cursor a tu ListView
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

        // Configurar el adaptador en el ListView
        listViewEquipos.setAdapter(adaptador);
    }

    public void salir(View view) {
        // Agrega aquí el código para salir de la actividad si es necesario
        startActivity(new Intent(Mostrar_city.this, Clasificacion.class));
    }
}

