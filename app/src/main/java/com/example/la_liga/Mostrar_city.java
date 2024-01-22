package com.example.la_liga;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;

public class Mostrar_city extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteHelper helper;
    ListView listViewEquipos;

    TextView ciudad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_nom_city);

        listViewEquipos = findViewById(R.id.lista_equipos);
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();
        ciudad = findViewById(R.id.id_ciudad);

        // Realizar la búsqueda y mostrar los resultados en el ListView
    }

    private void buscarEquipos() {
        String equipoBuscado =  ciudad.getText().toString();;

        // Modifica la consulta según tus necesidades
        Cursor cursor = db.rawQuery("SELECT * FROM Equipos WHERE Ciudad = ?", new String[]{equipoBuscado});

        // Adaptar el cursor a tu ListView
        String[] from = {
                EstructuraBBDD.EstructurauEquipos.COLUMN_NOMBRE2 + " text, ",
                EstructuraBBDD.EstructurauEquipos.COLUMN_CIUDAD + " text, ",
                EstructuraBBDD.EstructurauEquipos.COLUMN_PUNTOS + " text"
        };

        int[] to = {
                R.id.nombre,
                R.id.ciudad,
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

        listViewEquipos.setAdapter(adaptador);

        listViewEquipos.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Item seleccionado: " + position, Toast.LENGTH_SHORT).show();
        });
    }

    public void buscar(View view) {
        buscarEquipos();
    }
}
