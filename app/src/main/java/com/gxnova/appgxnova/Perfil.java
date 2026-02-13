package com.gxnova.appgxnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity {

    private LinearLayout layoutPersonal, layoutProfesional;
    private TextView tabPersonal, tabProfesional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        layoutPersonal = findViewById(R.id.layout_personal);
        layoutProfesional = findViewById(R.id.layout_profesional);
        tabPersonal = findViewById(R.id.tab_personal);
        tabProfesional = findViewById(R.id.tab_profesional);

        // Cambiar a Información Personal
        tabPersonal.setOnClickListener(v -> {
            layoutPersonal.setVisibility(View.VISIBLE);
            layoutProfesional.setVisibility(View.GONE);
            tabPersonal.setBackgroundResource(R.drawable.anillo_azul);
            tabPersonal.setTextColor(getResources().getColor(android.R.color.white));
            tabProfesional.setBackground(null);
            tabProfesional.setTextColor(getResources().getColor(android.R.color.darker_gray));
        });

        // Cambiar a Información Profesional
        tabProfesional.setOnClickListener(v -> {
            layoutPersonal.setVisibility(View.GONE);
            layoutProfesional.setVisibility(View.VISIBLE);
            tabProfesional.setBackgroundResource(R.drawable.anillo_azul);
            tabProfesional.setTextColor(getResources().getColor(android.R.color.white));
            tabPersonal.setBackground(null);
            tabPersonal.setTextColor(getResources().getColor(android.R.color.darker_gray));
        });

        // Navegación
        findViewById(R.id.nav_inicio).setOnClickListener(v -> startActivity(new Intent(this, Inicio.class)));
        findViewById(R.id.btn_back_perfil).setOnClickListener(v -> finish());
    }
}