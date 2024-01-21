package com.example.la_liga;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Mostrar_Equipos extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteHelper helper;
    ListView lv;
    String nombre;
    String ciudad;
    String puntos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_equipos);

        lv = findViewById(R.id.listViewEquipos);
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        // Realizamos la consulta y mostramos los resultados en el ListView
        consultaEquipos();
    }

    private void consultaEquipos() {
        Cursor cursor = db.query(
                "Equipos",
                null,
                null,
                null,
                null,
                null,
                null
        );

        // Adaptamos el cursor a nuestro ListView
        String[] from = {
                "Foto",
                "Nombre",
                "Ciudad",
                "Puntos"
        };

        // Ajustamos el array to para reflejar los cambios en el layout lista_equipos.xml
        int[] to = {
                R.id.imageViewItem,
                R.id.textViewNombre,
                R.id.textViewCiudad,
                R.id.textViewPuntos
        };

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(
                this,
                R.layout.insertar_equipo,
                cursor,
                from,
                to,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        ) {
            @SuppressLint("Range")
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                // Personaliza la vista de cada elemento de la lista si es necesario
                ImageView imageViewItem = view.findViewById(R.id.imageViewItem);
                TextView textViewNombre = view.findViewById(R.id.textViewNombre);
                TextView textViewCiudad = view.findViewById(R.id.textViewCiudad);
                TextView textViewPuntos = view.findViewById(R.id.textViewPuntos);

                // Extrae la información del cursor
                cursor.moveToPosition(position);

                nombre = cursor.getString(cursor.getColumnIndex("Nombre"));
                ciudad = cursor.getString(cursor.getColumnIndex("Ciudad"));
                puntos = cursor.getString(cursor.getColumnIndex("Puntos"));

                return view;
            }
        };

        lv.setAdapter(adaptador);

        // Manejo de clics en los elementos del ListView si es necesario
        lv.setOnItemClickListener((parent, view, position, id) -> {
            // Acciones al hacer clic en un equipo si es necesario
            Toast.makeText(this, "Item seleccionado: " + position, Toast.LENGTH_SHORT).show();
        });
    }
}
