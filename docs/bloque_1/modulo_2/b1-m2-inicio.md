---
hide:
  - toc
---

# El Despertar Declarativo

!!! abstract "Objetivo del módulo"
    Entender de una vez por todas que la interfaz de usuario (UI) se "programa" con código, no se "dibuja" arrastrando botones en un archivo XML.

Olvida todo lo que te han contado sobre cómo se hacen las pantallas en Android. Durante más de diez años, los desarrolladores tuvimos que usar archivos XML interminables para diseñar y luego conectarlos con Java de forma torpe y propensa a errores (los famosos *Fragments*).

Esa era ha terminado.

Bienvenido a **Jetpack Compose**, el kit de herramientas moderno y nativo de Android para crear interfaces. A partir de ahora, tu pantalla y tu lógica hablarán el mismo idioma: **Kotlin**. Si sabes programar una función, sabes crear una pantalla.



!!! success "💡 ¿Qué vas a dominar aquí?"
    Aprenderás el nuevo modelo mental "declarativo". En lugar de decirle a la pantalla *cómo* dibujarse paso a paso, le dirás *qué* quieres que muestre. Apilaremos cajas, filas y columnas, aprenderemos a darles estilo con los `Modifiers` y veremos los resultados en tiempo real sin necesidad de encender el emulador.

---

## 🗂️ Contenidos del Módulo

A lo largo de este módulo trabajaremos los siguientes conceptos clave. Haz clic en cada uno para acceder a la lección:

* [**Hola Compose**](b1-m2_1-hola_compose.md): Tu primera pantalla moderna. Descubriremos la anotación mágica `@Composable`, entenderemos qué hace `setContent` y celebraremos el fin absoluto de los Fragments.
* [**Layouts Primitivos**](b1-m2_2-layouts_primitivos.md): `Column`, `Row`, `Box`. El Lego de Android. Aprenderemos el modelo mental de construir cualquier diseño complejo simplemente apilando cajas de forma horizontal, vertical o superpuesta.
* [**Modifiers (La Magia)**](b1-m2_3-modifiers.md): Cómo darle vida y estilo a las cajas (márgenes, tamaños, colores y clics). Aprenderás la regla de oro de Compose: **el orden de los modificadores altera el producto final**.
* [**Preview & Tooling**](b1-m2_4-preview_tooling.md): ¿Cansado de esperar a que compile el emulador para ver si un botón ha quedado bien alineado? Aprenderemos a usar las herramientas de diseño en tiempo real y el modo interactivo.
* [**Accesibilidad por defecto**](b1-m2_5-accesibilidad_por_defecto.md): Un buen desarrollador hace apps para todos. Veremos cómo usar `contentDescription` en imágenes y los modificadores de `semantics` para garantizar que la app sea usable mediante lectores de pantalla como TalkBack.

---

## 🚀 ¿Todo listo para el cambio de chip?

Prepárate para borrar los XML de tu memoria. Vamos a escribir nuestra primera función visual y a entender por qué el mundo Android está tan enamorado de Compose.

<div style="display: flex; justify-content: space-between; margin-top: 2rem;" markdown="span">
  [⬅️ Volver al Bloque 1](../b1-inicio.md){: .md-button }
  [Empezar: Hola Compose ➡️](b1-m2_1-hola_compose.md){: .md-button .md-button--primary }
</div>