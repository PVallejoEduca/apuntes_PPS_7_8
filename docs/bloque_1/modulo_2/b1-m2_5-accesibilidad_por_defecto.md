# Accesibilidad por defecto: Apps para todo el mundo ♿

Llegamos a un punto que muchos desarrolladores novatos ignoran, pero que separa a un programador *amateur* de un profesional: La **Accesibilidad** (a11y).

Imagínate usar tu móvil con los ojos cerrados. Así es como interactúan con sus dispositivos millones de personas con discapacidad visual, utilizando un lector de pantalla nativo de Android llamado **TalkBack**. TalkBack lee en voz alta los elementos que hay en la pantalla y permite al usuario navegar deslizando el dedo de un elemento a otro.

Si construyes tu interfaz gráfica y no le das pistas a TalkBack sobre qué es cada cosa, tu aplicación será un muro de silencio inutilizable. Afortunadamente, Jetpack Compose está diseñado para obligarte a pensar en la accesibilidad desde la primera línea de código.

---

## El guardián obligatorio: `contentDescription`

Si intentas añadir un icono (`Icon`) o una imagen (`Image`) en Compose, el autocompletado de Android Studio te exigirá que rellenes un parámetro llamado `contentDescription` (Descripción del contenido). **No es opcional.**

Este es el texto que TalkBack leerá en voz alta cuando el usuario pase el dedo por encima de la imagen.



<figure markdown="span">
  <figcaption>Figura 1: Cuando TalkBack está activado, un recuadro verde envuelve el elemento seleccionado y el sistema lee su <code>contentDescription</code>.</figcaption>
</figure>

### 💻 El Código: ¿Qué texto pongo?

La regla es sencilla: si la imagen aporta información, descríbela. Si la imagen es puramente decorativa (un fondo de estrellas o un icono que ya tiene texto al lado), dile a Compose que la ignore pasándole un `null`.

```kotlin
@Composable
fun PerfilUsuario() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        
        // CASO A: Imagen importante (Aporta información)
        Image(
            painter = painterResource(id = R.drawable.foto_perfil),
            contentDescription = "Foto de perfil de Ana García" // TalkBack leerá esto
        )

        Spacer(modifier = Modifier.width(16.dp))

        // CASO B: Icono decorativo (El texto ya dice lo que hace)
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = null // TalkBack saltará este icono en silencio
        )
        Text(text = "Enviar mensaje") // TalkBack leerá el texto directamente
    }
}
```

---

## El modificador `semantics`: Agrupando información

A veces, Compose y TalkBack son "demasiado listos". Si tienes una tarjeta compleja con un título, un subtítulo y una fecha, TalkBack obligará al usuario a deslizar el dedo tres veces para leer cada trozo de texto por separado. Esto es muy frustrante.

Podemos usar el modificador `.semantics { }` para tomar el control y decirle a TalkBack: *"Oye, todo lo que hay dentro de esta caja es un solo bloque lógico. Léelo todo junto"*.



### 💻 El Código: Agrupando elementos con `mergeDescendants`

```kotlin
@Composable
fun TarjetaArticulo() {
    // Usamos semantics para fusionar los textos internos en un solo elemento accesible
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .semantics(mergeDescendants = true) {} // 👈 La magia de la accesibilidad
            .clickable { /* Abrir artículo */ }
    ) {
        Text(
            text = "Cómo dominar Jetpack Compose",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Publicado hace 2 horas",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
```

!!! success "💡 El resultado profesional"
    Sin `mergeDescendants`, el usuario tendría que hacer dos gestos distintos para escuchar el título y luego la fecha. Al fusionarlo, cuando el usuario toque la tarjeta, TalkBack dirá de una sola vez: *"Cómo dominar Jetpack Compose. Publicado hace 2 horas. Tocar dos veces para activar"*.

---

!!! success "🎉 ¡Fin del Módulo 2 (Compose Essentials)!"
    Acabas de asentar las bases del desarrollo visual moderno en Android.
    
    * ✅ Sabes que la interfaz se crea con funciones `@Composable`.
    * ✅ Sabes apilar cajas con `Column`, `Row` y `Box`.
    * ✅ Sabes aplicar estilo con los `Modifiers` (recordando siempre la regla del orden).
    * ✅ Sabes diseñar en vivo con las `@Preview`.
    * ✅ Sabes cómo hacer que tu app sea accesible para todos.
    
    Pero la teoría sin ensuciarse las manos no sirve de nada. Es hora de poner a prueba todo lo que has aprendido creando tu primera pantalla real desde cero.

<div style="display: flex; justify-content: space-between; margin-top: 2rem;" markdown="span">
  [⬅️ Volver a Preview & Tooling](b1-m2_4-preview_tooling.md){: .md-button }
  [👨‍💻 Ir a Práctica: Carnet de Alumno ➡️](b1-m2-practica.md){: .md-button .md-button--primary }
</div>