package com.gxnova.appgxnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // FLUJO: Inicio -> Mis Trabajos
        // Usamos el ID "btn_trabajar" que es el que tienes en tu XML
        View btnTrabajar = findViewById(R.id.btn_trabajar);

        if (btnTrabajar != null) {
            btnTrabajar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Inicio.this, TrabajosPublicados.class);
                    startActivity(intent);
                }
            });
        }

        // NAVEGACIÓN BARRA INFERIOR
        findViewById(R.id.nav_perfil).setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, Perfil.class)));

        findViewById(R.id.nav_chat).setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, Chat.class)));

        findViewById(R.id.nav_publicaciones).setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, TrabajosPublicados.class)));

        findViewById(R.id.nav_buscar).setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, Buscar_trabajo.class)));
    }
}