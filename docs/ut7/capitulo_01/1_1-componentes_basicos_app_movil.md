# 1.1. Componentes básicos de una app móvil

Antes de auditar una app conviene verla como un conjunto de piezas, no como una simple colección de pantallas. Si entiendes qué componente hace cada cosa, luego resulta mucho más fácil localizar riesgos.

!!! abstract "Idea clave"
    Una app móvil combina interfaz, lógica cliente, almacenamiento, red y backend.

---

## Vista rápida

```text
[ Usuario ]
     ↓
[ Interfaz ]
     ↓
[ Lógica cliente ] ↔ [ Almacenamiento local ]
     ↓
[ Red / API ]
     ↓
[ Backend ]
```
<figcaption>Figura: esquema básico de componentes de una app móvil.</figcaption> </figure>

## Piezas principales

### Interfaz

Es la parte visible de la app.

- pantallas
- botones
- formularios
- mensajes
- navegación visual

### Lógica cliente

Es lo que la app decide en el dispositivo.

- control del flujo
- validaciones básicas
- gestión de sesión
- llamadas al backend
- respuesta a acciones del usuario

### Almacenamiento local

Es donde la app guarda información en el móvil.

- preferencias
- caché
- base de datos local
- ficheros temporales
- datos de sesión, si están mal ubicados

### Comunicación de red

Es el canal con el servidor.

- peticiones
- respuestas
- tokens
- cabeceras
- datos enviados y recibidos

### Backend

Es la parte que corre en servidor.

- autentica usuarios
- guarda datos
- aplica reglas de negocio
- valida operaciones sensibles
- responde a la app

---

## Ejemplo rápido

En una app de gimnasio puede ocurrir esto:

- la interfaz muestra el login
- la lógica cliente controla la navegación
- el token se guarda en local
- la red consulta clases disponibles
- el backend confirma la reserva

??? example "Cómo leer este ejemplo"
    La app parece una sola cosa, pero en realidad cada acción pasa por varias capas.  
    Ahí es donde luego aparecen riesgos distintos.

---

## Error frecuente

!!! warning "No reduzcas la app a la pantalla"
    La interfaz es solo una parte.  
    El problema real puede estar en el almacenamiento, en la red o en una validación mal resuelta en servidor.

---

## Qué debes recordar

!!! success "Resumen"
    - una app móvil tiene varias piezas
    - no todo ocurre en pantalla
    - para auditar bien hay que mirar cliente, dispositivo y backend