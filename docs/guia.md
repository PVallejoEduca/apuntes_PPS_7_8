---
hide:
  - navigation
---

# Guía de Referencia y Formato

Esta página sirve como plantilla para ver todos los componentes visuales e interactivos que podemos utilizar en nuestros apuntes.

Recuerda que al ser archivos Markdown, puedes pegar código HTML puro con ```<style></style>``` o ```<script></script>``` en cualquier parte de un archivo .md y el navegador lo ejecutará (ideal para montar un componente aislado en una sola lección).

---

## 1. Enlaces y Navegación Interna

Para enlazar a otras páginas de nuestros apuntes, usamos rutas relativas. Es mucho mejor que usar URLs absolutas, ya que funcionará tanto en local como al subirlo a GitHub Pages.

* [Volver a la página de Inicio](index.md)
* [Ir a un apartado específico del Inicio](index.md#titulo-del-apartado)

---

## 2. Bloques de Advertencia (Admonitions)

Son perfectos para destacar información vital y romper la monotonía del texto. Hay varios colores por defecto según la gravedad o el tipo de nota.

!!! note "Nota informativa"
    Usa esto para dar contexto extra o aclaraciones. Fíjate que el contenido va indentado con 4 espacios.

!!! tip "Consejo práctico"
    Ideal para atajos de Android Studio o buenas prácticas de código.

!!! warning "Cuidado con esto"
    Perfecto para avisar de errores comunes (ej. olvidar declarar un permiso en el *Manifest*).

!!! danger "Peligro / Deprecation"
    Útil para marcar métodos obsoletos o acciones que rompen la compilación.

??? example "Ejemplo desplegable (¡Haz clic para abrir!)"
    Si tienes un texto muy largo o la solución a un ejercicio de clase, puedes usar `???` en lugar de `!!!` para que el bloque aparezca cerrado por defecto y no sature la pantalla.

---

## 3. Pestañas de Código (Code Tabs)

Vital para comparar tecnologías o lenguajes. El alumnado puede cambiar de pestaña sin recargar la página.

=== "Jetpack Compose"
    ```kotlin
    @Composable
    fun Saludo() {
        Text(text = "¡Hola, mundo!")
    }
    ```

=== "XML Clásico"
    ```xml
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="¡Hola, mundo!" />
    ```

---

## 4. Código con Anotaciones (Tooltips)

En lugar de poner comentarios larguísimos dentro del código, podemos añadir un `(1)!` al final de la línea. Se generará un botón `+` interactivo.

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // (1)!
            MiAppTheme { // (2)!
                Saludo()
            }
        }
    }
}
```

1. `setContent` es el puente entre el mundo clásico de Android (Activity) y el mundo declarativo de Jetpack Compose.
2. Aquí aplicamos el tema general que define colores y tipografías para toda la app.

---

## 5. Multimedia: Imágenes y GIFs

Para mantener el proyecto organizado, lo ideal es crear una carpeta `assets` o `img` dentro de `docs`. 

**Añadir una imagen con pie de foto:**
<figure markdown="span">
  ![Esquema del Ciclo de Vida](assets/ejemplo.jpg)
  <figcaption>Figura 1: Representación gráfica del ciclo de vida de un Activity.</figcaption>
</figure>



**Añadir un GIF animado (funciona exactamente igual):**
<figure markdown="span">
  ![Demostración de la animación en Compose](assets/gif.gif)
  <figcaption>GIF 1: Resultado visual tras aplicar el modificador `animateContentSize`.</figcaption>
</figure>


---

## 6. Formato de Texto Básico y Listas

A veces solo necesitamos aplicar estilos rápidos al texto sin usar componentes complejos:

* Texto en **negrita** para conceptos clave.
* Texto en *cursiva* para términos en inglés como *State Hoisting*.
* Texto ~~tachado~~ para código antiguo.
* Resaltado de código en línea para nombrar variables, como `viewModel` o `Modifier.padding()`.
* Este es un texto normal, pero este **texto es rojo**{: style="color: red;" }.

Aplica una clase a un párrafo completo:

Este párrafo entero tendrá el CSS que yo le defina, como por ejemplo un bloque de "Nota del profesor".
{: .mi-clase-personalizada }

**Listas de tareas (Ideales para prácticas):**

- [x] Configurar dependencias en `build.gradle.kts`.
- [ ] Sincronizar el proyecto con Gradle.
- [ ] Ejecutar en el emulador.

**Teclas de atajo:**
Para ejecutar la app rápidamente pulsa <kbd>Shift</kbd> + <kbd>F10</kbd>.

---

## 7. Tablas de Datos

Las tablas se construyen usando barras verticales (`|`) para separar las columnas y guiones (`-`) para separar la cabecera del contenido. Puedes usar dos puntos (`:`) para alinear el texto a la izquierda, a la derecha o al centro.

**Ejemplo: Modificadores más comunes en Compose**

| Modificador | Descripción | Equivalente clásico (XML) |
| :--- | :--- | :--- |
| `Modifier.padding()` | Añade espacio exterior o interior al elemento. | `android:padding` / `margin` |
| `Modifier.fillMaxSize()` | Obliga al componente a ocupar todo el espacio disponible. | `match_parent` |
| `Modifier.clickable { }` | Hace que el elemento responda a los eventos táctiles del usuario. | `android:onClick` |
| `Modifier.background()` | Define el color, gradiente o forma geométrica del fondo. | `android:background` |
| `Modifier.weight()` | Distribuye el espacio sobrante proporcionalmente en *Rows* o *Columns*. | `android:layout_weight` |

Fíjate en la segunda línea de la tabla (| :--- | :--- | :--- |).
Los dos puntos a la izquierda (:---) indican que toda esa columna se alineará a la izquierda.
Si quisieras centrar el texto de una columna, usarías dos puntos a ambos lados: :---:.
Para alinear a la derecha, los pones al final: ---:.