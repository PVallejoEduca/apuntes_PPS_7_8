# 0.2. Diferencias entre seguridad web y seguridad móvil

Aunque una aplicación web y una aplicación móvil puedan compartir lógica de negocio, usuarios o incluso el mismo backend, **no se auditan igual**. La razón principal es que no se ejecutan en el mismo entorno y, por tanto, tampoco exponen la misma superficie de ataque.

En este subcapítulo vamos a ver qué principios comparten, qué cambia al pasar del navegador al dispositivo móvil y por qué en móvil aparecen capas nuevas que obligan a revisar más cosas.

---

## Objetivo del subcapítulo

Entender por qué no se puede auditar una aplicación móvil exactamente igual que una web, aunque compartan parte de la lógica de negocio o del backend.

El objetivo es que el alumnado distinga:

- qué riesgos son comunes,
- cuáles cambian,
- y qué nuevas capas aparecen cuando una aplicación se ejecuta dentro de un dispositivo móvil.

---

## Punto de partida: comparten parte del problema, pero no todo

A primera vista, una aplicación web y una aplicación móvil pueden parecer muy parecidas. Las dos pueden tener:

- login
- perfiles de usuario
- operaciones sobre datos
- llamadas a un backend
- control de acceso

Incluso pueden conectarse al mismo servidor y ejecutar prácticamente las mismas funciones de negocio.

Pero, desde el punto de vista de seguridad, **no son lo mismo**.

La diferencia principal está en el **entorno de ejecución**. Una aplicación web se ejecuta principalmente dentro del navegador. En cambio, una aplicación móvil se ejecuta dentro de un sistema operativo móvil, con acceso potencial a permisos, almacenamiento local, sensores, servicios del sistema y recursos del propio dispositivo.

Eso cambia bastante la forma de auditarla.

!!! abstract "Idea clave"
    La seguridad web y la seguridad móvil comparten principios, pero **no comparten exactamente la misma superficie de ataque**.

---

## Por qué en móvil cambia la auditoría

En web, muchas revisiones se centran en aspectos como:

- entrada de datos
- sesión
- control de acceso
- cabeceras
- inyecciones
- configuración del servidor

Ese bloque ya conecta con lo trabajado en UT5 y UT6.

En móvil, además de la lógica cliente-servidor, entra en juego todo lo que ocurre **dentro del dispositivo**:

- permisos
- almacenamiento local
- trazas y registros
- binario distribuido
- integridad del paquete
- confianza entre app y backend

Dicho de forma simple, una app web suele concentrar más superficie crítica en el flujo **navegador-servidor**. Una app móvil, además de eso, distribuye parte del problema dentro de un cliente instalado que queda en manos del usuario.

Por eso, en móvil es todavía más importante recordar una regla básica: **el cliente no es fuente de verdad**.

---

## Diferencia 1. Entorno de ejecución

En web, la aplicación cliente corre dentro del navegador, que ya impone muchas reglas propias:

- política de mismo origen
- sandbox del navegador
- gestión de cookies
- almacenamiento web
- políticas de cabeceras
- CSP y mecanismos similares

En móvil, la app corre como una aplicación instalada dentro de Android o iOS. Eso significa que:

- puede pedir permisos al sistema,
- puede guardar información localmente,
- puede interactuar con más recursos del dispositivo,
- y genera un paquete binario que puede inspeccionarse.

Esto hace que la auditoría móvil no se limite a revisar pantallas y peticiones. También hay que revisar el dispositivo, los permisos y el ejecutable.

---

## Diferencia 2. Modelo de permisos

En web, normalmente no hablamos de permisos del sistema del mismo modo. El navegador puede pedir acceso a geolocalización, cámara o micrófono, sí, pero ese modelo está bastante mediado por el propio navegador y no forma parte del empaquetado de la aplicación como ocurre en móvil.

En móvil, el modelo de permisos es una capa central de seguridad.

Cuando se audita una app móvil, una de las primeras preguntas suele ser:

