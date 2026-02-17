---
hide:
  - toc
---
# El Ecosistema Android (Entorno y Compilación)

!!! abstract "Objetivo del módulo"
    Entender dónde estamos programando, preparar nuestras herramientas y descubrir por qué el proyecto a veces "no compila" (y cómo solucionarlo **sin entrar en pánico**).

Antes de empezar a escribir código brillante, necesitamos un taller en condiciones. El desarrollo Android tiene fama de ser pesado de configurar al principio, pero si entiendes las piezas del puzzle desde el día 1, te ahorrarás horas de frustración mirando barras de carga rojas.

En este módulo no vamos a programar interfaces todavía. Vamos a preparar el terreno y a entender el motor que hace que nuestro código se convierta en una aplicación real.

!!! success "¿Qué vas a dominar aquí?"
    Dejarás Android Studio instalado y configurado, sabrás exactamente para qué sirve cada archivo de tu proyecto (ignorando el ruido) y entenderás a la perfección cómo funciona Gradle y las versiones de Android.

---

## 🗂️ Contenidos del Módulo

A lo largo de este módulo trabajaremos los siguientes conceptos clave:

* [**Instalación y Emuladores:**](b1-m0_1-instalacion_emuladores.md) Instalaremos Android Studio y superaremos el primer "jefe final" del curso: configurar la BIOS y la virtualización para que tu ordenador pueda arrancar un móvil virtual sin explotar.
* [**Tu Primer Proyecto:**](b1-m0_2-primer_proyecto.md) Crearemos un proyecto *Empty Compose Activity*. Veremos qué hace la carpeta `app`, dónde va el código, dónde los recursos y aprenderemos a ignorar las 50 carpetas que no necesitamos tocar.
* [**Versiones de Android (API Levels):**](b1-m0_3-versiones_android.md) ¿Qué diferencia hay entre `minSdk`, `targetSdk` y `compileSdk`? Aprenderemos a decidir en qué versiones de Android va a funcionar nuestra app.
* [**El Motor (Gradle y AGP):**](b1-m0_4-motor_gradle_agp.md) Desmitificaremos el *Android Gradle Plugin*. Entenderemos la estructura de los archivos `build.gradle.kts` para añadir librerías sin miedo.
* [**Procesamiento de Anotaciones (KSP vs KAPT):**](b1-m0_5-anotaciones_ksp_kapt.md) Veremos por qué *KAPT* está obsoleto y hace la compilación lentísima, y por qué usaremos *KSP* (Kotlin Symbol Processing) como el estándar moderno para bases de datos e inyección de dependencias.

---

## 🚀 ¿Todo listo para empezar?

Ponte el mono de trabajo. Vamos a instalar nuestra herramienta principal y a configurar ese emulador.

<div style="display: flex; justify-content: space-between; margin-top: 2rem;" markdown="span">
  [⬅️ Volver al Bloque 1](../b1-inicio.md){: .md-button }
  [Empezar: Instalación y Emuladores ➡️](b1-m0_1-instalacion_emuladores.md){: .md-button .md-button--primary }
</div>