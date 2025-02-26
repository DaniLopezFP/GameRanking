package com.example.gameranking_ut1

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gameranking_ut1.ui.theme.colorText
import com.example.gameranking_ut1.ui.theme.courgetteRegularFamily
import com.example.gameranking_ut1.ui.theme.primaryLight
import com.example.gameranking_ut1.ui.theme.secondaryContainerLight
import com.example.gameranking_ut1.ui.theme.secondaryLight


//Lista 1 para los chips
val plataformas: List<String> = listOf(
    "PS5",
    "Xbox X/S",
    "Switch",
    "PC",
    "Android",
    "Apple"
)

//var texto:MutableList<String> =" "

@Composable
fun Preferencias(navController: NavHostController) {
    //var texto by remember { mutableStateOf("") }
    val texto: MutableList<String> = mutableListOf()
    var muestraTexto: String = ""

    var context = LocalContext.current
    var gamesList: List<String> = listOf(
        "RPG",
        "Hack'n slash",
        "Cars",
        "Casual games",
        "Action",
        "Platforms",
        "Strategy",
        "Graphic adventure",
        "Arcade",
        "Fight"
    )
    Column(
        modifier = Modifier.verticalScroll(
            rememberScrollState()
        )
    ) {
        //TopAppPers()
        Row(Modifier.padding(start = 10.dp)) {
            Text(
                text = "Platforms:",
                modifier = Modifier.padding(4.dp),
                fontSize = 25.sp,
                fontFamily = courgetteRegularFamily,
                color = colorText
            )
        }
        Row {
            ChipGroupCompose(plataformas)
        }

        Row(Modifier.padding(10.dp)) {
            Text(
                text = "Games Type:",
                //color = Ex_sec,
                modifier = Modifier.padding(4.dp),
                fontSize = 25.sp,
                fontFamily = courgetteRegularFamily,
                color = colorText
            )
        }
        for (opcion in gamesList) {
            MyCheckBox(opcion, texto)
        }
         Row(
             Modifier.padding(10.dp),
             horizontalArrangement = Arrangement.Center,
             verticalAlignment = Alignment.CenterVertically
         ) {
            Button(onClick = {
                if (texto.size == 0) {
                    Toast.makeText(
                        context,
                        "Nothing selected",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    for (lista in texto) {
                        when (texto.indexOf(lista)) {
                            0 -> muestraTexto = lista
                            texto.size - 1 -> muestraTexto = muestraTexto + " & " + lista
                            else -> muestraTexto = muestraTexto + ", " + lista
                        }
                    }
                    Toast.makeText(
                        context,
                        "Saving your in your profile $muestraTexto",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }) {
                Text("Add your preferences")
            }
        }
    }
}


//Función para mostrar los diferentes checkbox
@Composable
fun MyCheckBox(seleccion: String, texto: MutableList<String>) {
    var context = LocalContext.current
    var selected by remember { mutableStateOf(false) }

    Row() {
        Spacer(modifier = Modifier.size(10.dp))
        Checkbox(
            checked = selected,
            colors = CheckboxDefaults.colors(
                uncheckedColor = Color.White,
            ),
            onCheckedChange = {
                selected = !selected
                if (selected) {
                    texto.add(seleccion)
                } else {
                    texto.remove(seleccion)
                }
            })
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = seleccion, color = Color.White, modifier = Modifier.padding(top = 16.dp))

    }
}

@Composable
fun ChipGroupCompose(lista: List<String>) {
    val nombre: String
    var selectec by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            //Recorro la lista llamando a cada uno de los chips
            for (opcion in lista) {
                item {
                    FilterChipExample(opcion)
                    Spacer(Modifier.size(5.dp))
                }
            }
        }
    }
}

//Creamos los chips
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipExample(opcion: String) {
    var selected by remember { mutableStateOf(false) }
    var context = LocalContext.current

    FilterChip(
        onClick = {
            selected = !selected
            if (selected) {
                Toast.makeText(context, "You has selected " + opcion, Toast.LENGTH_LONG).show()
            }
        },
        label = {
            Text(opcion)
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = secondaryContainerLight
        ),
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}