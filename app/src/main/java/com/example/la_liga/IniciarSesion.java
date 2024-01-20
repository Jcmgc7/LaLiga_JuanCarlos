package com.example.la_liga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IniciarSesion extends AppCompatActivity {
    EditText usuario;
    EditText contrasena1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        usuario=findViewById(R.id.id_nombre);
        contrasena1=findViewById(R.id.contrasena);
    }

    public void registro(View view) {
        startActivity(new Intent(IniciarSesion.this, Registrarse.class));
    }

    public void iniciar(View view) {
        if (usuario.getText().toString().equals("") || contrasena1.getText().toString().equals("")) {
            Toast.makeText(this, "Rellena todos los campos para poder iniciar sesion", Toast.LENGTH_LONG).show();
        }
            Toast.makeText(this, "Ese usuario no exixte.", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_LONG).show();
    }
}