# 👋 Hola Compose: La función `@Composable` y el fin de los Fragments

Imagina que quieres construir una casa. El enfoque clásico (**imperativo**) sería darle al obrero instrucciones paso a paso: *"Pon un ladrillo, pon cemento, pon otro ladrillo, levanta una pared, píntala de azul"*. Si luego quieres que la pared sea roja, tienes que buscar esa pared exacta y decirle *"quítate el azul y ponte el rojo"*.

Así era Android antes. Diseñabas la pantalla en un archivo XML y luego, desde Kotlin o Java, tenías que buscar ese botón (`findViewById`) y cambiar su texto manualmente. Era un proceso lento y propenso a errores.

El enfoque **declarativo** de Compose es diferente. Le das al obrero un plano mágico y le dices: *"Quiero una pared roja"*. Y el obrero (Compose) se encarga de construirla. Si mañana quieres que sea azul, cambias el plano a *"Quiero una pared azul"*, y Compose reconstruye solo esa parte por ti.



Para lograr esta magia, Jetpack Compose se basa en dos pilares fundamentales: `setContent` y la anotación `@Composable`.

---

## 🏛️ La Activity y el `setContent` (El Portal mágico)

¿Qué es exactamente una `Activity`? Si vienes de programar aplicaciones de escritorio (como `Java` o `C#`), piénsalo como la ventana principal (Window o JFrame) de tu programa. Una `Activity` es simplemente el contenedor básico que el sistema operativo Android necesita instanciar para poder mostrar algo en la pantalla de tu móvil y registrar los toques del usuario. Toda aplicación necesita al menos una para poder arrancar.

En el Android clásico, esa `Activity` era la encargada de casi todo el trabajo sucio. Hoy, con Compose, la `Activity` sigue siendo esa "ventana" obligatoria que el sistema abre, pero se vacía de lógica. Su única misión ahora es abrir un portal hacia nuestro nuevo mundo declarativo.

Ese portal se llama `setContent`:

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Aquí empieza la magia. 
        // Ya no cargamos un archivo XML con setContentView(R.layout.activity_main)
        setContent {
            // Todo lo que pongas dentro de estas llaves es tu Interfaz Gráfica
            Text(text = "¡Hola, ciclo de DAM!")
        }
    }
}
```

!!! info "🧠 ¿Qué está pasando aquí?"
    Al usar `setContent { }`, le estamos diciendo a Android: *"Olvida los XML. A partir de aquí, voy a dibujar la pantalla usando funciones de Kotlin"*. El bloque de código que pasas dentro es, si lo recuerdas del módulo anterior, una [**Trailing Lambda**](../modulo_1/b1-m1_2-data_class_lambdas.md#trailing-lambda-la-sintaxis-de-compose).

---

## ✨ La anotación `@Composable` (Tus nuevos ladrillos)

En el ejemplo anterior usamos `Text()`. ¿Qué es `Text`? No es una clase, ni un objeto. Es una **función**.

En Compose, la interfaz gráfica se construye creando pequeñas funciones de Kotlin que emiten píxeles a la pantalla. Para que Kotlin sepa que una función sirve para dibujar UI y no para calcular matemáticas, le ponemos la etiqueta `@Composable` justo encima.

### 💻 Creando nuestro primer componente

Vamos a sacar el texto del `setContent` para hacer nuestro código más limpio y reutilizable.

```kotlin
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text

// 1. Añadimos la anotación @Composable
// 2. IMPORTANTE: El nombre de la función empieza por MAYÚSCULA (PascalCase)
@Composable
fun MensajeBienvenida(nombreAlumno: String) {
    // Aquí dentro llamamos a otros composables que ya vienen creados por Google
    Text(text = "¡Hola, $nombreAlumno! Bienvenido a Compose.")
}

// Ahora nuestra Activity queda mucho más limpia:
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MensajeBienvenida(nombreAlumno = "Marta")
        }
    }
}
```

!!! warning "Reglas de oro de un `@Composable`"
    1. **Se escriben en PascalCase:** A diferencia de las funciones normales en Kotlin (`calcularNota()`), los Composables empiezan por mayúscula (`TarjetaAlumno()`, `BotonGuardar()`). Es una convención para distinguirlos a simple vista de la lógica de negocio.
    2. **No devuelven nada:** Fíjate que no tienen `return`. Su trabajo es "emitir" UI, no devolver datos.
    3. **Solo pueden llamarse desde otro `@Composable`:** Como si fuera un club exclusivo, una función `@Composable` solo puede ser invocada desde dentro de otra función `@Composable` (o desde el `setContent`).

---

## 🪦 El fin de los Fragments

Si has trasteado con el desarrollo clásico en Android, seguramente habrás sufrido los *Fragments*. Se inventaron para intentar reutilizar trozos de pantalla (por ejemplo, una lista que se ve en el móvil a pantalla completa, pero en una tablet se ve en la mitad izquierda).

El problema es que los Fragments tienen un ciclo de vida aterradoramente complejo y comunicarlos entre sí o con la Activity era una pesadilla propensa a *crasheos*.



**¿Por qué Compose los entierra para siempre?**
Porque en Compose, si quieres reutilizar un trozo de pantalla, simplemente creas una función `@Composable` (como nuestro `MensajeBienvenida`) y la llamas donde te dé la gana.

* ¿La quieres en una pantalla completa? Llamas a la función.
* ¿La quieres dentro de un cajón lateral? Llamas a la función.
* ¿La quieres repetir 100 veces en un bucle? Llamas a la función 100 veces.

La UI ha vuelto a ser código puro, simple y predecible.

---

Ahora que sabemos crear componentes sueltos como textos flotando en la nada, necesitamos organizarlos. ¿Cómo ponemos un texto debajo de otro o al lado de una imagen? Es hora de jugar a los bloques de Lego con los Layouts Primitivos.

<div align="right" markdown="span" style="margin-top: 2rem;" markdown="span">
  [Layouts Primitivos ➡️](b1-m2_2-layouts_primitivos.md){: .md-button .md-button--primary }
</div>