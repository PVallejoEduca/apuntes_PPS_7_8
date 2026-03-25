# 1.4. Qué partes son sensibles desde el punto de vista de seguridad

No todas las partes de una app tienen el mismo riesgo. Algunas zonas son especialmente delicadas y conviene aprender a detectarlas rápido.

!!! abstract "Idea clave"
    Una zona sensible es una parte de la app donde un fallo puede exponer datos, romper la lógica o dar acceso indebido.

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

## Prioridad práctica

Si una app es pequeña, estas suelen ser las primeras zonas a revisar:

- login
- almacenamiento del token
- tráfico
- permisos
- binario
- operaciones sensibles como compras o privilegios

## Ejemplo rápido

Una app parece sencilla, pero:

- el login funciona
- el token se guarda mal
- el tráfico usa HTTPS menos en una petición
- el binario deja ver una URL interna
- la compra premium se acepta desde cliente

Hay varios problemas, aunque la app vaya bien.

## Cómo pensarlo en clase

Una parte es sensible cuando cumple una de estas condiciones:

- maneja datos privados
- da acceso a recursos del sistema
- decide algo importante
- comunica con servidor
- deja rastro útil para un atacante

## Error típico

Pensar que solo es sensible lo que tiene contraseña.

No. También lo son:

- un token
- una URL interna
- una compra
- un permiso de ubicación
- un log con demasiada información

## Qué debes recordar

- no todas las zonas de una app valen lo mismo
- hay partes especialmente delicadas
- aprender a detectarlas ayuda a priorizar la auditoría

## Imagen sugerida

Aquí encaja una imagen tipo mapa de arquitectura con zonas marcadas:

- login
- almacenamiento
- red
- backend
- compra premium
- binario