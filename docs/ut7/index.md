<div class="hero-panel hero-panel--section">
  <p class="course-eyebrow">Ruta 1 · UT7</p>
  <h1>Movil I: permisos, almacenamiento y trafico</h1>
  <p class="course-lead">
    Esta unidad pone el foco en todo lo que una app cliente puede exponer: permisos innecesarios,
    datos en local, fugas desde el dispositivo y problemas de seguridad en la comunicacion con el backend.
  </p>
  <div class="course-chip-row">
    <span class="course-chip">12 capitulos</span>
    <span class="course-chip">Permisos y minimo privilegio</span>
    <span class="course-chip">Almacenamiento local</span>
    <span class="course-chip">Trafico y TLS</span>
  </div>
</div>

## Enfoque de la unidad

<div class="info-grid">
  <div class="info-card">
    <h3>Que revisas</h3>
    <p>Lo que la app pide, lo que guarda, lo que expone y lo que transmite cuando funciona en el dispositivo.</p>
  </div>
  <div class="info-card">
    <h3>Que aprendes a detectar</h3>
    <p>Permisos mal planteados, datos sensibles en claro, trafico inseguro, fugas por logs y configuraciones debiles.</p>
  </div>
  <div class="info-card">
    <h3>Resultado practico</h3>
    <p>Terminas con un checklist base para revisar una app movil cliente de forma sistematica.</p>
  </div>
</div>

## Roadmap de UT7

<div class="chapter-grid">
  <a href="capitulo_01/1_1-componentes_basicos_app_movil.md" class="chapter-card">
    <span class="chapter-card__num">1</span>
    <h3>Arquitectura de una app movil</h3>
    <p>Componentes basicos, backend, servicios externos, datos y partes sensibles desde seguridad.</p>
    <span class="chapter-card__topics">4 apartados · arquitectura · flujo de datos</span>
  </a>
  <a href="capitulo_02/2_1-que_es_permiso_y_que_protege.md" class="chapter-card">
    <span class="chapter-card__num">2</span>
    <h3>Modelos de permisos</h3>
    <p>Que protege un permiso, tipos de permisos y diferencias basicas entre Android e iOS.</p>
    <span class="chapter-card__topics">5 apartados · permisos · sistema operativo</span>
  </a>
  <a href="capitulo_03/3_1-pedir_solo_lo_imprescindible.md" class="chapter-card">
    <span class="chapter-card__num">3</span>
    <h3>Minimo privilegio</h3>
    <p>Como pedir solo lo necesario, cuando hacerlo y como justificarlo con contexto de uso.</p>
    <span class="chapter-card__topics">5 apartados · principio de minimo privilegio</span>
  </a>
  <a href="capitulo_04/4_1-exposicion_datos_personales.md" class="chapter-card">
    <span class="chapter-card__num">4</span>
    <h3>Riesgos de permisos mal disenados</h3>
    <p>Impacto real sobre privacidad, confianza del usuario y hallazgos de auditoria asociados.</p>
    <span class="chapter-card__topics">5 apartados · privacidad · malas practicas</span>
  </a>
  <a href="capitulo_05/5_1-donde_puede_guardar_datos_una_app.md" class="chapter-card">
    <span class="chapter-card__num">5</span>
    <h3>Almacenamiento local</h3>
    <p>Diferencias entre preferencias, ficheros, bases de datos, cache y persistencia temporal.</p>
    <span class="chapter-card__topics">5 apartados · SharedPreferences · cache · bases de datos</span>
  </a>
  <a href="capitulo_06/6_1-datos_sensibles_en_movil.md" class="chapter-card">
    <span class="chapter-card__num">6</span>
    <h3>Almacenamiento seguro</h3>
    <p>Que datos son sensibles, que no debe quedar en texto plano y como pensar en cifrado local.</p>
    <span class="chapter-card__topics">5 apartados · Keystore · cifrado · datos sensibles</span>
  </a>
  <a href="capitulo_07/7_1-logs_inseguros.md" class="chapter-card">
    <span class="chapter-card__num">7</span>
    <h3>Fugas en el dispositivo</h3>
    <p>Logs, clipboard, backups, capturas, cache y mensajes de error como fuentes de exposicion.</p>
    <span class="chapter-card__topics">6 apartados · fugas locales · privacidad</span>
  </a>
  <a href="capitulo_08/8_1-comunicacion_app_backend.md" class="chapter-card">
    <span class="chapter-card__num">8</span>
    <h3>Comunicacion de red</h3>
    <p>Como viajan los datos, que protege TLS y como identificar elementos sensibles en una peticion.</p>
    <span class="chapter-card__topics">5 apartados · backend · sesiones · tokens</span>
  </a>
  <a href="capitulo_09/9_1-por_que_http_no_es_aceptable.md" class="chapter-card">
    <span class="chapter-card__num">9</span>
    <h3>Protocolos seguros e inseguros</h3>
    <p>HTTP vs HTTPS, errores de configuracion, certificados y casos reales de trafico debil.</p>
    <span class="chapter-card__topics">5 apartados · HTTPS · validacion basica</span>
  </a>
  <a href="capitulo_10/10_1-interceptar_trafico_en_laboratorio.md" class="chapter-card">
    <span class="chapter-card__num">10</span>
    <h3>Monitorizacion e inspeccion del trafico</h3>
    <p>Que significa interceptar trafico en laboratorio, que mirar y que sirve como evidencia.</p>
    <span class="chapter-card__topics">5 apartados · laboratorio · evidencias</span>
  </a>
  <a href="capitulo_11/11_1-problema_que_resuelve_pinning.md" class="chapter-card">
    <span class="chapter-card__num">11</span>
    <h3>Certificate pinning</h3>
    <p>Introduccion al problema que intenta resolver, ventajas, limites y relacion con MITM controlado.</p>
    <span class="chapter-card__topics">5 apartados · introduccion · pinning</span>
  </a>
  <a href="capitulo_12/12_1-revisar_permisos_sistematicamente.md" class="chapter-card">
    <span class="chapter-card__num">12</span>
    <h3>Criterios de revision de UT7</h3>
    <p>Capitulo de cierre para transformar teoria en checklist operativo de auditoria cliente.</p>
    <span class="chapter-card__topics">5 apartados · checklist · documentacion</span>
  </a>
</div>
