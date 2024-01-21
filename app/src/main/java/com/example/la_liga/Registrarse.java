package com.example.la_liga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity {
    EditText usuario;
    EditText gmail;
    EditText contrasena1;
    EditText contrasena2;
    SQLiteDatabase db;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        usuario=findViewById(R.id.id_nombre);
        gmail=findViewById(R.id.id_ciudad);
        contrasena1=findViewById(R.id.contrasena1);
        contrasena2=findViewById(R.id.id_puntos);
        helper= new SQLiteHelper(this);
        db=helper.getWritableDatabase();

    }
    public void iniciar(View view) {
        startActivity(new Intent(Registrarse.this, IniciarSesion.class));
    }
    public void registrarse(View view) {
        db=helper.getReadableDatabase();
        String usuarios = usuario.getText().toString();
        boolean existeUsuario = existeUsuario(usuarios);
        if (usuario.getText().toString().equals("") || gmail.getText().toString().equals("") || contrasena1.getText().toString().equals("") ||
                contrasena2.getText().toString().equals("")) {
            Toast.makeText(this, "Rellena todos los campos para poder Registrate.", Toast.LENGTH_LONG).show();
        } else if (!gmail.getText().toString().contains("gmail.com")) {
            Toast.makeText(this, "Escriva corectamente el gmail.", Toast.LENGTH_LONG).show();
        } else if (!contrasena1.getText().toString().equals(contrasena2.getText().toString())) {
            Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_LONG).show();
        } else if (existeUsuario == true) {
            Toast.makeText(this, "Ese usuario ya exixte.", Toast.LENGTH_LONG).show();
        } else {
            insertar(usuario.getText().toString(), gmail.getText().toString(), contrasena1.getText().toString());
        }
    }
    private void insertar(String nombre, String gmail, String contraena) {

        ContentValues values= new ContentValues();
        values.put("Nombre", nombre);
        values.put("Gmail", gmail);
        values.put("Contrasena", contraena);
        db.insert("Usuario",null, values);
    }
    public boolean existeUsuario(String nombreBuscado) {
        Cursor cursor = db.rawQuery("SELECT nombre FROM usuario WHERE nombre = ?", new String[]{nombreBuscado});
        boolean existe = cursor.moveToFirst();
        return existe;
    }
}
