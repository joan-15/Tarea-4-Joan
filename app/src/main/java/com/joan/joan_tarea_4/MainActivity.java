package com.joan.joan_tarea_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();

        EditText editTextPrimerNombre = findViewById(R.id.editTextPrimerNombre);
        EditText editTextApellido = findViewById(R.id.editTextApellido);
        EditText editTextAñoNacimiento = findViewById(R.id.editTextAñoNacimiento);
        Button buttonGuardar = findViewById(R.id.buttonGuardar);
        Button buttonVerDatos = findViewById(R.id.buttonVerDatos);

        buttonGuardar.setOnClickListener(v -> guardarDatosFirebase(editTextPrimerNombre.getText().toString().trim(),
                editTextApellido.getText().toString().trim(),
                Integer.parseInt(editTextAñoNacimiento.getText().toString().trim())));

        buttonVerDatos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VerDatosActivity.class);
            startActivity(intent);
        });

        mostrarCantidadTotalDatos();
    }

    private void guardarDatosFirebase(String primerNombre, String apellido, int añoNacimiento) {
        Map<String, Object> usuario = new HashMap<>();
        usuario.put("primerNombre", primerNombre);
        usuario.put("apellido", apellido);
        usuario.put("añoNacimiento", añoNacimiento);

        db.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(MainActivity.this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
                    mostrarCantidadTotalDatos();
                })
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Error al guardar datos", Toast.LENGTH_SHORT).show());
    }

    private void mostrarCantidadTotalDatos() {
        db.collection("usuarios")
                .get()
                .addOnSuccessListener(querySnapshot -> {
                    long cantidad = querySnapshot.size();
                    Toast.makeText(MainActivity.this, "Cantidad total de datos: " + cantidad, Toast.LENGTH_SHORT).show();
                });
    }
}
