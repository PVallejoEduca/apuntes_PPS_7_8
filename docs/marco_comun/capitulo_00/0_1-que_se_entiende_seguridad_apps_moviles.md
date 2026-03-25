# 0.1. Qué se entiende por seguridad en aplicaciones móviles

Una app no es segura solo porque funcione bien. Puede iniciar sesión, guardar datos y tener una interfaz correcta, y aun así exponer información o confiar en cosas que no debería.

!!! abstract "Idea clave"
    Una app móvil segura protege datos, operaciones, comunicaciones y confianza.

## Qué debe proteger una app

### Confidencialidad

Que datos sensibles como tokens, correos, contraseñas o ubicación no queden expuestos.

### Integridad

Que nadie pueda modificar datos o decisiones importantes sin permiso.

### Autenticidad

Que la app se comunique con el backend correcto y que las operaciones realmente pertenezcan al usuario.

### Disponibilidad

Que el servicio siga funcionando y no falle por malas decisiones de seguridad.

## Dónde puede fallar

En una app móvil hay varias capas que revisar:

- permisos
- almacenamiento local
- tráfico de red
- binario
- lógica de negocio
- backend

## Ejemplo rápido

Una app de notas parece correcta, pero:

- guarda el token en claro
- deja datos en logs
- hace una petición por HTTP
- pide un permiso innecesario

Funciona, sí. Segura, no.

## Error típico

Pensar que la seguridad es solo cifrar o usar HTTPS.

No basta con eso. También importa:

- qué se guarda
- dónde se guarda
- qué decide el cliente
- y qué valida el servidor

## Qué debes recordar

- una app funcional no siempre es una app segura
- el móvil añade riesgos propios del dispositivo
- hay que revisar varias capas, no solo la pantalla