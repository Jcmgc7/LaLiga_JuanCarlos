package com.example.la_liga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity {
    EditText usuario;
    EditText gmail;
    EditText contrasena1;
    EditText contrasena2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        usuario=findViewById(R.id.usuario);
        gmail=findViewById(R.id.gmail1);
        contrasena1=findViewById(R.id.contrasena1);
        contrasena2=findViewById(R.id.contrasena2);

    }
    public void iniciar(View view) {
        startActivity(new Intent(Registrarse.this, IniciarSesion.class));
    }
    public void registrarse(View view) {
        if (usuario.getText().toString().equals("") || gmail.getText().toString().equals("") || contrasena1.getText().toString().equals("") ||
                contrasena2.getText().toString().equals("")) {
            Toast.makeText(this, "Rellena todos los campos para poder Registrate", Toast.LENGTH_LONG).show();
        } else if (usuario.getText().toString().equals("Hola")) {
            Toast.makeText(this, "Ese usuario ya exixte", Toast.LENGTH_LONG).show();
        } else if (!contrasena1.getText().toString().equals(contrasena2.getText().toString())) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }
    }
}