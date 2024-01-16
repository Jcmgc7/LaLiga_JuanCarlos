package com.example.la_liga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Inicar(View view) {

        startActivity(new Intent(Login.this, IniciarSesion.class));
    }
    public void registro(View view) {
        startActivity(new Intent(Login.this, Registrarse.class));
    }
}