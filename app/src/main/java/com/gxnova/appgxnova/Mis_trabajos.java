package com.gxnova.appgxnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class Mis_trabajos extends AppCompatActivity {

    // 1. Declaramos los botones
    private MaterialButton btnPublicarTrabajo; // El azul de arriba
    private MaterialButton btnPublicarCentro;  // El azul que tiene el "+"
    private ImageButton btnBack;               // La flecha para volver

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_trabajos);

        // 2. Los vinculamos con el XML
        btnBack = findViewById(R.id.btnBack);
        btnPublicarTrabajo = findViewById(R.id.btnPublicarTrabajo);
        btnPublicarCentro = findViewById(R.id.btnPublicarCentro);

        // 3. Programamos la flecha para que se cierre esta pantalla y vuelvas a Inicio
        btnBack.setOnClickListener(v -> finish());

        // 4. Programamos el botón azul para que abra el formulario
        btnPublicarTrabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AQUÍ: Mis_trabajos es donde estás, Publicar_trabajo es a donde vas
                Intent intent = new Intent(Mis_trabajos.this, Publicar_trabajo.class);
                startActivity(intent);
            }
        });

        // Hacemos lo mismo para el botón azul del centro por si no hay trabajos
        btnPublicarCentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mis_trabajos.this, Publicar_trabajo.class);
                startActivity(intent);
            }
        });
    }
}