# 0.1. Qué se entiende por seguridad en aplicaciones móviles

En este subcapítulo vamos a fijar una idea base que atraviesa todo el bloque de seguridad móvil: **una aplicación no es segura solo porque funcione bien**. Una app puede arrancar, responder correctamente y ofrecer una buena experiencia de uso, y aun así exponer datos, permitir manipulaciones o confiar en elementos que no debería.

El objetivo aquí es entender qué significa realmente que una app móvil sea segura, qué activos protege, qué amenazas son habituales en este entorno y por qué la seguridad debe analizarse por capas.

---

## Objetivo del subcapítulo

Entender qué significa que una aplicación móvil sea segura, qué activos protege, qué riesgos son habituales en este entorno y por qué la seguridad móvil no consiste solo en que la app funcione o en que no tenga virus.

Este punto sirve como **base conceptual** para todo el bloque móvil de UT7 y UT8.

---

## Qué significa que una app móvil sea segura

Cuando hablamos de seguridad en aplicaciones móviles no nos referimos únicamente a evitar que alguien *hackee* la app. Hablamos de **diseñar, desarrollar, configurar y desplegar** una aplicación de forma que proteja la información, las operaciones y la confianza del usuario frente a errores, abusos, fugas o manipulaciones.

Una app móvil segura debe proteger, como mínimo, estas cuatro dimensiones:

### Confidencialidad

La información sensible no debe quedar expuesta a quien no corresponda.

Por ejemplo, no deberían poder leerse en claro:

* tokens de sesión
* direcciones de correo
* ubicaciones
* historiales de compras
* contraseñas

La exposición puede ocurrir en varios puntos: en el dispositivo, en el tráfico de red o incluso dentro del propio binario.

### Integridad

Los datos y la lógica de negocio no deben alterarse de forma ilegítima.

Un caso clásico es una compra integrada validada solo en cliente. La app puede mostrar que el usuario ha comprado una funcionalidad, pero si el servidor no lo comprueba, esa operación puede manipularse.

### Autenticidad

La app debe poder confiar en tres cosas:

* quién es el usuario
* con qué backend se está comunicando
* qué binario se está ejecutando

Si esa cadena de confianza falla, pueden aparecer suplantaciones, tráfico interceptado o builds manipuladas.

### Disponibilidad

La aplicación debe seguir prestando el servicio esperado y no fallar por errores evitables de configuración, almacenamiento o comunicación.

!!! abstract "Idea clave"
    La seguridad en aplicaciones móviles no consiste solo en proteger el código. Consiste en proteger **datos, operaciones, comunicaciones y confianza** a lo largo de todo el ciclo de vida de la app y durante su ejecución en el dispositivo.

---

## Por qué la seguridad móvil tiene particularidades

En móvil hay un factor que complica bastante el escenario: **el dispositivo no es un entorno neutro**.

La aplicación vive dentro de un sistema operativo que:

* concede permisos
* comparte recursos con otras apps
* mantiene cachés
* guarda registros
* permite copias de seguridad
* gestiona portapapeles y servicios del sistema

Eso significa que una mala decisión de seguridad no afecta solo al código de la app, sino también al entorno donde ese código se ejecuta.

Por eso, la seguridad móvil debe entenderse como una combinación de capas.

## Capas que hay que revisar

Al analizar la seguridad de una app móvil conviene revisar, al menos, estas capas:

* seguridad de permisos
* seguridad del almacenamiento local
* seguridad de la comunicación de red
* seguridad del binario y su integridad
* seguridad de la lógica de negocio
* seguridad del backend que valida lo que la app hace

Dicho de forma simple, una app móvil segura no es la que **parece segura**, sino la que resiste una revisión razonable en todas estas capas.

!!! tip "Conexión con el módulo"
    Este enfoque encaja directamente con el currículo del módulo 5023, porque el **RA4** exige detectar problemas de seguridad en apps móviles mediante el análisis de permisos, almacenamiento, validación *server-side* de compras, tráfico y binarios.
    Además, en la guía operativa de la asignatura este planteamiento se reparte entre **UT7** y **UT8**:

    * **UT7**: permisos, almacenamiento y tráfico
    * **UT8**: binarios, firmas y compras *in-app*

---

## Qué activos protege una app móvil

Una app móvil puede manejar muchos activos sensibles. Algunos son evidentes y otros pasan más desapercibidos.

### Activos típicos

* credenciales de acceso
* tokens de sesión
* datos personales
* ubicación
* historiales de uso
* mensajes o contenido privado
* recibos de compra
* identificadores internos
* endpoints expuestos por error
* claves incluidas accidentalmente
* lógica de negocio asociada a funciones premium o restringidas

!!! warning "Error frecuente"
    Un error muy habitual es pensar que solo son sensibles las contraseñas.
    No es así. A veces un simple token, una URL interna o un log con demasiada información ya suponen un problema serio.

---

## Qué amenazas son habituales en una app móvil

En este módulo no interesa empezar por amenazas muy sofisticadas o improbables. Interesan las que conectan directamente con el **RA4** y con lo que después se va a auditar en prácticas o proyectos.

