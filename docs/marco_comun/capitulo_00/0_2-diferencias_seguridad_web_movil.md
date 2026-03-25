# 0.2. Diferencias entre seguridad web y seguridad móvil

Una app web y una app móvil pueden usar el mismo backend y hacer casi lo mismo, pero no se auditan igual.

!!! abstract "Idea clave"
    La seguridad web y la seguridad móvil comparten principios, pero no la misma superficie de ataque.

## Qué tienen en común

En ambas hay que revisar:

- autenticación
- control de acceso
- comunicación con backend
- tratamiento de datos

## Qué cambia en móvil

En móvil aparecen capas extra:

- permisos del sistema
- almacenamiento local
- binario instalable
- firma e integridad
- mayor exposición del cliente

## Comparación rápida

### En web suele importar más

- navegador
- sesión
- formularios
- cabeceras
- servidor

### En móvil, además, importa mucho

- permisos
- datos guardados en el dispositivo
- tráfico desde la app
- binario
- decisiones que toma el cliente

## Ejemplo rápido

Mismo servicio, una plataforma de tareas.

### En web revisarías

- login
- roles
- sesión
- validación de entradas

### En móvil revisarías también

- permisos
- token almacenado
- logs
- tráfico
- binario
- funciones premium validadas solo en cliente

## Error típico

Pensar que una app móvil es solo una web empaquetada.

No. El entorno cambia y el riesgo también.

## Qué debes recordar

- en web no debes confiar en el navegador
- en móvil no debes confiar en la app cliente
- el dispositivo añade capas nuevas que hay que auditar