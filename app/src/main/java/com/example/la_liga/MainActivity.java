package com.example.la_liga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if (itemId == R.id.Login) {
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.insertarEquip) {
            Intent i = new Intent(getApplicationContext(), InsertarEquipo.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}