# 0.3. Superficie de ataque de una app móvil

Antes de buscar fallos hay que saber por dónde puede fallar una app. A ese mapa de zonas expuestas lo llamamos superficie de ataque.

!!! abstract "Idea clave"
    La superficie de ataque es el conjunto de puntos donde una app puede exponer datos, aceptar abusos o tomar malas decisiones.

## Qué forma parte de esa superficie

- interfaz y entradas
- permisos
- almacenamiento local
- tráfico de red
- binario
- lógica de negocio en cliente
- backend y servicios externos

## Cómo entenderlo fácil

Cuantas más cosas hace una app, más puntos hay que revisar.

Más permisos, más datos, más comunicaciones y más lógica local suelen significar más superficie de ataque.

## Ejemplo rápido

Una app de gimnasio parece simple:

- login
- horarios
- reserva
- plan premium

Pero su superficie de ataque incluye:

- pantalla de login
- token
- permiso de notificaciones
- almacenamiento local
- peticiones al backend
- compra premium
- binario
- lógica que decide si el usuario es premium

## Diferencia importante

### Superficie de ataque

Es la zona expuesta.

### Vulnerabilidad

Es el fallo concreto dentro de esa zona.

Ejemplo:

- guardar el token en local forma parte de la superficie
- guardarlo en claro sería la vulnerabilidad

## Error típico

Revisar solo una capa.

Por ejemplo:

- mirar pantallas pero no tráfico
- mirar tráfico pero no binario
- mirar permisos pero no almacenamiento

Eso lleva a auditorías pobres.

## Qué debes recordar

Antes de auditar una app, pregúntate:

- qué datos maneja
- qué guarda
- qué permisos usa
- con qué se comunica
- qué decide localmente
- qué revela su binario