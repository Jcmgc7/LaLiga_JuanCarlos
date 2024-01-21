package com.example.la_liga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Eliminar_Partidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_partidos);
    }

    public void salir(View view) {
        startActivity(new Intent(Eliminar_Partidos.this, Clasificacion.class));
    }
}