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
        usuario=findViewById(R.id.usuario);
        gmail=findViewById(R.id.gmail1);
        contrasena1=findViewById(R.id.contrasena1);
        contrasena2=findViewById(R.id.contrasena2);
        helper= new SQLiteHelper(this);

        db=helper.getWritableDatabase();

    }
    public void iniciar(View view) {
        startActivity(new Intent(Registrarse.this, IniciarSesion.class));
    }
    public void registrarse(View view) {
        db=helper.getReadableDatabase();
        Cursor c = db.rawQuery("select nombre from usuario where nombre = usuario.getText().toString();", null);
        insertar(usuario.getText().toString(), gmail.getText().toString(), contrasena1.getText().toString());
        if (usuario.getText().toString().equals("") || gmail.getText().toString().equals("") || contrasena1.getText().toString().equals("") ||
                contrasena2.getText().toString().equals("")) {
            Toast.makeText(this, "Rellena todos los campos para poder Registrate", Toast.LENGTH_LONG).show();
        } else if ( c == 0) {
            Toast.makeText(this, "Ese usuario ya exixte", Toast.LENGTH_LONG).show();
        } else if (!contrasena1.getText().toString().equals(contrasena2.getText().toString())) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        } else {

        }
    }
    private void insertar(String nombre, String gmail, String contraena) {

        ContentValues values= new ContentValues();
        values.put("Nombre", nombre);
        values.put("Gmail", gmail);
        values.put("Contrasena", contraena);
        db.insert("Usuario",null, values);
    }
}
