
# 1.2. Cliente, sistema operativo, backend y servicios externos

No todas las partes de una app hacen lo mismo. Una buena revisión de seguridad empieza por entender qué responsabilidad tiene cada capa y qué errores suelen aparecer en cada una.

!!! abstract "Idea clave"
    En móvil, la seguridad depende mucho de cómo se reparten las responsabilidades entre cliente, sistema operativo, backend y servicios externos.

---

## Comparación rápida

| Parte | Qué hace | Qué riesgo introduce |
|---|---|---|
| Cliente | muestra la app y ejecuta lógica local | confiar demasiado en el cliente |
| Sistema operativo | gestiona permisos, recursos y ejecución | permisos mal usados, exposición del dispositivo |
| Backend | valida, guarda y decide operaciones críticas | validaciones débiles, control de acceso insuficiente |
| Servicios externos | añaden funciones como pagos o notificaciones | dependencia de terceros, integración insegura |

---

## Cliente

Es la app instalada en el móvil.

Hace tareas como:

- mostrar pantallas
- recoger datos
- lanzar peticiones
- guardar parte de la sesión
- controlar la experiencia de uso

Pero no debería decidir cosas críticas por sí sola.

!!! note "Importante"
    El cliente puede mostrar información y guiar el flujo, pero no debería decidir por sí solo operaciones sensibles.

---

## Sistema operativo

Es Android o iOS.

Se encarga de aspectos como:

- permisos
- acceso a cámara o ubicación
- sandbox de la app
- almacenamiento protegido
- instalación y ejecución

Aquí aparecen muchos problemas típicos de móvil, porque la app no vive sola: vive dentro de un entorno con reglas, recursos y límites.

---

## Backend

Es el servidor con el que habla la app.

Debe encargarse de:

- autenticar
- autorizar
- validar operaciones sensibles
- guardar datos importantes
- aplicar reglas reales de negocio

!!! tip "Regla útil"
    Lo importante se confirma en servidor, no solo en cliente.

---

## Servicios externos

Muchas apps también dependen de terceros:

- Firebase
- mapas
- login social
- pagos
- notificaciones push

Cada integración aporta funcionalidad, pero también suma superficie de ataque.

??? example "Ejemplo rápido"
    En una app de reservas:
    
    - el cliente muestra horarios
    - el sistema operativo concede permiso de notificaciones
    - el backend valida la reserva
    - un servicio externo envía el aviso push

---

## Error frecuente

!!! warning "Backend seguro no significa app segura"
    La app puede seguir fallando si:
    
    - pide permisos de más
    - guarda datos mal
    - expone información en el binario
    - confía demasiado en decisiones locales

---

## Qué debes recordar

!!! success "Resumen"
    - cliente, sistema operativo y backend no hacen lo mismo
    - una app segura reparte bien responsabilidades
    - el cliente no debe ser la autoridad final en operaciones sensibles