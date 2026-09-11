package com.inventory.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Pantalla de inicio de sesión del proyecto INVENTORY.
 *
 * Esta pantalla recibe un usuario y una contraseña, valida que los dos
 * campos estén diligenciados y compara la información con unas
 * credenciales de demostración. Si los datos coinciden, abrimos la
 * pantalla de bienvenida y le enviamos el nombre del proyecto.
 *
 * Para esta evidencia usamos credenciales de prueba guardadas dentro
 * del propio código, porque el alcance de esta actividad es demostrar
 * el flujo login -> bienvenida en un módulo Android, sin necesidad de
 * conectarnos a un servidor. El módulo de autenticación real de
 * INVENTORY (registro e inicio de sesión) ya lo construimos en el
 * backend con Spring Boot; en una siguiente entrega podríamos conectar
 * esta pantalla con esa API en lugar de usar datos locales.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etContrasena;
    private Button btnIngresar;

    // Credenciales de demostración para esta evidencia académica.
    // No corresponden a ninguna cuenta real ni a datos del proyecto.
    private static final String USUARIO_DEMO = "admin@inventory.com";
    private static final String CONTRASENA_DEMO = "Demo2026";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Enlazamos las vistas del layout con las variables Java
        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(v -> validarEIngresar());
    }

    /**
     * Revisa que los campos no estén vacíos y compara la información
     * ingresada con las credenciales de prueba. Si todo coincide,
     * navega hacia la pantalla de bienvenida; si no, muestra un
     * mensaje de error y se queda en el login.
     */
    private void validarEIngresar() {
        String usuario = etUsuario.getText().toString().trim();
        String contrasena = etContrasena.getText().toString().trim();

        // Validación de campo obligatorio: usuario
        if (usuario.isEmpty()) {
            etUsuario.setError("Ingresa el usuario o correo");
            etUsuario.requestFocus();
            return;
        }

        // Validación de campo obligatorio: contraseña
        if (contrasena.isEmpty()) {
            etContrasena.setError("Ingresa la contraseña");
            etContrasena.requestFocus();
            return;
        }

        // Comparamos contra las credenciales de demostración
        boolean accesoValido = usuario.equalsIgnoreCase(USUARIO_DEMO)
                && contrasena.equals(CONTRASENA_DEMO);

        if (accesoValido) {
            // Login correcto: pasamos a la pantalla de bienvenida
            // enviando el nombre del proyecto como dato extra
            Intent intent = new Intent(LoginActivity.this, BienvenidaActivity.class);
            intent.putExtra("nombreProyecto", "INVENTORY");
            startActivity(intent);
            finish(); // cerramos el login para que no se pueda regresar con el botón atrás
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
