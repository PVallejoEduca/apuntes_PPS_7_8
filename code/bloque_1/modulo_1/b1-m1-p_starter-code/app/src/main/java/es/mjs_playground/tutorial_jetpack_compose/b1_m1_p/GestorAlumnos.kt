package es.mjs_playground.tutorial_jetpack_compose.b1_m1_p

import kotlinx.coroutines.delay

// TODO (Paso 1): Crea la dataclass

// TODO (Paso 3): La interfaz gráfica está "apañando" los textos
// Créa aquí fuera de la clase GestorAlumnos la extensión function 'aFormatoNota()'
// Haz que llame a 'aFormatoNota()' sobre la clase Double en el MainActivity.


class GestorAlumnos {

    // Lista estática que simula nuestra base de datos
    private val baseDeDatos = listOf(
        AlumnoEntity("11111111A", "Ana García", 8.5),
        AlumnoEntity("22222222B", "Pedro López", 4.2),
        AlumnoEntity("33333333C", "Lucía Martínez", 9.1),
        AlumnoEntity("44444444D", "Javier Fernández", 3.8),
        AlumnoEntity("55555555E", "Marta Ruiz", 6.0)
    )

    // TODO (Paso 5): Esta función congela la pantalla de la app.
    // Conviértela en una función de suspensión (suspend fun) y sustituye el
    // Thread.sleep por la alternativa no bloqueante de Kotlin.
    fun simularCargaDeDatos(): List<AlumnoEntity> {
        Thread.sleep(2000) // ¡Pecado! Esto bloquea el Main Thread
        return baseDeDatos
    }

    // TODO (Paso 4): Borra todo este código imperativo.
    // Utiliza la programación funcional (.filter y .map) para conseguir lo mismo.
    fun obtenerNombresAprobados(): List<String> {
        val aprobados = mutableListOf<String>()
        for (alumno in baseDeDatos) {
            if (alumno.notaMedia >= 5.0) {
                aprobados.add(alumno.nombre)
            }
        }
        return aprobados
    }

    // TODO (Paso 2): Simplifica esta función a una sola línea.
    // PISTA: Utiliza la función .find { }, el Safe Call (?.) y el Operador Elvis (?:)
    fun obtenerNombrePorDni(dni: String): String {
        var alumnoEncontrado: AlumnoEntity? = null

        for (alumno in baseDeDatos) {
            if (alumno.dni == dni) {
                alumnoEncontrado = alumno
                break
            }
        }

        if (alumnoEncontrado != null) {
            return alumnoEncontrado.nombre
        } else {
            return "Desconocido"
        }
    }
}