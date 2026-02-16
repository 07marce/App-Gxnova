package com.gxnova.appgxnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Auth extends AppCompatActivity {

    Button btnLogin;
    Button btnRegister;
    TextView tabLogin, tabRegister;
    LinearLayout layoutLogin, layoutRegister;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        tabLogin = findViewById(R.id.tabLogin);
        tabRegister = findViewById(R.id.tabRegister);

        layoutLogin = findViewById(R.id.layoutLogin);
        layoutRegister = findViewById(R.id.layoutRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Auth.this, Inicio.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Auth.this, Inicio.class);
                startActivity(intent);
            }
        });

        // Lógica para seleccionar la pestaña "Iniciar Sesión"
        tabLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutLogin.setVisibility(View.VISIBLE);
                layoutRegister.setVisibility(View.GONE);

                // APLICA EL DRAWABLE (BLANCO/ACTIVO)
                tabLogin.setBackgroundResource(R.drawable.bg_tab_active);
                // TEXTO NEGRO
                tabLogin.setTextColor(getColor(R.color.gx_black));

                // APLICA EL DRAWABLE (TRANSPARENTE/INACTIVO)
                tabRegister.setBackgroundResource(R.drawable.bg_tab_inactive);
                // TEXTO NEGRO (Según el diseño final)
                tabRegister.setTextColor(getColor(R.color.gx_black));
            }
        });


        // Lógica para seleccionar la pestaña "Registrarse"
        tabRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutLogin.setVisibility(View.GONE);
                layoutRegister.setVisibility(View.VISIBLE);

                // APLICA EL DRAWABLE (BLANCO/ACTIVO)
                tabRegister.setBackgroundResource(R.drawable.bg_tab_active);
                // TEXTO NEGRO
                tabRegister.setTextColor(getColor(R.color.gx_black));

                // APLICA EL DRAWABLE (TRANSPARENTE/INACTIVO)
                tabLogin.setBackgroundResource(R.drawable.bg_tab_inactive);
                // TEXTO NEGRO (Según el diseño final)
                tabLogin.setTextColor(getColor(R.color.gx_black));
            }
        });


    }
}