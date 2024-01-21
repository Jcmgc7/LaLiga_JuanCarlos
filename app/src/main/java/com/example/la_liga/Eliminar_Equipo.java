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

public class Eliminar_Equipo extends AppCompatActivity {
    EditText nombre;
    EditText ciudad;
    EditText foto;
    EditText puntos;
    SQLiteDatabase db;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_equip);
        nombre=findViewById(R.id.id_nombre);
        ciudad=findViewById(R.id.id_puntos2);
        //foto=findViewById(R.id.id_foto);
        puntos=findViewById(R.id.id_equipo2);
        helper= new SQLiteHelper(this);
        db=helper.getWritableDatabase();

    }
    public void eliminar(View view) {

    }
    public void buscar(View view) {
        db=helper.getReadableDatabase();
        String usuarios = nombre.getText().toString();
        //boolean existeUsuario = existeUsuario(usuarios);
        if (nombre.getText().toString().equals("") ) {
            Toast.makeText(this, "Inserte el nombre del equipo que quieres eliminar", Toast.LENGTH_LONG).show();
        } else {
            busqueda(nombre.getText().toString(), ciudad.getText().toString(), foto.getText().toString(), puntos.getText().toString());
        }
    }
    private void busqueda(String nombre, String gmail, String contraena, String s) {

        ContentValues values= new ContentValues();
        values.put("Nombre", nombre);
        values.put("Gmail", gmail);
        values.put("Contrasena", contraena);
        db.insert("Usuario",null, values);
    }
    public void existeUsuario(String nombreBuscado, String ciudad, String foto, String puntos) {
        Cursor cursor = db.rawQuery("SELECT * FROM Equipos WHERE nombre = ?", new String[]{nombreBuscado});
        boolean existe = cursor.moveToFirst();
        if(existe){
            nombre.setText("contenido de la consulta");
        }
    }

    public void salir(View view) {
        startActivity(new Intent(Eliminar_Equipo.this, Clasificacion.class));
    }
}
