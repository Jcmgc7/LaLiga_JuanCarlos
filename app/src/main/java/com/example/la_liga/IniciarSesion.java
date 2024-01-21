package com.example.la_liga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IniciarSesion extends AppCompatActivity {
    EditText usuario;
    EditText contrasena1;
    SQLiteDatabase db;
    SQLiteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        usuario=findViewById(R.id.id_nombre);
        contrasena1=findViewById(R.id.contrasena);
        helper= new SQLiteHelper(this);
        db=helper.getWritableDatabase();
    }

    public void registro(View view) {
        startActivity(new Intent(IniciarSesion.this, Registrarse.class));
    }

    public void iniciar(View view) {
        db=helper.getReadableDatabase();
        String usuarios = usuario.getText().toString();
        String contrasenas = contrasena1.getText().toString();
        boolean existeUsuario = existeUsuarios(usuarios, contrasenas);
        if (usuario.getText().toString().equals("") || contrasena1.getText().toString().equals("")) {
            Toast.makeText(this, "Rellena todos los campos para poder iniciar sesion", Toast.LENGTH_LONG).show();
        } else if (existeUsuario == false) {
            Toast.makeText(this, "El usuario o la contraseña son incorrectas.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Ese usuario no exixte.", Toast.LENGTH_LONG).show();
        }
    }

    public boolean existeUsuarios(String nombreBuscado,String contrasenaBuscada) {
        Cursor cursor = db.rawQuery("SELECT nombre FROM usuario WHERE nombre = ? AND contrasena = ?", new String[]{nombreBuscado, contrasenaBuscada});
        boolean existe = cursor.moveToFirst();
        return existe;
    }
}