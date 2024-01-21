package com.example.la_liga;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsertarEquipo extends AppCompatActivity {
    EditText nombre;
    EditText ciudad;
    EditText foto;
    EditText puntos;
    SQLiteDatabase db;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertar_equipo);
        nombre=findViewById(R.id.id_nombre);
        ciudad=findViewById(R.id.id_ciudad);
        foto=findViewById(R.id.id_foto);
        puntos=findViewById(R.id.id_puntos);
        helper= new SQLiteHelper(this);
        db=helper.getWritableDatabase();

    }

    public void registrarse(View view) {
        db=helper.getReadableDatabase();
        String equipo = nombre.getText().toString();
        boolean existeEquipo = existeEquipo(equipo);
        if (nombre.getText().toString().equals("") || ciudad.getText().toString().equals("") || foto.getText().toString().equals("") ||
                puntos.getText().toString().equals("")) {
            Toast.makeText(this, "Rellene los campos", Toast.LENGTH_LONG).show();
        }else if(existeEquipo == true){
            Toast.makeText(this, "Ese equipo ya exixte", Toast.LENGTH_LONG).show();
        }else{
            insertar(nombre.getText().toString(), ciudad.getText().toString(), foto.getText().toString(),puntos.getText().toString());
        }
    }
    private void insertar(String nombre, String ciudad, String foto, String puntos) {

        ContentValues values= new ContentValues();
        values.put("Nombre", nombre);
        values.put("Ciudad", ciudad);
        values.put("Fotos", foto);
        values.put("Puntos", puntos);
        db.insert("Equipos",null, values);
    }
    public boolean existeEquipo(String nombreBuscado) {
        Cursor cursor = db.rawQuery("SELECT nombre FROM Equipos WHERE nombre = ?", new String[]{nombreBuscado});
        boolean existe = cursor.moveToFirst();
        return existe;
    }
}
