package com.joan.joan_tarea_4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import com.google.firebase.firestore.DocumentSnapshot;


public class VerDatosActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private ListView listViewDatos;
    private ArrayList<Dato> listaDatos;
    private AdaptadorDatos adaptadorDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);

        db = FirebaseFirestore.getInstance();
        listViewDatos = findViewById(R.id.listViewDatos);
        listaDatos = new ArrayList<>();
        adaptadorDatos = new AdaptadorDatos(this, listaDatos);
        listViewDatos.setAdapter(adaptadorDatos);

        obtenerDatosDesdeFirebase();
    }

    private void obtenerDatosDesdeFirebase() {
        CollectionReference collectionReference = db.collection("usuarios");
        collectionReference.get().addOnSuccessListener(queryDocumentSnapshots -> {
            listaDatos.clear();
            for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                Dato dato = documentSnapshot.toObject(Dato.class);
                listaDatos.add(dato);
            }
            adaptadorDatos.notifyDataSetChanged();
        }).addOnFailureListener(e -> {
            // Manejar errores de consulta
        });
    }
}
