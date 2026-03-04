# Práctica: Maquetando el Carnet del Alumno 🪪

¡Es hora de mancharse las manos de código visual! Tu centro de Formación Profesional te ha encargado digitalizar el Carnet de Estudiante de los alumnos de DAM.



El diseñador te ha pasado un boceto con los siguientes requisitos:

* Una tarjeta rectangular con bordes redondeados y un color de fondo suave.
* A la izquierda, la foto de perfil del alumno.
* Superpuesto en la esquina inferior derecha de la foto, un puntito verde que indica que el alumno está "Activo/Matriculado".
* A la derecha de la foto, apilados verticalmente: el nombre del alumno, el nombre del ciclo ("DAM") y el DNI.
* El carnet debe ser accesible para lectores de pantalla.

!!! abstract "🎯 Tu misión"
    Descargar el código base y usar tus conocimientos de `Column`, `Row`, `Box` y `Modifiers` para construir esta interfaz **sin encender el emulador**.

---

## Preparar el entorno

<div class="codelab-task">
    <input type="checkbox" id="m2-task-0-1">
    <label for="m2-task-0-1">Ve a nuestro <a href="https://github.com/Mikel-Jorge/Android-Jetpack_Compose_Tutorial/tree/main/code/bloque_1/modulo_2/b1-m2-p_starter-code" target="_blank">repositorio de GitHub</a> y descarga la rama <code>starter-code</code>.</label>
</div>
<div class="codelab-task">
    <input type="checkbox" id="m2-task-0-2">
    <label for="m2-task-0-2">Ábrelo en Android Studio.</label>
</div>
<div class="codelab-task">
    <input type="checkbox" id="m2-task-0-3">
    <label for="m2-task-0-3">Abre el archivo <code>CarnetAlumno.kt</code>. Verás que están las funciones vacías y varios comentarios <code>// TODO</code>. ¡No le des al Play al emulador! Vas a trabajar exclusivamente usando la vista de Preview en tiempo real.</label>
</div>

---

## Encendiendo las luces (Preview)

Actualmente, no puedes ver nada porque falta la vista previa.

<div class="codelab-task">
    <input type="checkbox" id="m2-task-1-1">
    <label for="m2-task-1-1"><strong>Tu tarea:</strong> Crea una función llamada <code>CarnetPreview()</code>. Añádele la etiqueta necesaria para que Android Studio la reconozca como vista de diseño. Llama dentro a la función <code>CarnetAlumno()</code> pasándole datos falsos (tu nombre, DNI, etc.).</label>
</div>

??? tip "Necesito una pista"
    Recuerda que la función de *preview* no puede recibir parámetros y suele llevar el argumento `showBackground = true` en su anotación.

---

## El Contenedor Principal (Cuidado con el orden)

Vamos a crear la tarjeta exterior.

<div class="codelab-task">
    <input type="checkbox" id="m2-task-2-1">
    <label for="m2-task-2-1"><strong>Tu tarea:</strong> En la función principal <code>CarnetAlumno()</code>, añade un contenedor <code>Box</code> o <code>Row</code> (piensa cuál te conviene más para colocar la foto a la izquierda y el texto a la derecha). Aplícale un <code>Modifier</code> para que ocupe todo el ancho disponible (<code>fillMaxWidth</code>), tenga un padding exterior de <code>16.dp</code>, un fondo de un color claro (ej: <code>Color.LightGray</code>) y las esquinas redondeadas (<code>RoundedCornerShape</code>).</label>
</div>

??? tip "Pista sobre el orden"
    ¡Cuidado con la Regla de Oro! Si pones el `background` antes que el recorte de las esquinas (`clip`), el fondo se pintará cuadrado y luego se recortará. Si pones el `padding` después del `background`, el margen se aplicará por dentro, no por fuera. Piensa bien el orden secuencial.

---

## La Foto y el "Badge" Activo (Eje Z)

Aquí vamos a jugar con la profundidad.



<div class="codelab-task">
    <input type="checkbox" id="m2-task-3-1">
    <label for="m2-task-3-1"><strong>Tu tarea:</strong> Dentro de tu contenedor principal, necesitas colocar un icono o imagen que represente al usuario. Y encima de ese icono, en la esquina inferior derecha, un circulito verde más pequeño.</label>
</div>

??? tip "Pistas de Layout y Accesibilidad"
    * **Layout:** Para poner cosas una encima de otra, necesitas el layout primitivo del Eje Z (`Box`). Usa el modificador `align(Alignment.BottomEnd)` en el puntito verde para clavarlo en la esquina.
    * **Accesibilidad:** ¡No te olvides del `contentDescription` en la imagen de perfil! El puntito verde, sin embargo, puede llevar un `null` si el lector ya va a leer que el alumno está activo en otro lado, o puedes ponerle *"Alumno activo"*.

---

## Apilando los datos (Eje Y)

Ya tenemos la foto a la izquierda. Ahora, a su derecha, necesitamos el texto.

<div class="codelab-task">
    <input type="checkbox" id="m2-task-4-1">
    <label for="m2-task-4-1"><strong>Tu tarea:</strong> Crea un layout que apile textos uno debajo del otro. Muestra el Nombre, el Ciclo (hardcodeado a "DAM") y el DNI.</label>
</div>

??? tip "Pista de espaciado"
    Para que el texto no se pegue a la foto, aplícale un `padding` a este nuevo contenedor vertical, o pon un `Spacer(modifier = Modifier.width(16.dp))` entre la foto y los textos.

---

## Accesibilidad Semántica

Si dejas la tarjeta así, TalkBack leerá: *"Marta Ruiz"... (deslizas)... "DAM"... (deslizas)... "12345678Z"*. Es muy molesto.

<div class="codelab-task">
    <input type="checkbox" id="m2-task-5-1">
    <label for="m2-task-5-1"><strong>Tu tarea:</strong> Agrupa toda la tarjeta para que el lector de pantalla la considere un solo elemento interactivo.</label>
</div>

??? tip "Pista de semántica"
    Busca el modificador `.semantics { ... }` que aprendimos en la lección 2.5 y aplícalo en el contenedor más exterior (el del Paso 2) usando `mergeDescendants = true`.

---

<div style="display: flex; justify-content: space-around; margin-top: 1rem;" markdown="span">
  [💻 Ver código resuelto en GitHub](https://github.com/Mikel-Jorge/Android-Jetpack_Compose_Tutorial/tree/main/code/bloque_1/modulo_2/b1-m2-p_solution-code){: .md-button }
</div>

---

!!! success "🎉 ¡Reto superado!"
    Si ves en tu panel lateral de Android Studio una tarjeta bonita, estructurada, y al cambiar el orden de los Modifiers entiendes por qué se rompen los márgenes... ¡Felicidades! Acabas de "programar" tu primera interfaz gráfica nativa y moderna.

<div style="display: flex; justify-content: space-between; margin-top: 2rem;" markdown="span">
  [⬅️ Volver a Accesibilidad](b1-m2_5-accesibilidad_por_defecto.md){: .md-button }
  [🚀 Siguiente Módulo: Componentes Material ➡️](../modulo_3/b1-m3-inicio.md){: .md-button .md-button--primary }
</div>
