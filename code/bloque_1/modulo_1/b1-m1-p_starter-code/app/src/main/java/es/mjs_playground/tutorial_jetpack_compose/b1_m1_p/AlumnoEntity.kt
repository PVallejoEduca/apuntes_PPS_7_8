package es.mjs_playground.tutorial_jetpack_compose.b1_m1_p

// TODO (Paso 1): ¡Este código es de la prehistoria!
// Borra este archivo entero. En su lugar, crea una 'data class'
// llamada AlumnoEntity en el archivo GestorAlumnos.kt
class AlumnoEntity {
    var dni: String = ""
    var nombre: String = ""
    var notaMedia: Double = 0.0

    constructor(dni: String, nombre: String, notaMedia: Double) {
        this.dni = dni
        this.nombre = nombre
        this.notaMedia = notaMedia
    }
}