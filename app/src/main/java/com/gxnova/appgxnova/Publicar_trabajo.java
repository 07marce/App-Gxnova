package com.gxnova.appgxnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Publicar_trabajo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_trabajo);

        // BOTÓN VOLVER (MALETA)
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        // BOTÓN PUBLICAR FINAL
        Button btnPublicar = findViewById(R.id.btnPublicarServicioFinal);
        if (btnPublicar != null) {
            btnPublicar.setOnClickListener(v -> {
                Toast.makeText(this, "Servicio Publicado", Toast.LENGTH_SHORT).show();
                finish();
            });
        }

        // NAVEGACIÓN INFERIOR
        LinearLayout navInicio = findViewById(R.id.nav_inicio);
        LinearLayout navBuscar = findViewById(R.id.nav_buscar);
        LinearLayout navPerfil = findViewById(R.id.nav_perfil);

        if (navInicio != null) {
            navInicio.setOnClickListener(v -> {
                startActivity(new Intent(this, Inicio.class));
                finish();
            });
        }
        if (navBuscar != null) {
            navBuscar.setOnClickListener(v -> startActivity(new Intent(this, Buscar_trabajo.class)));
        }
        if (navPerfil != null) {
            navPerfil.setOnClickListener(v -> startActivity(new Intent(this, Perfil.class)));
        }
    }
}