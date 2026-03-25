# PPS_Mobile_Security_Notes

Este proyecto contiene una web de apuntes para trabajar la seguridad en aplicaciones móviles dentro del módulo de Puesta en Producción Segura.

La web reúne los contenidos teóricos de las UT7 y UT8 y está pensada como apoyo para clase, laboratorio y proyecto final de auditoría móvil. No se centra solo en explicar conceptos, también busca preparar al alumnado para analizar una app móvil con criterio técnico.

Los contenidos principales del proyecto giran alrededor de:
- seguridad en aplicaciones móviles
- diferencias entre seguridad web y seguridad móvil
- superficie de ataque de una app móvil
- permisos
- almacenamiento local y almacenamiento seguro
- tráfico y comunicaciones
- binarios, firma e integridad
- compras in-app y validación server-side

La web está creada con Python y mkdocs-material. Las carpetas base del proyecto son:
- venv: entorno virtual local de Python, para aislar dependencias del proyecto
- docs: contenido de la web de apuntes
- mkdocs.yml: archivo principal de configuración de MkDocs

## Instalación

Instalar:
- Python
- Entorno virtual local: `python -m venv venv`
- Dependencias: `pip install mkdocs mkdocs-material`

## Arranque en local

Para lanzar el servidor web en local:
- Activar entorno virtual en Windows: `.\venv\Scripts\activate`
- Iniciar servidor: `mkdocs serve --livereload`

La web quedará disponible en:
- `http://localhost:8000/`

## Generación y despliegue

Para generar y publicar la web:
- Activar entorno virtual: `.\venv\Scripts\activate`
- Publicar en GitHub Pages: `mkdocs gh-deploy`

## Estructura de los contenidos

La web se organiza como un bloque de apuntes sobre seguridad móvil, dividido en apartados y subapartados que se irán desarrollando progresivamente.

La estructura general parte de:
- marco común de seguridad móvil
- UT7, permisos, almacenamiento y tráfico
- UT8, binarios, firma y compras integradas

Cada subcapítulo está pensado para incluir:
- explicación teórica
- ejemplos concretos
- errores comunes
- ideas clave para auditoría

## Finalidad del proyecto

Este proyecto no está orientado al desarrollo completo de aplicaciones móviles desde cero, sino al aprendizaje de conceptos y técnicas de revisión de seguridad sobre apps de laboratorio.

La intención es que el alumnado pueda:
- comprender los riesgos habituales en apps móviles
- identificar malas prácticas
- relacionar teoría y práctica
- preparar laboratorios guiados
- documentar hallazgos técnicos con orden

## Entorno de trabajo

Todo el trabajo asociado a estos apuntes debe realizarse únicamente en entornos locales, controlados y con fines docentes.

No se debe aplicar nada de lo trabajado aquí sobre sistemas, apps o servicios de terceros.

## Solución a problemas de Live Reload

Si el navegador no se actualiza al guardar cambios:
1. Asegúrate de tener instalado `watchdog` con `pip install watchdog`
2. En Windows puede ser necesario instalar `pywin32` con `pip install pywin32`
3. Reinicia el servidor después de instalar estas librerías