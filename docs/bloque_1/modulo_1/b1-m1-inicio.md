---
hide:
  - toc
---
# Kotlin para supervivientes de Java

!!! abstract "Objetivo del módulo"
    Cambiar el chip de la programación Imperativa a la Funcional, eliminar para siempre el código "basura" (*boilerplate*) y erradicar de nuestras vidas el temido `NullPointerException`.

Si vienes de estudiar Java en el curso anterior, enhorabuena: ya tienes la lógica de programación en tu cabeza. Pero ahora toca dar un salto evolutivo. Kotlin no es solo "Java con menos puntos y coma", es un lenguaje moderno que te obliga a pensar de forma diferente. Es más seguro, más conciso y mucho más potente.



En este módulo vamos a construir el "puente" entre lo que ya sabes y lo que necesitas dominar para poder enfrentarte a Jetpack Compose sin que te explote la cabeza.

!!! success "💡 ¿Qué vas a dominar aquí?"
    Dejarás de escribir *Getters* y *Setters* a mano, aprenderás a pasar funciones como si fueran variables (*Lambdas*), extenderás clases que no son tuyas y descubrirás cómo ejecutar tareas pesadas en segundo plano sin bloquear tu aplicación.

---

## 🗂️ Contenidos del Módulo

A lo largo de este módulo trabajaremos los siguientes conceptos clave. Haz clic en cada uno para acceder a la lección:

* [**Val vs Var & Null Safety:**](b1-m1_1-val_var_null_safety.md) Descubre por qué en Kotlin las variables prefieren ser inmutables. Aprenderemos a usar el operador Elvis (`?:`) y el *Safe Call* (`?.`) para enterrar al `NullPointerException` de una vez por todas.
* [**Data Classes & Lambdas:**](b1-m1_2-data_class_lambdas.md) El fin del código repetitivo. Crearemos estructuras de datos completas en una sola línea y entenderemos las *Lambdas* (funciones como parámetros), un concepto que será el 90% de tu código visual más adelante.
* [**Extension Functions:**](b1-m1_3-extension_functions.md) ¿Te imaginas poder añadirle una función nueva a la clase `String` de Kotlin aunque tú no la hayas programado? Aprenderemos a inyectar superpoderes a clases ajenas (ej: `String.esEmailValido()`).
* [**Colecciones Modernas:**](b1-m1_4-colecciones_modernas.md) Olvídate de escribir bucles `for` gigantescos para buscar un dato en una lista. Veremos cómo manipular datos al estilo funcional usando `.map`, `.filter` y `.find`.
* [**Corrutinas Básicas:**](b1-m1_5-corrutinas_basicas.md) Introducción a las `suspend fun`. Entenderemos la diferencia vital entre "bloquear" el hilo principal de la app (y congelar la pantalla) y "suspender" la ejecución de forma inteligente.

---

## 🚀 ¿Todo listo para dar el salto?

Prepárate para borrar mucho código innecesario de tu mente. Vamos a empezar por lo más básico: cómo declarar variables y cómo hacer que nuestro código sea a prueba de fallos nulos.

<div style="display: flex; justify-content: space-between; margin-top: 2rem;" markdown="span">
  [⬅️ Volver al Bloque 1](../b1-inicio.md){: .md-button }
  [Empezar: Val vs Var ➡️](b1-m1_1-val_var_null_safety.md){: .md-button .md-button--primary }
</div>