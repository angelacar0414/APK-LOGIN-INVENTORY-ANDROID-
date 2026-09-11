package com.inventory.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Pantalla de bienvenida del proyecto INVENTORY.
 *
 * Esta pantalla aparece únicamente después de un inicio de sesión
 * correcto. Recibe el nombre del proyecto que le envía la pantalla de
 * login (a través de un Intent) y lo muestra en un texto grande y
 * centrado, confirmando que el acceso fue exitoso.
 */
public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        TextView tvBienvenida = findViewById(R.id.tvBienvenida);

        // Tomamos el nombre del proyecto que llegó desde el login.
        // Si por algún motivo no llegara nada, dejamos "INVENTORY" por defecto
        // para que la pantalla nunca se quede sin texto.
        String nombreProyecto = getIntent().getStringExtra("nombreProyecto");
        if (nombreProyecto == null || nombreProyecto.trim().isEmpty()) {
            nombreProyecto = "INVENTORY";
        }

        tvBienvenida.setText("Bienvenido a " + nombreProyecto);
    }
}
