# 1.4. Qué partes son sensibles desde el punto de vista de seguridad

No todas las zonas de una app tienen el mismo riesgo. Algunas merecen prioridad porque un fallo ahí puede exponer datos, romper la lógica o dar acceso indebido.

!!! abstract "Idea clave"
    Una zona sensible es una parte de la app donde un fallo tiene más impacto que en el resto.

---

## Zonas especialmente sensibles

| Zona | Por qué es sensible | Qué conviene mirar |
|---|---|---|
| Login | trata credenciales y sesión | validación, errores, envío, respuesta |
| Token o sesión | da acceso a la cuenta | dónde se guarda, cómo se usa, si caduca |
| Permisos | abren acceso a recursos del dispositivo | si sobran, cuándo se piden, para qué |
| Almacenamiento local | puede exponer datos sensibles | texto plano, caché, logs, ficheros |
| Red | mueve datos y operaciones importantes | HTTPS, tokens, cabeceras, errores |
| Compras o funciones premium | afectan a lógica de negocio | qué valida el cliente y qué valida el servidor |
| Binario | puede revelar secretos o configuración | strings, endpoints, claves, nombres internos |
| Mensajes de error y logs | filtran información útil | trazas, datos personales, respuestas técnicas |

---

## Prioridad práctica

Si una app es pequeña, estas suelen ser las primeras zonas a revisar:

- login
- almacenamiento del token
- tráfico
- permisos
- binario
- compras o privilegios

---

## Cómo detectarlas rápido

Una parte es sensible cuando cumple alguna de estas condiciones:

- maneja datos privados
- da acceso a recursos del sistema
- decide algo importante
- comunica con servidor
- deja rastro útil para un atacante

---

## Ejemplo rápido

Una app parece sencilla, pero:

- el login funciona
- el token se guarda mal
- una petición usa HTTP
- el binario revela una URL interna
- la compra premium se acepta desde cliente

La app puede parecer correcta en demo, pero tiene varias zonas delicadas mal resueltas.

??? example "Lectura útil del ejemplo"
    El problema no es una sola pantalla.  
    El problema es que varias zonas sensibles concentran decisiones importantes.

---

## Error frecuente

!!! warning "No solo es sensible lo que tiene contraseña"
    También pueden ser sensibles:
    
    - un token
    - una URL interna
    - una compra
    - un permiso de ubicación
    - un log con demasiada información

---

## Qué debes recordar

!!! success "Resumen"
    - no todas las zonas de una app valen lo mismo
    - hay partes especialmente delicadas
    - detectarlas pronto ayuda a priorizar la auditoría