- qué permisos declara la app,
- cuáles obtiene realmente,
- cuándo los solicita,
- y si están justificados o no.

!!! tip "Regla práctica"
    Un permiso innecesario no es solo un detalle técnico. Es una ampliación de la superficie de ataque y, muchas veces, también un problema de privacidad.

En web esa revisión existe en algunos casos, pero no ocupa ni de lejos el mismo lugar que en móvil.

---

## Diferencia 3. Almacenamiento local

En una aplicación web suele preocupar mucho la sesión, las cookies, `localStorage`, `sessionStorage` y el tratamiento de credenciales en el navegador.

En una aplicación móvil, ese problema cambia de forma porque la app puede guardar datos en:

- preferencias
- ficheros
- bases de datos locales
- cachés
- almacenamiento temporal del sistema

Eso obliga a revisar no solo si el backend es seguro, sino también:

- dónde acaba el token,
- si se guardan datos sensibles en claro,
- si aparecen datos en logs,
- y si quedan restos de información en el dispositivo.

!!! warning "Error frecuente"
    Un backend seguro no compensa una mala gestión del almacenamiento local.  
    Si el token, el correo o datos sensibles quedan expuestos en el terminal, sigue habiendo un problema serio.

---

## Diferencia 4. Binario distribuido

Esta es una de las diferencias más importantes y también una de las que más cuesta ver al principio.

En web, gran parte del valor técnico y de la lógica de seguridad suele estar más concentrado en el servidor. El frontend puede exponer información, sí, pero el modelo de distribución es distinto.

En móvil, en cambio, distribuyes un **binario instalable**. Ese paquete puede contener:

- metadatos
- cadenas internas
- endpoints
- configuraciones sensibles
- secretos expuestos por error
- pistas sobre la lógica interna

En otras palabras, en móvil no solo auditas lo que la app hace, sino también parte de lo que la app **revela**, aunque no lo enseñe en pantalla.

---

## Diferencia 5. Firma e integridad

En web, el usuario accede a una aplicación servida desde un servidor. En móvil, instala una aplicación empaquetada.

Eso introduce una cuestión específica: la **firma del paquete** y la **integridad de la build**.

Aquí ya no basta con pensar en lógica de negocio o tráfico de red. También hay que considerar si el paquete es confiable, si ha sido manipulado o si la cadena de confianza del binario está bien planteada.

Esta capa no suele tener un equivalente tan directo en una auditoría web básica de aula.

---

## Diferencia 6. Relación con el backend

Tanto en web como en móvil existe comunicación con backend, pero en móvil hay un riesgo didácticamente muy útil de explicar: la **falsa sensación de confianza en el cliente**.

Una app móvil puede parecer cerrada, profesional y controlada, pero sigue siendo un cliente. Si una operación sensible depende solo de una comprobación local, por ejemplo desbloquear una función premium, esa lógica puede alterarse o simularse.

Esta idea puede expresarse así en clase:

- en web solemos insistir en: **no confíes en el navegador**
- en móvil debemos insistir en: **no confíes en la app cliente**

La regla de fondo es la misma, pero en móvil suele verse de forma todavía más clara.

!!! danger "Regla de seguridad"
    En operaciones sensibles, como compras, privilegios o acceso a funciones restringidas, el cliente no debe ser la única autoridad. La validación real debe recaer en el servidor.

---

## Diferencia 7. Monitorización del tráfico

En ambos mundos puede analizarse tráfico, pero el contexto cambia.

En web, muchas veces el alumnado asocia esta revisión al navegador, al proxy y a la interacción directa con formularios o endpoints visibles.

En móvil, el tráfico también puede analizarse, pero entra mezclado con otros factores:

- certificados
- configuración del cliente
- restricciones del sistema
- almacenamiento del token
- validaciones adicionales
- posibles mecanismos de *pinning*

Eso hace que revisar tráfico en móvil no sea solo mirar peticiones, sino también comprobar cómo se construye la confianza entre la app y el backend.