### Amenazas típicas

* permisos excesivos o mal solicitados
* almacenamiento de datos sensibles en claro
* fuga de información en logs o caché
* tráfico inseguro o mal validado
* confianza excesiva en el cliente
* validaciones críticas hechas fuera del servidor
* secretos embebidos en el binario
* información útil para un atacante presente en el ejecutable

Este enfoque desplaza la mirada desde el clásico *“buscar cosas raras”* hacia una revisión más útil: **comprobar capas concretas con criterio**.

---

## Ejemplo: una app que funciona, pero no es segura

Imagina una app de notas personales con inicio de sesión.

La aplicación funciona correctamente. Permite autenticarse, guardar notas y sincronizarlas con un backend. A simple vista, parece una app válida. Sin embargo, al revisarla aparecen estos problemas:

* guarda el token en una preferencia en claro
* registra en logs el correo del usuario y respuestas del servidor
* realiza una petición por HTTP en una parte secundaria
* incluye una URL interna en el binario
* pide acceso a almacenamiento externo sin necesitarlo

La app funciona, sí. Pero **no es una app segura**.

Y esa diferencia es precisamente una de las ideas que el alumnado debe aprender a detectar en estas unidades.

---

## Diferencia entre app funcional y app segura

### Una app funcional

Una app funcional:

* cumple la tarea esperada
* responde al usuario
* puede ofrecer una buena demo
* no necesariamente protege bien los datos ni la lógica

### Una app segura

Una app segura, además de funcionar:

* minimiza la exposición
* protege activos sensibles
* valida correctamente operaciones críticas
* reduce la superficie de ataque
* no confía ciegamente en el cliente

!!! note "Idea para insistir en clase"
    Conviene repetir esta diferencia con frecuencia, porque muchos estudiantes tienden a valorar más que **la demo vaya bien** que cómo está resuelta por dentro.

---

## Errores comunes al entender la seguridad móvil

Hay varias ideas equivocadas que aparecen mucho al empezar este bloque.

### Pensar que la seguridad es solo cifrar

El cifrado ayuda, pero no corrige por sí solo:

* permisos mal planteados
* validaciones de negocio mal ubicadas
* secretos hardcodeados
* exposición de datos en otras capas

### Pensar que usar HTTPS lo resuelve todo

HTTPS protege el canal de comunicación, pero no evita otros problemas como:

* confianza excesiva en el cliente
* datos expuestos en logs
* validaciones críticas mal resueltas
* fugas desde almacenamiento local

### Confundir seguridad con aspecto profesional

Que una app tenga una interfaz cuidada, buena navegación o una experiencia pulida no dice nada sobre su seguridad real.

### Pensar que lo que está en el móvil del usuario ya es privado

No necesariamente. Muchas fugas ocurren precisamente en el dispositivo, por ejemplo en:

* almacenamiento local
* cachés
* registros
* copias de seguridad
* binarios analizados

### Creer que el cliente puede ser fuente de verdad

En operaciones sensibles, como compras, privilegios o acceso a funciones restringidas, el cliente **nunca** debería ser la única autoridad.

!!! danger "Regla práctica"
    En operaciones críticas, el cliente puede **solicitar** o **mostrar**, pero la validación real debe hacerse en el servidor.

---

## Preguntas clave para una auditoría básica

Cuando el alumnado empiece a auditar una app móvil, este subcapítulo debería dejarle al menos estas preguntas en la cabeza:

* ¿Qué datos sensibles maneja esta app?
* ¿Dónde los guarda?
* ¿Por dónde circulan?
* ¿Qué permisos usa y por qué?
* ¿Qué operaciones no deberían confiar solo en el cliente?
* ¿Qué parte del binario puede revelar información útil?
* ¿Qué decisiones afectan a la confianza entre app y backend?

Si alguien sale de este bloque con estas preguntas, ya no entra al proyecto final a ciegas.

---

## Mini resumen para el alumnado

La seguridad en aplicaciones móviles consiste en proteger **datos, operaciones y comunicaciones** frente a fugas, abusos o manipulaciones.

No basta con que la app funcione. Una app segura debe:

* controlar bien los permisos
* proteger el almacenamiento local
* usar comunicaciones seguras
* no exponer información sensible en el binario
* no confiar ciegamente en el cliente para operaciones críticas

---

## Glosario mínimo

### Confidencialidad

Garantía de que la información solo la ven quienes deben verla.

### Integridad

Garantía de que los datos o procesos no se alteran indebidamente.

### Autenticidad

Garantía de que usuarios, sistemas o componentes son quienes dicen ser.

### Disponibilidad

Capacidad de la aplicación para seguir prestando servicio.

### Activo

Elemento valioso que debe protegerse, como un dato, una clave o una operación de negocio.

### Superficie de ataque

Conjunto de puntos por los que una app puede ser analizada, abusada o comprometida.

---

## Frase docente útil para clase

> “Que una app funcione no significa que sea segura; significa solo que hace lo que se ve. La seguridad obliga a revisar también lo que no se ve.”
