<div class="hero-panel hero-panel--section">
  <p class="course-eyebrow">Ruta 2 · UT8</p>
  <h1>Movil II: binarios, firmas y compras in-app</h1>
  <p class="course-lead">
    Esta unidad avanza desde el analisis del cliente hacia el binario y el backend:
    firma, integridad, secretos embebidos, ofuscacion y validacion server-side de compras.
  </p>
  <div class="course-chip-row">
    <span class="course-chip">11 capitulos</span>
    <span class="course-chip">Binario y firma</span>
    <span class="course-chip">Secretos en ejecutables</span>
    <span class="course-chip">Compras integradas</span>
  </div>
</div>

## Enfoque de la unidad

<div class="info-grid">
  <div class="info-card">
    <h3>Mirada tecnica</h3>
    <p>No solo que contiene el APK o AAB, sino que informacion revela y como afecta a la confianza operativa.</p>
  </div>
  <div class="info-card">
    <h3>Riesgos que importan</h3>
    <p>Secretos embebidos, builds no confiables, validaciones hechas solo en cliente y flujos de compra manipulables.</p>
  </div>
  <div class="info-card">
    <h3>Resultado practico</h3>
    <p>Una vision integrada cliente + backend para redactar hallazgos y pruebas negativas con criterio.</p>
  </div>
</div>

## Roadmap de UT8

<div class="chapter-grid">
  <a href="capitulo_13/13_1-apk_aab_ipa_conceptos_basicos.md" class="chapter-card">
    <span class="chapter-card__num">13</span>
    <h3>Que es un binario movil</h3>
    <p>APK, AAB e IPA, contenido del paquete y limites de un analisis basico de aula.</p>
    <span class="chapter-card__topics">5 apartados · paquete · recursos · manifiesto</span>
  </a>
  <a href="capitulo_14/14_1-que_significa_firmar_app.md" class="chapter-card">
    <span class="chapter-card__num">14</span>
    <h3>Firma e integridad</h3>
    <p>Que significa firmar una app, para que sirve la firma y como pensar una build confiable.</p>
    <span class="chapter-card__topics">5 apartados · confianza · verificacion</span>
  </a>
  <a href="capitulo_15/15_1-cliente_binario_so_backend.md" class="chapter-card">
    <span class="chapter-card__num">15</span>
    <h3>Cadena de confianza</h3>
    <p>Relaciones entre cliente, binario, sistema operativo y backend, y por que el cliente no es la verdad.</p>
    <span class="chapter-card__topics">4 apartados · confianza operativa</span>
  </a>
  <a href="capitulo_16/16_1-strings_y_secretos_embebidos.md" class="chapter-card">
    <span class="chapter-card__num">16</span>
    <h3>Fuga de informacion en ejecutables</h3>
    <p>Strings, URLs, tokens, claves y configuraciones sensibles incluidas por error.</p>
    <span class="chapter-card__topics">5 apartados · secretos embebidos · evidencia</span>
  </a>
  <a href="capitulo_17/17_1-que_es_ofuscar.md" class="chapter-card">
    <span class="chapter-card__num">17</span>
    <h3>Ofuscacion</h3>
    <p>Para que sirve, para que no sirve y por que es una defensa complementaria, no una solucion magica.</p>
    <span class="chapter-card__topics">5 apartados · defensa complementaria</span>
  </a>
  <a href="capitulo_18/18_1-que_es_compra_in_app.md" class="chapter-card">
    <span class="chapter-card__num">18</span>
    <h3>Compras integradas: modelo y riesgos</h3>
    <p>Actores implicados, que se valida y por que confiar solo en cliente rompe el flujo.</p>
    <span class="chapter-card__topics">5 apartados · tienda · backend · usuario</span>
  </a>
  <a href="capitulo_19/19_1-flujo_correcto_validacion.md" class="chapter-card">
    <span class="chapter-card__num">19</span>
    <h3>Validacion server-side de compras</h3>
    <p>Flujo correcto, comprobaciones de servidor, trazabilidad y rechazo de operaciones invalidas.</p>
    <span class="chapter-card__topics">5 apartados · recibo · orden · usuario</span>
  </a>
  <a href="capitulo_20/20_1-replay.md" class="chapter-card">
    <span class="chapter-card__num">20</span>
    <h3>Ataques al flujo de compra</h3>
    <p>Replay, recibos manipulados, duplicidades, bypass local y asociaciones incorrectas.</p>
    <span class="chapter-card__topics">5 apartados · fraude · logica de compra</span>
  </a>
  <a href="capitulo_21/21_1-que_es_prueba_negativa.md" class="chapter-card">
    <span class="chapter-card__num">21</span>
    <h3>Pruebas negativas y rechazo</h3>
    <p>Que debe fallar, como leer un rechazo correcto y que evidencias recoger en backend.</p>
    <span class="chapter-card__topics">5 apartados · pruebas negativas · logs</span>
  </a>
  <a href="capitulo_22/22_1-lo_que_binario_expone.md" class="chapter-card">
    <span class="chapter-card__num">22</span>
    <h3>Revision integrada binario + backend</h3>
    <p>Como cruzar lo que expone el cliente con lo que valida el servidor en un mismo informe.</p>
    <span class="chapter-card__topics">4 apartados · correlacion de evidencias</span>
  </a>
  <a href="capitulo_23/23_1-checklist_binario_y_firma.md" class="chapter-card">
    <span class="chapter-card__num">23</span>
    <h3>Criterios de revision de UT8</h3>
    <p>Checklist final para binario, firma, secretos, compras integradas y priorizacion de hallazgos.</p>
    <span class="chapter-card__topics">5 apartados · checklist · priorizacion</span>
  </a>
</div>
