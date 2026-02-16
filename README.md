# Android-Jetpack_Compose_Tutorial

Este proyecto será una web para aprender Android con Jetpack Compose. Será un tutorial con prácticas, códigos de ejemplo, ejercicios y demás.

La web está creada con Python mkdocs-material. Las carpetas bases de el proyecto son:
 - venv: entorno local virtual para python --> Para no pisar con diferentes versiones de otros proyectos
 - docs: página web del tutorial
 - mkdocs.yml: documento de configuración base de mkdocs

Para arrancar el servidor web en local lanzar:
    - .\venv\Scripts\activate
    - mkdocs serve --watch docs
    - Arranca el servidor local en: http://localhost:8000/


También he instalado watchdog para que capture los eventos de guardado sobre los ficheros md y actualice el servidor automáticamente: pip install watchdog


