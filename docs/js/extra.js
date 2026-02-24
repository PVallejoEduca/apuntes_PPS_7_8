/* =========================================
   LÓGICA DE GUARDADO DE TAREAS (LOCALSTORAGE)
   ========================================= */
document.addEventListener("DOMContentLoaded", function() {
    initCodelabTasks();
});

// Nota: Si en tu mkdocs.yml tienes activado 'navigation.instant', 
// descomenta la siguiente línea para que el script recargue al cambiar de página:
// document$.subscribe(function() { initCodelabTasks(); });

function initCodelabTasks() {
    const tasks = document.querySelectorAll('.codelab-task input[type="checkbox"]');
    
    tasks.forEach(task => {
        // Generamos un ID único combinando la ruta de la página y el ID del checkbox.
        // Evita que tareas con el mismo ID en distintas páginas pisen el estado.
        const pagePath = window.location.pathname.replace(/[^a-zA-Z0-9]/g, '-');
        const storageKey = 'fp-codelab-' + pagePath + '-' + task.id;

        // Recuperar estado al cargar
        const savedState = localStorage.getItem(storageKey);
        if (savedState === 'true') {
            task.checked = true;
            updateTaskStyle(task);
        }

        // Guardar estado al hacer clic
        task.addEventListener('change', function() {
            localStorage.setItem(storageKey, this.checked);
            updateTaskStyle(this);
        });
    });

    function updateTaskStyle(checkbox) {
        const parentDiv = checkbox.closest('.codelab-task');
        if (checkbox.checked) {
            parentDiv.classList.add('completed');
        } else {
            parentDiv.classList.remove('completed');
        }
    }
}