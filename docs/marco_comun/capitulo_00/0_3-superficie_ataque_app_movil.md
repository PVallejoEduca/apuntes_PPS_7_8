# 0.3. Superficie de ataque de una app móvil

Una app móvil no se reduce a una pantalla y un botón de login. Aunque desde fuera parezca una aplicación sencilla, por dentro puede apoyarse en permisos, almacenamiento local, tráfico de red, binarios, servicios externos y decisiones de negocio que amplían mucho su exposición.

Por eso, antes de buscar fallos concretos, conviene entender una idea previa: **por dónde puede fallar la app**. Ese mapa de zonas expuestas es lo que llamamos **superficie de ataque**.

---

## Objetivo del subcapítulo

Comprender qué se entiende por superficie de ataque en una aplicación móvil, qué zonas la componen, por qué una app móvil tiene varios puntos de exposición distintos y cómo esta idea permite auditar con método en lugar de revisar *“a ver qué encuentro”*.

---

## Qué es la superficie de ataque

La superficie de ataque de una app móvil es el conjunto de puntos, componentes, flujos y decisiones técnicas que pueden ser observados, abusados, manipulados o utilizados para obtener información sensible o para ejecutar acciones no previstas.

Dicho de forma más simple, es **todo aquello por donde una app puede “romperse” desde el punto de vista de seguridad**.

Una app móvil tiene varias capas que forman parte de esa superficie:

- la interfaz
- el código cliente
- el sistema operativo
- los permisos
- el almacenamiento local
- la comunicación de red
- el backend
- el binario distribuido
- y, en algunos casos, lógica de negocio especialmente sensible, como compras integradas o privilegios premium

Cada una de esas capas añade puntos de exposición.

!!! abstract "Idea base"
    Cuanto más puede hacer una app, cuanto más datos toca, cuanto más guarda, cuanto más comunica y cuanto más decide localmente, **mayor es su superficie de ataque**.

Eso no significa que toda app compleja sea insegura. Significa que una app más compleja necesita **más control, más revisión y más criterio de diseño**.

---

## Por qué esta idea es importante al auditar

Muchos estudiantes, al empezar, piensan que una auditoría consiste en tocar la interfaz y probar cosas al azar. Pero una revisión seria no empieza por *“a ver qué pasa si pulso aquí”*.

Empieza con una pregunta más útil:

> **¿Por dónde puede exponer riesgo esta app?**

Esa pregunta es precisamente la idea de superficie de ataque.

Cuando se entiende bien, deja de verse la auditoría como una búsqueda desordenada y empieza a verse como una revisión por capas.

!!! tip "Relación con UT7 y UT8"
    En el bloque móvil del módulo, esta idea encaja de forma directa:
    
    - **UT7** revisa permisos, almacenamiento y tráfico.
    - **UT8** revisa binarios, integridad y compras *in-app*.
    
    En el fondo, ambas unidades estudian **zonas distintas de la superficie de ataque de una misma app móvil**.

---

## Qué partes forman la superficie de ataque de una app móvil

## 1. Interfaz y entradas de usuario

Toda pantalla, formulario, botón, parámetro, selector o campo editable forma parte de la superficie de ataque.

Cada vez que el usuario introduce un dato o activa una acción, aparece una posibilidad de error, abuso o manipulación.

Aquí conviene hacerse preguntas como estas:

- qué datos admite la app
- qué formatos acepta
- qué restricciones aplica
- qué mensajes de error muestra
- y si deja realizar acciones que no debería

Aunque este bloque no sea exactamente “web”, la lógica sigue siendo muy parecida: **toda entrada no controlada amplía riesgo**.

---

## 2. Permisos del sistema

En móvil, los permisos son una parte central de la superficie de ataque.

Si una app pide acceso a:

- cámara
- ubicación
- contactos
- archivos
- notificaciones
- micrófono
- sensores del dispositivo

entonces está ampliando el número de recursos que puede tocar y, por tanto, también los riesgos posibles.

No es solo una cuestión de privacidad. También es una cuestión de exposición. Una app con más permisos de los necesarios tiene más capacidad de:

- leer información
- guardarla
- enviarla
- compartirla
- o mostrarla fuera de contexto

!!! warning "Criterio práctico"
    Un permiso innecesario no es un detalle menor.  
    Es una ampliación real de la superficie de ataque.

Por eso en UT7 se insiste tanto en dos ideas:

- permisos mínimos
- y permisos pedidos en contexto

---

## 3. Almacenamiento local

Toda información que una app guarda en el dispositivo forma parte de su superficie de ataque.

Aquí entran elementos como:

- preferencias
- bases de datos locales
- ficheros
- cachés
- datos temporales
- logs
- tokens
- credenciales
- trazas de error

