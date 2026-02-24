# 💻 Práctica Módulo 1: El Refactor "Frankenstein"

¡Enhorabuena! Te acaban de contratar en una empresa navarra de software para mantener una aplicación de gestión de alumnos del ciclo de DAM. 

El problema es que el programador anterior venía de usar Java en el año 2015, odiaba las novedades y escribió un código espantoso. La aplicación actual congela la pantalla al cargar, tiene fallos de nulos y el código es larguísimo.

!!! abstract "🎯 Tu misión"
    Usar tus nuevos superpoderes de Kotlin para refactorizar la lógica, hacerla segura, asíncrona y funcional.

---

## 🛠️ Paso 0: Preparar el entorno

Antes de programar, vamos a dejar el taller listo:

<div class="codelab-task">
    <input type="checkbox" id="task-0-1">
    <label for="task-0-1">Ve a nuestro repositorio de GitHub y descarga (o clona) la rama <code>starter-code</code> del Proyecto 1.</label>
</div>
<div class="codelab-task">
    <input type="checkbox" id="task-0-2">
    <label for="task-0-2">Ábrelo en Android Studio recordando la regla de oro: <code>File > Open > Selecciona la carpeta del proyecto</code> (no la raíz del repositorio).</label>
</div>
<div class="codelab-task">
    <input type="checkbox" id="task-0-3">
    <label for="task-0-3">Dale al "Play" en tu emulador. Verás que la app tiene una lista de alumnos vacía, un botón de "Cargar Alumnos" que congela toda la app durante 3 segundos, y a veces se cierra de golpe (crashea).</label>
</div>

---

## 📦 Paso 1: La dieta de la Data Class

Abre el archivo `AlumnoEntity.kt`. Verás que el programador anterior escribió 30 líneas de código definiendo las variables, los constructores, los *getters* y *setters* a mano.

<div class="codelab-task">
    <input type="checkbox" id="task-1-1">
    <label for="task-1-1"><strong>Tu tarea:</strong> Borra todo ese código y conviértelo en una única línea usando una <code>data class</code> de Kotlin. El alumno debe tener tres propiedades inmutables: <code>nombre</code> (String), <code>dni</code> (String) y <code>notaMedia</code> (Double).</label>
</div>

??? success "👀 Ver Solución (Paso 1)"
    Solo tenías que borrar todo el archivo y dejar esta línea. ¡Adiós a 30 líneas de código inútil!
    
    ```kotlin
    data class AlumnoEntity(
        val nombre: String,
        val dni: String,
        val notaMedia: Double
    )
    ```

---

## 🛡️ Paso 2: Operación Anti-Nulos

Abre el archivo `GestorAlumnos.kt`. Busca la función `obtenerNombrePorDni(dni: String)`.

Actualmente, esta función devuelve un `String?` (puede ser nulo si el DNI no existe) y usa unos bloques `if/else` horribles para devolver "Desconocido" si falla.

<div class="codelab-task">
    <input type="checkbox" id="task-2-1">
    <label for="task-2-1"><strong>Tu tarea:</strong> Refactoriza esa función para que devuelva un <code>String</code> (no nulo) utilizando el Operador Elvis (<code>?:</code>) en una sola línea.</label>
</div>

??? success "👀 Ver Solución (Paso 2)"
    Buscamos el alumno y, si el resultado o su nombre es nulo, el operador Elvis salta al rescate asignando el valor por defecto.
    
    ```kotlin
    fun obtenerNombrePorDni(dni: String): String {
        val alumno = baseDeDatos.find { it.dni == dni }
        // Usamos Safe Call (?.) por si el alumno no existe, y Elvis (?:) para el valor por defecto
        return alumno?.nombre ?: "Desconocido"
    }
    ```

---

## 🔌 Paso 3: Superpoderes con Extension Functions

En el mismo archivo, verás que hay una función espantosa llamada `formatearNota(nota: Double)` que devuelve algo como "8.5 pts".

