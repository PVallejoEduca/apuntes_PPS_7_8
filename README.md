# Android-Jetpack_Compose_Tutorial

Este proyecto será una web para aprender Android con Jetpack Compose. Será un tutorial con prácticas, códigos de ejemplo, ejercicios y demás.

La web está creada con Python mkdocs-material. Las carpetas bases de el proyecto son:
 - venv: entorno local virtual para python --> Para no pisar con diferentes versiones de otros proyectos
 - docs: página web del tutorial
 - mkdocs.yml: documento de configuración base de mkdocs

Para arrancar el servidor web en local lanzar:
    - .\venv\Scripts\activate
    - mkdocs serve --livereload
    - Arranca el servidor local en: http://localhost:8000/

> **Solución a problemas de Live Reload (Refresco automático):**
> Si el navegador no se actualiza al guardar los cambios:
> 1. Asegúrate de tener **watchdog** instalado: `pip install watchdog`
> 2. **En Windows:** A menudo es necesario instalar `pywin32` para que detecte bien los cambios: `pip install pywin32`
> 3. **Reinicia el servidor** (`Ctrl+C` y `mkdocs serve`) tras instalar estas librerías.
> 4. **Nota para Android Studio/IntelliJ:** Si usas estos editores, debes desactivar la opción *"Use safe write"* en *Settings > System Settings*.
