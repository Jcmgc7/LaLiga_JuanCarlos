package com.example.la_liga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

public class Registrarse extends AppCompatActivity {
    EditText usuario;
    EditText gmail;
    EditText contraseña1;
    EditText contraseña2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        usuario=findViewById(R.id.edit1);
        gmail=findViewById(R.id.gmail1);
        contraseña1=findViewById(R.id.contraseña1);
        contraseña2=findViewById(R.id.contraseña2);
    }
    public void iniciar(View view) {
        startActivity(new Intent(Registrarse.this, IniciarSesion.class));
    }
    public void registrarse(View view) {

    }
}