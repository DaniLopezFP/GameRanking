package com.example.gameranking_ut1

import MenuNewPlayer
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gameranking_ut1.ui.theme.GameRanking_UT1Theme
import com.example.gameranking_ut1.ui.theme.colorText
import com.example.gameranking_ut1.ui.theme.courgetteRegularFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameRanking_UT1Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        //MenuPlayGames()
                        // MenuNewPlayer(modifier = Modifier.padding(innerPadding))
                        NavHost(
                            navController = navController,
                            startDestination = "RankingGames"
                        ) {
                            composable("NewPlayer") { MenuNewPlayer() }
                            composable("RankingGames") { MenuPlayGames(navController) }
                            composable("Preferences") { Preferencias(navController) }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MenuPlayGames(navController: NavHostController) {
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            MenuVertical(navController)
        }

        else -> {
            MenuHorizontal(navController)
        }
    }
}

@Composable
fun MenuVertical(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    //.background(Color.Cyan)
                    .size(200.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.stargame),
                    contentDescription = "E-mail",
                    Modifier
                        .size(200.dp),
                    //.weight(1f),
                    //colorFilter = ColorFilter.tint(colorText)
                )
            }
            Text(
                "Game Ranking", style = TextStyle(
                    fontSize = 50.sp,
                    fontFamily = courgetteRegularFamily,
                    fontWeight = FontWeight.Normal,
                    color = colorText
                )
            )

            Button(
                onClick = { }, modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Ranking")
            }
            Button(
                onClick = { navController.navigate("NewPlayer") },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "New Player")
            }
            Button(
                onClick = { navController.navigate("Preferences") },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Preferences")
            }
            Button(
                onClick = { }, modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Users")

            }

            Button(
                onClick = { },//navController.navigate("About") },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "About")
            }
        }
    }
}


@Composable
fun MenuHorizontal(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(
                rememberScrollState()
            )
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .size(150.dp)
                ) {
                }
            }

            Row {
                Text(
                    "Game Ranking", style = TextStyle(
                        fontSize = 50.sp,
                        fontFamily = courgetteRegularFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorText
                    )
                )
            }
            Row {

                Button(
                    onClick = { navController.navigate("NewPlayer") },
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "New Player")
                }
                Button(
                    onClick = { navController.navigate("Preferences") },
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "Ranking")
                }
                Button(
                    onClick = { }, modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "Preferences")
                }
            }
            Row {
                Button(
                    onClick = { }, modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "Users")

                }
                Button(
                    onClick = { },//navController.navigate("About") },
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "About")
                }
            }

        }
    }
}
