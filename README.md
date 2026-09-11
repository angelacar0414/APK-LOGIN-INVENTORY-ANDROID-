# Login móvil - INVENTORY (GA8-220501096-AA2-EV02)

Este es el módulo de inicio de sesión en Android que construimos para el proyecto INVENTORY, dentro de la evidencia AA2-EV02 de la Guía 8.

## Integrantes

- Ángela Carvajal Ortiz
- Darío Bustamante

Ficha 3186706 - Tecnología en Análisis y Desarrollo de Software (ADSO), SENA.

## Qué hace esta app

Es una app Android pequeña con dos pantallas:

1. **Login**: pide usuario/correo y contraseña, valida que los campos no estén vacíos y que las credenciales coincidan con las de demostración.
2. **Bienvenida**: aparece cuando el login es correcto y muestra el mensaje "Bienvenido a INVENTORY".

Con esta app buscamos demostrar el mismo control de acceso que tiene el proyecto INVENTORY completo, pero a nivel de un módulo móvil sencillo, como lo pide esta evidencia.

## Credenciales de demostración

Para esta entrega usamos credenciales de prueba, guardadas directamente en `LoginActivity.java`. No son contraseñas reales ni corresponden a ninguna cuenta del sistema:

- Usuario: `admin@inventory.com`
- Contraseña: `Demo2026`

En una app real este dato no debería quedar escrito en el código, sino validarse contra un servidor con las contraseñas cifradas. Para este ejercicio, como el alcance definido es un prototipo funcional, optamos por la validación local.

## Estructura del proyecto

```
app/src/main/
├── java/com/inventory/app/
│   ├── LoginActivity.java        -> pantalla de inicio de sesión
│   └── BienvenidaActivity.java   -> pantalla que confirma el acceso
├── res/layout/
│   ├── activity_login.xml
│   └── activity_bienvenida.xml
├── res/values/
│   └── strings.xml
└── AndroidManifest.xml
```

## Cómo lo probamos

Abrimos el proyecto en Android Studio y lo ejecutamos en un emulador. Las pruebas que hicimos antes de grabar el video fueron:

- Dejar los campos vacíos: la app pide completarlos.
- Poner usuario o contraseña incorrectos: aparece el mensaje "Usuario o contraseña incorrectos" y nos quedamos en el login.
- Ingresar las credenciales de demostración: la app pasa a la pantalla de bienvenida y muestra "Bienvenido a INVENTORY".

## Relación con el resto del proyecto

El backend de autenticación de INVENTORY (registro e inicio de sesión) ya está construido con Spring Boot en el repositorio principal del proyecto. En esta evidencia dejamos ese backend aparte y trabajamos la validación local, porque el alcance de esta actividad es el módulo móvil. Conectar esta pantalla con la API real quedaría como una mejora para una próxima entrega.