Una app puede tener un backend bien diseñado y, aun así, exponer información sensible por cómo guarda datos en local.

Por eso esta zona merece revisión propia.

### Qué conviene revisar aquí

Algunas preguntas útiles son:

- ¿qué datos guarda la app?
- ¿son realmente necesarios?
- ¿se almacenan en claro?
- ¿quedan restos en caché?
- ¿aparecen datos sensibles en logs?
- ¿se conservan más tiempo del debido?

!!! note "Idea importante"
    El problema no es solo guardar datos.  
    El problema es **qué se guarda, dónde se guarda y con qué nivel de protección**.

---

## 4. Comunicación de red

Cada petición al backend amplía la superficie de ataque de la app.

En esta zona entran elementos como:

- endpoints
- cabeceras
- parámetros
- tokens
- respuestas del servidor
- mensajes de error
- uso de HTTP o HTTPS
- validación de certificados
- comportamiento frente a intermediarios

La comunicación no es solo un canal por el que pasan datos. También es una zona activa de exposición.

En una revisión de seguridad conviene observar:

- qué se envía
- qué se recibe
- qué se protege
- qué se filtra por error
- y cómo se valida la conexión

Por eso UT7 incluye prácticas como:

- inspección de tráfico
- verificación de HTTPS/TLS
- rechazo de HTTP
- análisis de protocolos inseguros

---

## 5. Binario distribuido

El hecho de que la app se distribuya como paquete instalable añade una capa nueva de exposición que en web no tiene el mismo peso.

Dentro del binario pueden quedar:

- cadenas de texto
- URLs
- nombres internos
- configuraciones
- secretos mal ubicados
- librerías
- metadatos
- pistas sobre cómo está construida la app

Esto hace que la superficie de ataque móvil no se limite al comportamiento visible. También incluye lo que el paquete revela aunque no aparezca en pantalla.

!!! warning "Error habitual"
    Hay alumnado que revisa pantallas y tráfico, pero olvida por completo el binario.  
    Eso deja fuera una parte clave de la auditoría móvil.

UT8 está pensada precisamente para cubrir esta zona: binarios, integridad, firma y fugas de información en ejecutables.

---

## 6. Lógica de negocio en cliente

Aquí aparece uno de los errores más graves y, además, uno de los más interesantes desde el punto de vista didáctico.

Cuando una decisión sensible se toma solo en el cliente, la superficie de ataque crece mucho.

### Ejemplos típicos

- marcar a un usuario como premium solo desde la app
- decidir localmente si una compra es válida
- desbloquear funciones sin comprobación de servidor
- aceptar privilegios sin validación externa
- mostrar como completada una operación que el backend no ha confirmado

El problema no es que el cliente muestre información. El problema es que el cliente **decida por sí solo algo que debería validar el servidor**.

!!! danger "Regla de seguridad"
    En operaciones sensibles, el cliente puede pedir, mostrar o iniciar una acción, pero **no debe ser la única fuente de verdad**.

Por eso en UT8 se insiste tanto en la validación *server-side* de compras y en no confiar ciegamente en la lógica del lado cliente.

---

## 7. Backend y servicios externos

Aunque el foco esté en móvil, la superficie de ataque no termina en el teléfono.

La app suele apoyarse en:

- backend propio
- APIs
- autenticación externa
- almacenamiento remoto
- servicios de notificaciones
- sistemas de pago
- librerías o integraciones de terceros

Cada integración añade posibles puntos débiles.

Una auditoría móvil básica no tiene por qué convertirse en una auditoría completa del backend, pero sí debe preguntarse:

- qué depende del servidor
- qué valida realmente el servidor
- qué decisiones se delegan al cliente
- y qué incoherencias pueden aparecer entre ambos lados

---

## Superficie de ataque y vector de ataque

Conviene diferenciar dos ideas que a veces se mezclan.

### Superficie de ataque

Es el **mapa de zonas expuestas** de la aplicación.

### Vector de ataque

Es el **camino concreto** por el que alguien explota una de esas zonas.

### Ejemplo sencillo

- que la app guarde el token en local forma parte de la **superficie de ataque**
- que ese token esté en claro y pueda recuperarse fácilmente sería un **vector concreto de abuso**

Esta diferencia es útil porque primero hay que saber **qué zonas existen** y después ya se entienden mejor los ataques concretos que pueden afectar a cada una.

---

## Cómo crece la superficie de ataque

La superficie de ataque suele aumentar cuando ocurre alguna de estas cosas:

