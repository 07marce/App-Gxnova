package com.gxnova.appgxnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Auth extends AppCompatActivity {

    Button btnLogin;
    Button btnRegister;
    TextView tabLogin, tabRegister;
    LinearLayout layoutLogin, layoutRegister;
    Spinner spCategoria;

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

        // Referencia al Spinner
        spCategoria = findViewById(R.id.spCategoria);

        // Configurar el adapter con el array
        String[] opciones = getResources().getStringArray(R.array.QueBuscas);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        ) {
            @Override
            public int getCount() {
                // Restamos 1 para que el último elemento (hint) no aparezca en el desplegable
                return super.getCount() - 1;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategoria.setAdapter(adapter);

        // Mostrar el último elemento como hint inicial
        spCategoria.setSelection(adapter.getCount());

        // Listener para capturar selección
        spCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                if (position == adapter.getCount()) {
                    // Es el hint, lo mostramos en gris
                    tv.setText("¿Qué buscas?");
                    tv.setTextColor(getResources().getColor(R.color.spinner_hint));
                } else {
                    // Opciones reales en negro
                    tv.setTextColor(getResources().getColor(R.color.gx_black));
                    String opcion = opciones[position]; // aquí ya no usamos getItem
                    Toast.makeText(getApplicationContext(), "Seleccionaste: " + opcion, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se seleccionó nada
            }
        });

        // Botón Login
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(Auth.this, Inicio.class);
            startActivity(intent);
        });

        // Botón Register con validación del Spinner
        btnRegister.setOnClickListener(v -> {
            if (spCategoria.getSelectedItemPosition() == adapter.getCount()) {
                Toast.makeText(getApplicationContext(), "Por favor selecciona una opción válida", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(Auth.this, Inicio.class);
                intent.putExtra("opcionSeleccionada", opciones[spCategoria.getSelectedItemPosition()]);
                startActivity(intent);
            }
        });

        // Lógica pestañas
        tabLogin.setOnClickListener(view -> {
            layoutLogin.setVisibility(View.VISIBLE);
            layoutRegister.setVisibility(View.GONE);

            tabLogin.setBackgroundResource(R.drawable.bg_tab_active);
            tabLogin.setTextColor(getColor(R.color.gx_black));

            tabRegister.setBackgroundResource(R.drawable.bg_tab_inactive);
            tabRegister.setTextColor(getColor(R.color.gx_black));
        });

        tabRegister.setOnClickListener(view -> {
            layoutLogin.setVisibility(View.GONE);
            layoutRegister.setVisibility(View.VISIBLE);

            tabRegister.setBackgroundResource(R.drawable.bg_tab_active);
            tabRegister.setTextColor(getColor(R.color.gx_black));

            tabLogin.setBackgroundResource(R.drawable.bg_tab_inactive);
            tabLogin.setTextColor(getColor(R.color.gx_black));
        });
    }
}