---

## Diferencia 8. Superficie física y contextual

Una app móvil vive en un dispositivo que acompaña al usuario y que concentra mucha información personal:

- ubicación
- notificaciones
- cámara
- almacenamiento
- hábitos de uso
- datos privados

Eso hace que algunos fallos tengan una dimensión de privacidad y exposición mucho más inmediata.

En una aplicación web, una mala validación o una inyección pueden ser gravísimas. En móvil, además, aparecen con mucha fuerza riesgos como:

- filtrado de datos personales desde el terminal
- fugas por logs
- capturas de pantalla
- copias de seguridad
- información residual en caché

Por eso, en móvil la conversación sobre seguridad se cruza muy pronto con la privacidad y con la exposición del propio dispositivo.

---

## Ejemplo: mismo servicio, distinta auditoría

Imagina el mismo servicio, una plataforma de tareas, con versión web y versión móvil.

### En la versión web

Un auditor probablemente revisará:

- validación de formularios
- control de acceso
- gestión de sesión
- cabeceras
- endpoints y roles

### En la versión móvil

Además de todo lo anterior, tendrá que revisar también:

- permisos declarados
- almacenamiento del token
- datos presentes en logs
- tráfico de red
- contenido del binario
- y si alguna función premium o sensible depende solo de lógica cliente

El negocio es el mismo, pero la auditoría **no es la misma**.

---

## Síntesis de la diferencia principal

La seguridad web y la seguridad móvil comparten fundamentos, pero no se revisan igual.

### En web suele pesar más

- el flujo navegador-servidor
- la entrada de datos
- la sesión
- el control de acceso
- la configuración del servidor

### En móvil, además, entran con mucha fuerza

- permisos
- almacenamiento local
- tráfico desde app cliente
- binario distribuido
- firma e integridad
- confianza limitada en el cliente instalado

!!! success "Conclusión"
    Una app móvil no es solo un frontend que consume un backend. También es un paquete instalable, con permisos, almacenamiento, trazas y decisiones locales que deben auditarse.

---

## Errores comunes

### Pensar que una app móvil es solo una web empaquetada

A veces comparten backend o parte del modelo, sí, pero el entorno cambia mucho y con él cambian también los riesgos.

### Creer que si el backend es seguro, la app móvil ya está bien

No. La app puede filtrar datos localmente, pedir permisos de más o exponer información sensible en el binario.

### Auditar móvil solo con mentalidad web

Eso lleva al alumnado a fijarse en formularios y peticiones, pero a olvidar:

- almacenamiento local
- paquete instalable
- integridad
- permisos
- información expuesta en el ejecutable

### Pensar que el cliente móvil merece más confianza porque está compilado

No. Que algo esté compilado no lo convierte en una fuente fiable de verdad.

---

## Preguntas clave para auditoría

Cuando se revise una app móvil, conviene hacerse al menos estas preguntas:

- ¿Qué parte del riesgo viene del backend y cuál viene del dispositivo?
- ¿Qué permisos usa la app y para qué?
- ¿Qué deja guardado localmente?
- ¿Qué revela el binario?
- ¿Qué decisiones críticas se están tomando en el cliente en lugar de en el servidor?

Si el alumnado entiende estas preguntas, empieza a dejar de auditar la app móvil como si fuera una simple web con icono.

---

## Mini resumen para el alumnado

La seguridad web y la seguridad móvil comparten fundamentos, pero no se analizan igual.

En web importa mucho el navegador, la sesión, las entradas, las cabeceras y el servidor. En móvil, además, hay que revisar permisos, almacenamiento local, tráfico, binario, firma e integridad.

La diferencia clave es que una app móvil vive instalada en el dispositivo del usuario y, por tanto, expone capas nuevas que en web no tienen el mismo peso.

---

## Frase docente útil para clase

> “Una app móvil no es solo un frontend bonito que llama a un backend; es también un paquete instalable, con permisos, almacenamiento, trazas y decisiones locales que hay que auditar.”