- la app pide más permisos de los necesarios
- guarda más datos de los imprescindibles
- comunica más de lo necesario
- incorpora lógica crítica en cliente
- expone demasiada información en errores o logs
- integra servicios externos sin control claro
- añade nuevas funciones sin revisar qué dependencias crea

Una app pequeña con login y consulta de datos tiene una superficie relativamente limitada.

Una app con:

- login
- geolocalización
- cámara
- notificaciones
- almacenamiento local
- compra premium
- sincronización en tiempo real

ya tiene una superficie bastante mayor.

No es una cuestión moral ni estética. Es una cuestión estructural.

---

## Ejemplo: una app sencilla que no lo es tanto

Imagina una app de gimnasio para reservar clases.

A simple vista hace pocas cosas:

- login
- ver horarios
- reservar plaza
- desbloquear plan premium

Parece una app bastante simple. Pero si la miras desde la idea de superficie de ataque, aparecen muchas zonas:

- pantalla de login
- token de sesión
- permiso de notificaciones
- almacenamiento local del perfil
- peticiones al backend
- recibo de la compra premium
- binario instalable
- lógica que decide si el usuario ya es premium

Esto permite enseñar una idea muy útil en clase: **una app aparentemente simple puede tener una superficie de ataque bastante amplia**.

---

## Una analogía útil para clase

La superficie de ataque se parece al número de puertas, ventanas, conductos y accesos de un edificio.

Eso no significa que alguien vaya a entrar por todos ellos.

Significa que, cuantos más puntos de entrada o exposición existan, más lugares hay que:

- revisar
- proteger
- vigilar
- y justificar

Una app con pocas funciones y buen diseño tiene menos “puertas”.

Una app cargada de permisos, datos y decisiones locales tiene muchas más.

---

## Relación directa con UT7 y UT8

Este subcapítulo sirve para dar sentido a todo lo que viene después.

### UT7 revisa zonas como

- permisos
- almacenamiento local
- tráfico de red

### UT8 revisa zonas como

- binario e integridad
- secretos o fugas en el ejecutable
- compras *in-app* con validación *server-side*

Si el alumnado entiende esta relación, deja de ver UT7 y UT8 como temas separados y empieza a verlas como partes coordinadas de una misma revisión.

!!! success "Resultado esperado"
    Comprender la superficie de ataque ayuda a auditar con orden.  
    No se trata de probar cosas sin rumbo, sino de revisar cada capa con un mapa mental claro.

---

## Errores comunes

### Pensar que la superficie de ataque es solo lo que se ve en pantalla

No. También incluye almacenamiento, red, binario, permisos y backend.

### Creer que una app pequeña casi no tiene superficie de ataque

A veces basta con un login, un token mal guardado y una compra mal validada para tener bastante riesgo.

### Confundir superficie de ataque con vulnerabilidad

La superficie es el terreno expuesto. La vulnerabilidad es el fallo concreto que existe dentro de ese terreno.

### Revisar solo una capa

Hay alumnado que mira la interfaz y no toca tráfico, o que revisa tráfico y no piensa en binario. Eso produce auditorías muy pobres.

### No relacionar arquitectura y riesgo

Cada permiso, cada dato guardado y cada endpoint añaden exposición. La arquitectura influye directamente en la seguridad.

---

## Preguntas clave para empezar una auditoría

Antes de auditar una app móvil, conviene hacerse estas preguntas:

- ¿Qué puede hacer esta app?
- ¿Qué datos toca?
- ¿Qué guarda en el dispositivo?
- ¿Con qué sistemas se comunica?
- ¿Qué permisos necesita?
- ¿Qué decisiones toma localmente?
- ¿Qué revela su binario?

Si respondes a eso, ya no empiezas la auditoría a ciegas. Empiezas con un mapa.

---

## Mini resumen para el alumnado

La superficie de ataque de una app móvil es el conjunto de puntos donde puede aparecer exposición, abuso o manipulación.

No se limita a la interfaz. Incluye también:

- permisos
- almacenamiento local
- tráfico de red
- binario
- backend
- y lógica de negocio en cliente

Entender esa superficie permite auditar con orden y no solo probar cosas al azar.

---

## Glosario mínimo

### Superficie de ataque

Conjunto de zonas expuestas de una app que pueden ser analizadas, abusadas o manipuladas.

### Vector de ataque

Camino concreto por el que se explota una zona de la superficie de ataque.

### Exposición

Situación en la que un dato, función o recurso queda accesible o visible más de lo debido.

### Lógica de negocio

Reglas que determinan cómo funciona una operación importante de la aplicación.

### Cliente

Parte de la aplicación que se ejecuta en el dispositivo del usuario.

---

## Frase docente útil para clase

> “Antes de buscar fallos, hay que saber por dónde puede fallar la app.”