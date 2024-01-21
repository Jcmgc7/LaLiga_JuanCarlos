package com.example.la_liga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Clasificacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.InsertarEquipo) {
            Intent i = new Intent(getApplicationContext(), InsertarEquipo.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.InsertarPartidos) {
            Intent i = new Intent(getApplicationContext(), InsertarPartido.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.EliminarEquipos) {
            Intent i = new Intent(getApplicationContext(), Eliminar_Equipo.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.EliminarPartido) {
            Intent i = new Intent(getApplicationContext(), Eliminar_Partidos.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.ModificarPartidos) {
            Intent i = new Intent(getApplicationContext(), Modificar_Partido.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.ModificarEquipos) {
            Intent i = new Intent(getApplicationContext(), Modificar_Equipo.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}