<div class="codelab-task">
    <input type="checkbox" id="task-3-1">
    <label for="task-3-1"><strong>Tu tarea:</strong> Elimina esa función. En su lugar, crea una <em>Extension Function</em> sobre la clase <code>Double</code> llamada <code>aFormatoNota()</code> que devuelva exactamente lo mismo. Luego, actualiza el código donde se usaba para llamar a tu nueva extensión.</label>
</div>

??? success "👀 Ver Solución (Paso 3)"
    Creamos la extensión fuera de las clases para que sea accesible globalmente:
    
    ```kotlin
    // La nueva Extension Function
    fun Double.aFormatoNota(): String {
        return "$this pts"
    }
    
    // Así se usaría en el código del Gestor:
    // val textoVisual = alumno.notaMedia.aFormatoNota()
    ```

---

## 🚅 Paso 4: Programación Funcional al rescate

Busca la función `obtenerNombresAprobados()`. Actualmente usa una lista mutable vacía y un bucle `for` tradicional con un `if` dentro para filtrar notas >= 5.0.

<div class="codelab-task">
    <input type="checkbox" id="task-4-1">
    <label for="task-4-1"><strong>Tu tarea:</strong> Borra el bucle <code>for</code>. Aplica las transformaciones de colecciones modernas (<code>.filter</code> y <code>.map</code>) para conseguir exactamente la misma lista de nombres de aprobados de forma declarativa.</label>
</div>

??? success "👀 Ver Solución (Paso 4)"
    Encadenamos las operaciones. Primero filtramos, luego transformamos.
    
    ```kotlin
    fun obtenerNombresAprobados(): List<String> {
        return baseDeDatos
            .filter { it.notaMedia >= 5.0 }
            .map { it.nombre }
    }
    ```

---

## ⏳ Paso 5: Descongelando la App (Corrutinas)

El peor fallo de la app. Busca la función `simularCargaDeDatos()`. Verás que usa `Thread.sleep(3000)` para simular que tarda 3 segundos en conectarse al servidor. Esto está bloqueando el Hilo Principal y congelando la UI.

<div class="codelab-task">
    <input type="checkbox" id="task-5-1">
    <label for="task-5-1"><strong>Tu tarea 1:</strong> Convierte la función en una función de suspensión añadiendo la palabra clave correspondiente.</label>
</div>
<div class="codelab-task">
    <input type="checkbox" id="task-5-2">
    <label for="task-5-2"><strong>Tu tarea 2:</strong> Sustituye el bloqueante <code>Thread.sleep</code> por la función de suspensión nativa de Kotlin para esperar sin bloquear.</label>
</div>

??? success "👀 Ver Solución (Paso 5)"
    Añadimos `suspend` a la firma y usamos `delay`. Al hacer esto, la interfaz gráfica de Jetpack Compose (que ya estaba preparada en el código base) dejará de congelarse y el spinner de carga dará vueltas fluidamente.
    
    ```kotlin
    suspend fun simularCargaDeDatos(): List<AlumnoEntity> {
        // delay suspende la corrutina sin bloquear el hilo principal
        delay(3000)
        return baseDeDatos
    }
    ```

---

!!! success "🎉 ¡Reto superado!"
    Si has completado todos los pasos, vuelve a darle al "Play" en el emulador. Verás que la lista carga suavemente (el spinner se mueve sin tirones), los nulos no rompen la app y los datos se formatean correctamente.
    
    **Acabas de salvar el proyecto aplicando los cimientos del desarrollo moderno en Android.**

<div style="display: flex; justify-content: space-between; margin-top: 2rem;" markdown="span">
  [👉 Ver código resuelto en GitHub](URL_DE_TU_RAMA_SOLUTION){: .md-button }
  [Bloque Siguiente: UI Profesional ➡️](../../bloque2/inicio.md){: .md-button .md-button--primary }
</div>