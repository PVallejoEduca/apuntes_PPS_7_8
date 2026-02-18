# Val vs Var & Null Safety: El fin de los "Crasheos"

Bienvenidos a vuestra primera línea de código en Kotlin. Si venís de Java, estáis acostumbrados a ser muy explícitos: `String nombre = "Juan";`. **En Kotlin, el compilador es muy listo y adivina los tipos por ti**. Pero a cambio, te va a obligar a tomar dos decisiones críticas cada vez que crees una variable: **¿Va a cambiar su valor?** y **¿Puede llegar a estar vacía (ser nula)?**

Vamos a desterrar el famoso `NullPointerException` (el error que más apps cierra en el mundo) de nuestro día a día.

---

## `val` vs `var`: La inmutabilidad por bandera

En Kotlin, no empezamos declarando el tipo de dato (como `int` o `String`). Empezamos declarando la "intención" de esa variable usando `val` o `var`.

* **`var` (Variable):** Su valor puede cambiar en el futuro. Es la variable clásica de toda la vida.
* **`val` (Value/Valor):** Es inmutable. Una vez que le asignas un valor, no puede cambiar nunca más (es el equivalente a `final` en Java, una constante).

```kotlin
fun main() {
    // Usamos 'var' porque la edad cambia cada año
    var edad = 20
    edad = 21 // ✅ Perfecto, el compilador lo permite

    // Usamos 'val' porque el DNI no cambia nunca
    val dni = "12345678A"
    // dni = "87654321B" // ❌ ERROR DE COMPILACIÓN: Val cannot be reassigned

    // Fíjate que no hemos escrito la palabra 'String' ni 'Int'. 
    // Kotlin lo infiere automáticamente, pero si quieres ser explícito, se hace así:
    val ciudad: String = "Pamplona"
}
```

!!! note "La Regla de Oro en Android Moderno"
    En Jetpack Compose (el entorno visual que usaremos), la inmutabilidad es clave. **Acostúmbrate a usar SIEMPRE `val` por defecto**. Solo cuando el compilador te dé un error porque necesitas modificar ese dato más adelante, cámbialo a `var`. Un código con muchos `val` es un código predecible y sin efectos secundarios.

---

## Null Safety: El sistema antitontos de Kotlin

En Java, cualquier objeto puede ser `null`. Tú intentas acceder a `usuario.getNombre()` y, si el usuario era nulo, la aplicación explota y se cierra de golpe (`NullPointerException`).

En Kotlin, los nulos están **prohibidos por defecto**. Si intentas asignar un `null` a una variable normal, el programa ni siquiera te dejará compilar (no te dejará darle al botón de *Play*).



```kotlin
// 1. Variable NO nula (Por defecto)
var nombre: String = "Marta"
// nombre = null // ❌ ERROR: Null can not be a value of a non-null type String

// 2. Variable NULA (Añadimos el símbolo '?')
// Solo si estamos 100% seguros de que necesitamos que algo pueda estar vacío:
var segundoApellido: String? = "García"
segundoApellido = null // ✅ OK: Kotlin sabe que esto puede estar vacío
```

---

## Safe Call (`?.`): Navegación Segura

Imagina que tenemos esa variable `segundoApellido` que permitimos que fuera nula (`String?`). Si ahora intentamos saber cuántas letras tiene (`segundoApellido.length`), Kotlin nos dará un tortazo en la mano y nos dirá: *"¡Eh! Que esto podría ser nulo, te vas a estrellar"*.

Para solucionarlo, usamos el **Safe Call (`?.`)**.

```kotlin
var correo: String? = null

/*  En Java haríamos un if enorme:
    if (correo != null) {
       return correo.length();
    } else {
        return null;
    }
*/

// En Kotlin, el Safe Call lo hace en dos caracteres:
val longitud = correo?.length // (1)!

println(longitud) // Imprime: null
```

1. **Explicación:** Si `correo` tiene texto, te da la longitud. Si `correo` es `null`, toda la expresión devuelve `null` en lugar de romper la app.

---

## Operador Elvis (`?:`): El Plan B

El Safe Call está muy bien, pero a veces no queremos que el resultado final sea `null`. Queremos un **valor por defecto**.

Aquí entra el maravilloso **Operador Elvis (`?:`)**. Se llama así porque si giras la cabeza 90 grados a la izquierda, parece el tupé de Elvis Presley 🕺. Su función es simple: *"Usa lo de la izquierda, pero si es nulo, usa lo de la derecha"*.



```kotlin
var inputDelUsuario: String? = null // El usuario no escribió nada

// Leemos la longitud del texto. 
// Si inputDelUsuario es nulo, el Elvis '?:' entra en acción y le asigna un 0.
val longitudSegura: Int = inputDelUsuario?.length ?: 0 // (1)!

println("Has escrito $longitudSegura caracteres.") // Imprime: Has escrito 0 caracteres.
```

1. El operador evalúa primero lo de la izquierda. Como en este caso es nulo, automáticamente salta a la derecha y asigna el valor `0`.

---

## Choque Cultural: Java vs Kotlin

Para que aprecies lo que acabas de aprender, mira cómo se haría exactamente lo mismo en ambos lenguajes:

=== "🚀 Kotlin"
    ```kotlin
    val inputDelUsuario: String? = null
    val longitudSegura = inputDelUsuario?.length ?: 0
    ```

=== "☕ Java"
    ```java
    String inputDelUsuario = null;
    int longitudSegura;
    
    if (inputDelUsuario != null) {
        longitudSegura = inputDelUsuario.length();
    } else {
        longitudSegura = 0;
    }
    ```

*(De 7 líneas de código a 2, y con 0% de posibilidades de que la app se cierre por un error de nulo).*

---

Ahora que sabemos crear variables a prueba de bombas y hemos enterrado los errores nulos, vamos a ver cómo Kotlin revoluciona la forma de crear objetos y pasar funciones de un lado a otro.

<div align="right" markdown="span" style="margin-top: 2rem;">
  [Data Classes & Lambdas ➡️](b1-m1_2-data_class_lambdas.md){: .md-button .md-button--primary }
</div>