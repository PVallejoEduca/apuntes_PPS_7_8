# 1.3. Dónde viven los datos y por dónde circulan

Una de las preguntas más útiles al auditar una app es esta: qué datos maneja, dónde los guarda y por dónde los mueve. Seguir el recorrido del dato ayuda mucho a detectar riesgos reales.

!!! abstract "Idea clave"
    Para revisar seguridad hay que saber dónde están los datos en reposo y por dónde viajan cuando están en movimiento.

---

## Dónde pueden estar los datos

### En memoria

Mientras la app se está usando.

- usuario autenticado
- token cargado
- datos del perfil en uso

### En almacenamiento local

Cuando quedan guardados en el dispositivo.

- preferencias
- caché
- base de datos local
- ficheros
- imágenes descargadas

### En tránsito

Cuando viajan entre app y backend.

- login
- consulta de datos
- envío de formularios
- compras
- sincronización

### En servidor

Cuando se almacenan y validan de forma centralizada.

- cuentas
- reservas
- historial
- permisos
- estado premium

### En servicios externos

Cuando la app usa terceros.

- pagos
- analítica
- notificaciones
- almacenamiento externo

---

## Recorrido típico de un dato

1. el usuario introduce email y contraseña  
2. la app envía esos datos al backend  
3. el backend responde con un token  
4. la app guarda ese token localmente  
5. la app usa ese token en nuevas peticiones  

---

## Qué preguntas salen de ese recorrido

- ¿se envía cifrado?
- ¿se guarda en un sitio seguro?
- ¿aparece en logs?
- ¿caduca correctamente?
- ¿lo valida el backend?

!!! tip "Pista de auditoría"
    Seguir el recorrido de un dato sensible suele revelar más problemas que mirar solo una pantalla o una petición aislada.

---

## Ejemplo rápido

En una app de compra premium:

- el usuario pulsa comprar
- la app recibe un recibo
- el recibo se envía al backend
- el backend valida
- el servidor actualiza el estado premium

Si la validación en servidor no existe o falla, el problema es serio.

??? example "Qué no debes hacer"
    Mirar solo el momento en que el dato se envía.  
    También importa dónde se guarda antes, dónde queda después y si aparece en caché, logs o binario.

---

## Error frecuente

!!! warning "El riesgo no está solo en el tránsito"
    Un dato sensible no solo importa cuando viaja.  
    También importa dónde descansa y quién puede recuperarlo después.

---

## Qué debes recordar

!!! success "Resumen"
    - un dato sensible puede pasar por varios sitios
    - importa tanto el tránsito como el almacenamiento
    - seguir el recorrido del dato ayuda mucho a auditar