# 1.2. Cliente, sistema operativo, backend y servicios externos

No todas las piezas hacen lo mismo. Entender el papel de cada una ayuda mucho a saber dónde buscar cada problema.

!!! abstract "Idea clave"
    En móvil, la seguridad depende de cómo se reparten las responsabilidades entre cliente, sistema operativo, backend y servicios externos.

## Quién hace qué

| Parte | Qué hace | Qué riesgo puede introducir |
|---|---|---|
| Cliente | Muestra la app y ejecuta lógica local | confiar demasiado en el cliente |
| Sistema operativo | Gestiona permisos, almacenamiento y ejecución | permisos mal usados, exposición del dispositivo |
| Backend | Valida, guarda y decide operaciones críticas | control de acceso débil, validaciones insuficientes |
| Servicios externos | notificaciones, mapas, pagos, login externo | dependencia de terceros, mala integración |

## Cliente

Es la app instalada en el móvil.

Hace cosas como:

- mostrar pantallas
- recoger datos
- guardar parte de la sesión
- lanzar peticiones
- tomar decisiones de interfaz

Pero no debería decidir cosas críticas por sí sola.

Ejemplo:

- sí puede mostrar si una compra parece correcta
- no debería ser la única que decide si el usuario tiene premium

## Sistema operativo

Es Android o iOS.

Controla:

- permisos
- acceso a recursos del dispositivo
- sandbox de la app
- almacenamiento protegido
- instalación y ejecución

Aquí aparecen temas clave como:

- permisos de cámara o ubicación
- acceso a archivos
- datos guardados en el dispositivo

## Backend

Es el servidor con el que habla la app.

Debería encargarse de:

- autenticar
- autorizar
- validar operaciones sensibles
- guardar los datos importantes
- aplicar reglas reales de negocio

!!! tip "Regla útil"
    Lo importante se confirma en servidor, no solo en el cliente.

## Servicios externos

Muchas apps no dependen solo de su backend. También usan:

- Firebase
- mapas
- pasarelas de pago
- notificaciones push
- login social

Cada servicio externo añade funcionalidad, pero también añade superficie de ataque y puntos que revisar.

## Ejemplo rápido

En una app de reservas:

- el cliente muestra horarios
- el sistema operativo concede permiso de notificaciones
- el backend valida la reserva
- un servicio externo envía avisos push

## Error típico

Pensar que si el backend es seguro, ya está todo bien.

No. La app puede fallar igualmente si:

- pide permisos de más
- guarda datos mal
- expone información en el binario
- confía demasiado en decisiones locales

## Qué debes recordar

- cliente, sistema operativo y backend no hacen lo mismo
- la app segura reparte bien responsabilidades
- el cliente no debe ser la autoridad final en operaciones sensibles

## Imagen sugerida

Aquí encaja muy bien una imagen por capas:

- usuario
- app cliente
- sistema operativo
- backend
- servicios externos