package es.mjs_playground.tutorial_jetpack_compose.b1_m1_p

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import es.mjs_playground.tutorial_jetpack_compose.b1_m1_p.ui.theme.MJS_TUTOb1m1pTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Diseño moderno pantalla completa
        setContent {
            MJS_TUTOb1m1pTheme {
                GestorApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GestorApp() {
    val gestor = remember { GestorAlumnos() }
    var listaAlumnos by remember { mutableStateOf<List<AlumnoEntity>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    // LaunchedEffect lanza una corrutina al iniciar la pantalla
    LaunchedEffect(Unit) {
        listaAlumnos = gestor.simularCargaDeDatos() // Llamada a nuestra suspend fun
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.top_bar_title), fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                // Estado de carga (Gracias a la corrutina, esto gira fluido)
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(stringResource(R.string.loading_text))
                }
            } else {
                // Lista real cargada
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(listaAlumnos) { alumno ->
                        AlumnoCard(alumno)
                    }
                }
            }
        }
    }
}

@Composable
fun AlumnoCard(alumno: AlumnoEntity) {
    // Tarjeta moderna estilo M3
    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = alumno.nombre, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "DNI: ${alumno.dni}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            // Aquí usamos nuestra Extension Function "aFormatoNota()"
            Text(
                // TODO: PASO 3 - sustituye el código actual por este
                // text = alumno.notaMedia.aFormatoNota(),
                text = "${alumno.notaMedia} pts",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = if (alumno.notaMedia >= 5.0)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.error
            )
        }
    }
}