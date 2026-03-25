# 1.1. Componentes básicos de una app móvil

Una app móvil no es solo pantallas. Tiene varias piezas que trabajan juntas y conviene entenderlas antes de auditar permisos, almacenamiento, red o backend.

!!! abstract "Idea clave"
    Una app móvil suele estar formada por cliente, sistema operativo, almacenamiento, red y backend.

## Piezas principales

### 1. Interfaz

Es lo que ve y toca el usuario.

- pantallas
- botones
- formularios
- menús
- mensajes

### 2. Lógica cliente

Es lo que decide la app en el dispositivo.

- validaciones básicas
- navegación
- gestión de sesión
- llamadas al backend
- control del flujo de la app

### 3. Almacenamiento local

Es donde la app guarda datos en el móvil.

- preferencias
- base de datos local
- caché
- ficheros temporales
- token o datos de sesión, si está mal diseñada

### 4. Comunicación de red

Es el canal entre la app y el servidor.

- peticiones
- respuestas
- tokens
- cabeceras
- datos enviados y recibidos

### 5. Backend

Es la parte que corre en servidor.

- autentica usuarios
- guarda datos reales
- aplica reglas de negocio
- valida operaciones sensibles
- responde a la app

## Ejemplo rápido

Una app de gimnasio puede tener:

- una pantalla para iniciar sesión
- lógica cliente para pasar de una pantalla a otra
- un token guardado en el dispositivo
- peticiones al servidor para ver clases
- un backend que confirma reservas

## Error típico

Pensar que la app es solo la interfaz.

No. La interfaz es solo una parte. El riesgo puede estar en el almacenamiento, en la red o en cómo se valida algo en servidor.

## Qué debes recordar

- una app móvil tiene varias capas
- no todo pasa en pantalla
- para auditar bien hay que mirar cliente, dispositivo y backend

## Imagen sugerida

Aquí quedaría muy bien una imagen simple tipo diagrama de bloques:

- móvil
- interfaz
- almacenamiento local
- red
- backend