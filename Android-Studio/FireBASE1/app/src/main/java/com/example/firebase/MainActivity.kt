package com.example.firebase
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebase.ui.theme.FireBASETheme
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FireBASETheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(db)
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App(db: FirebaseFirestore) {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var clientes by remember { mutableStateOf(listOf<Map<String, String>>()) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current // Gerenciador de foco

    FireBASETheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Firebase Firestore",
                        textAlign = TextAlign.Center,
                        fontSize = 34.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))

                Row {
                    Column(Modifier.fillMaxWidth(0.3f)) {
                        Text(text = "Nome:", fontSize = 24.sp, fontFamily = FontFamily.SansSerif)
                    }
                    Column() {
                        TextField(value = nome, onValueChange = { nome = it })
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))

                Row {
                    Column(Modifier.fillMaxWidth(0.3f)) {
                        Text(text = "Telefone:", fontSize = 24.sp, fontFamily = FontFamily.SansSerif)
                    }
                    Column() {
                        TextField(value = telefone, onValueChange = { telefone = it })
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        val pessoa = hashMapOf(
                            "Nome" to nome,
                            "Telefone" to telefone
                        )
                        db.collection("Clientes").add(pessoa)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Documento impresso com sucesso")
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar("Usuário cadastrado")
                                }
                                // Limpa os campos após o cadastro
                                nome = ""
                                telefone = ""
                                // Oculta o teclado
                                focusManager.clearFocus()
                                // Atualiza a lista de clientes após a adição
                                fetchClientes(db) { lista ->
                                    clientes = lista
                                }
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao imprimir o documento", e)
                            }
                    }) {
                        Text(text = "Cadastrar")
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))

                // Exibir a lista de clientes
                Text(
                    text = "Clientes cadastrados:",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.padding(16.dp)
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    items(clientes) { cliente ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = cliente["Nome"] ?: "")
                            Text(text = cliente["Telefone"] ?: "")
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }

                // Snackbar host to display the snackbar message
                SnackbarHost(
                    hostState = snackbarHostState,

                )
            }
        }
    }

    // Inicializa a lista de clientes ao carregar o Composable
    LaunchedEffect(Unit) {
        fetchClientes(db) { lista ->
            clientes = lista
        }
    }
}

fun fetchClientes(db: FirebaseFirestore, onResult: (List<Map<String, String>>) -> Unit) {
    db.collection("Clientes").get()
        .addOnSuccessListener { documents ->
            val lista = mutableListOf<Map<String, String>>()
            for (document in documents) {
                val cliente = mapOf(
                    "Nome" to (document.getString("Nome") ?: ""),
                    "Telefone" to (document.getString("Telefone") ?: "")
                )
                lista.add(cliente)
            }
            onResult(lista)
        }
        .addOnFailureListener { exception ->
            Log.w("Firestore", "Error ao buscar documentos: ", exception)
        }
}
