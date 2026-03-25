# 1.3. Dónde viven los datos y por dónde circulan

Una de las preguntas más útiles al auditar una app es esta: qué datos maneja, dónde los guarda y por dónde los mueve.

!!! abstract "Idea clave"
    Para revisar seguridad hay que saber dónde están los datos en reposo y por dónde viajan en movimiento.

## Dónde pueden vivir los datos

### En memoria

Mientras la app se está usando.

Ejemplo:

- usuario autenticado
- token cargado
- datos del perfil en uso

### En almacenamiento local

Datos guardados en el dispositivo.

Ejemplo:

- preferencias
- caché
- base de datos local
- ficheros
- imágenes descargadas

### En tránsito

Cuando viajan entre app y backend.

Ejemplo:

- login
- consulta de datos
- envío de formularios
- compras
- sincronización

### En servidor

Donde se guardan datos permanentes y se validan operaciones.

Ejemplo:

- cuentas
- reservas
- historial
- permisos
- estado premium

### En servicios externos

Cuando la app usa terceros.

Ejemplo:

- pagos
- analítica
- notificaciones
- almacenamiento externo

## Mapa rápido de circulación

Un dato puede seguir un camino así:

1. el usuario introduce email y contraseña
2. la app envía esos datos al backend
3. el backend responde con un token
4. la app guarda ese token localmente
5. la app usa ese token en nuevas peticiones

Ese camino ya da varias preguntas de auditoría:

- se envía cifrado
- se guarda en sitio seguro
- aparece en logs
- caduca correctamente
- lo valida el backend

## Ejemplo rápido

En una app de compra premium:

- el usuario pulsa comprar
- la app recibe un recibo
- el recibo se envía al backend
- el backend valida
- el servidor actualiza el estado premium

Si el paso de validación en servidor falla o no existe, el problema es serio.

## Error típico

Mirar solo el momento en que el dato se envía.

No. También importa:

- dónde se guarda antes
- dónde se queda después
- si aparece en caché o logs
- si el binario revela algo útil sobre ese flujo

## Qué debes recordar

- un dato sensible no solo importa cuando viaja
- también importa dónde descansa
- seguir el recorrido del dato ayuda mucho a auditar

## Imagen sugerida

Aquí vendría muy bien un diagrama de flujo de datos.

Ejemplo visual:

- usuario -> app -> backend -> respuesta -> almacenamiento local