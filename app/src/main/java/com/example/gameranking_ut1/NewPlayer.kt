import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.gameranking_ut1.R
import com.example.gameranking_ut1.ui.theme.colorDani
import com.example.gameranking_ut1.ui.theme.colorText
import com.example.gameranking_ut1.ui.theme.inversePrimaryLight
import com.example.gameranking_ut1.ui.theme.tertiaryLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuNewPlayer(modifier: Modifier = Modifier) {
    var EstadoNombre by remember { mutableStateOf("") }
    var EstadoApellido by remember { mutableStateOf("") }
    var EstadoNick by remember { mutableStateOf("") }
    var EstadoTelf by remember { mutableStateOf("") }
    var EstadoMail by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) } // Variable para el control de errores
    var pesoH = 3f
    var pesoV = 1f
    var EstadoOutlined by remember { mutableStateOf("") }

    //texto = "New Player"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        contentAlignment = Alignment.TopStart,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.account),
                    contentDescription = "User",
                    Modifier
                        .size(60.dp)
                        .weight(1f),
                    colorFilter = ColorFilter.tint(colorText)
                )

                OutlinedTextField(
                    modifier = Modifier.weight(2f),
                    value = EstadoOutlined, onValueChange = { EstadoOutlined = it },
                    label = {
                        if (nameError) {
                            Text(text = "*Obligatorio")
                        } else {
                            Text(text = "First Name")
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.Cyan,
                        unfocusedContainerColor = Color.Cyan,
                        errorContainerColor = inversePrimaryLight
                    ),
                    isError = nameError,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
            }
            Row {
                val assistiveElementText =
                    if (nameError) "Error: Obligatorio" else "*Obligatorio" // 4
                val assistiveElementColor = if (nameError) { // 5
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)

                }

            }
            //Spacer(modifier = Modifier.size(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {

                Spacer(Modifier.weight(1f))
                OutlinedTextField(
                    modifier = Modifier.weight(2f),
                    value = EstadoOutlined, onValueChange = { EstadoOutlined = it },
                    label = { Text(text = "Last Name") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.Cyan,
                        unfocusedContainerColor = Color.Cyan,

                        ),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.mask),
                    contentDescription = "User",
                    Modifier
                        .size(60.dp)
                        .weight(1f),
                    colorFilter = ColorFilter.tint(colorText)
                )
                OutlinedTextField(
                    modifier = Modifier.weight(2f),
                    value = EstadoOutlined, onValueChange = { EstadoOutlined = it },
                    label = { Text(text = "NickName") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.Cyan,
                        unfocusedContainerColor = Color.Cyan
                    ),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
            }
            Spacer(Modifier.size(20.dp))
            Row {

                Image(
                    painter = painterResource(R.drawable.android),
                    contentDescription = "Android",
                    Modifier
                        .size(100.dp)
                        .weight(2f)
                )
                Button(
                    onClick = { },//navController.navigate("NewPlayer") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorDani,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(200.dp)
                        .weight(1f)
                        .padding(vertical = 30.dp)
                ) {
                    Text(text = "Preferences")
                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(R.drawable.phone),
                    contentDescription = "Telefono",
                    Modifier
                        .size(60.dp)
                        .weight(1f),
                    colorFilter = ColorFilter.tint(colorText)
                )

                TextField(
                    value = EstadoTelf,
                    onValueChange = {
                        EstadoTelf = it
                    },
                    Modifier.weight(2f),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Cyan,
                        focusedIndicatorColor = colorDani
                    ),
                    label = { Text(text = ("Teléfono")) },
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(R.drawable.email),
                    contentDescription = "E-mail",
                    Modifier
                        .size(60.dp)
                        .weight(1f),
                    colorFilter = ColorFilter.tint(colorText)
                )
                TextField(
                    value = EstadoMail,
                    onValueChange = {
                        EstadoMail = it
                    },
                    Modifier.weight(2f),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Cyan,
                        focusedIndicatorColor = colorDani
                    ),
                    label = { Text(text = ("E-mail")) },
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
            }
            Spacer(Modifier.height(20.dp))
            Row() {
                /*  Button(
                      onClick = { nameError = EstadoNombre.isBlank() },
                      shape = RoundedCornerShape(15.dp)
                  ) {
                      Text(text = "Add new player")*/
                ExtendedFloatingActionButton(
                    onClick = { nameError = EstadoNombre.isBlank() },
                    icon = { Icon(Icons.Filled.AccountCircle, "Add new player") },
                    text = { Text(text = "Add new player") },
                    containerColor = tertiaryLight
                )
            }
        }

    }
}
