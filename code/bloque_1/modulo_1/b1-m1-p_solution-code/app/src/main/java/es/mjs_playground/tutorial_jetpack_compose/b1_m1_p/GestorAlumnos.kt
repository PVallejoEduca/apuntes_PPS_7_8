package es.mjs_playground.tutorial_jetpack_compose.b1_m1_p

import kotlinx.coroutines.delay

// 1. Data Class: Limpia, inmutable y en una línea
data class AlumnoEntity(
    val dni: String,
    val nombre: String,
    val notaMedia: Double
)

// 2. Extension Function: Superpoderes para los Doubles
fun Double.aFormatoNota(): String {
    return "$this pts"
}

// 3. El Gestor (Simula el repositorio de datos)
class GestorAlumnos {

    // Base de datos en memoria (Simulación)
    private val baseDeDatos = listOf(
        AlumnoEntity("11111111A", "Ana García", 8.5),
        AlumnoEntity("22222222B", "Pedro López", 4.2),
        AlumnoEntity("33333333C", "Lucía Martínez", 9.1),
        AlumnoEntity("44444444D", "Javier Fernández", 3.8),
        AlumnoEntity("55555555E", "Marta Ruiz", 6.0)
    )

    // Función de Suspensión (Corrutinas): Espera sin bloquear la UI
    suspend fun simularCargaDeDatos(): List<AlumnoEntity> {
        delay(2000) // Simulamos 2 segundos de latencia de red
        return baseDeDatos
    }

    // Programación Funcional: map y filter
    fun obtenerNombresAprobados(): List<String> {
        return baseDeDatos
            .filter { it.notaMedia >= 5.0 }
            .map { it.nombre }
    }

    // Null Safety: Safe Call (?.) y Elvis (?:)
    fun obtenerNombrePorDni(dni: String): String {
        return baseDeDatos.find { it.dni == dni }?.nombre ?: "Desconocido"
    }
}