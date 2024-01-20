package com.example.la_liga;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MostrarEquipos extends AppCompatActivity {

    private LinearLayout linearLayoutContenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.tu_layout);

        //linearLayoutContenedor = findViewById(R.id.id_calsi);

        // Supongamos que has realizado un registro y obtienes información, por ejemplo, un nombre.
        String nombreRegistrado = "UsuarioNuevo";

        // Crea un nuevo TextView programáticamente
        TextView nuevoTextView = new TextView(this);
        nuevoTextView.setText("Nuevo registro: " + nombreRegistrado);

        // Agrega el nuevo TextView al LinearLayout
        linearLayoutContenedor.addView(nuevoTextView);
    }
}

