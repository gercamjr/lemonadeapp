package com.geracomdev.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geracomdev.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun ButtonImageWithText(modifier: Modifier = Modifier) {
    var stageNumber by remember {mutableStateOf(1)}
    var imageResource = when(stageNumber) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    var stringResource = when (stageNumber) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon_squeeze
        3 -> R.string.lemonade_drink
        else -> R.string.reset
    }
    Column(modifier = modifier,horizontalAlignment = Alignment.CenterHorizontally) {
        ElevatedButton(onClick = {}, ) {
            Image(painter = painterResource(R.drawable.lemon_tree), contentDescription = "Lemon Tree")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(R.string.lemon_tree), color = MaterialTheme.colorScheme.inversePrimary, fontSize = 18.sp)
    }
}

@Composable
@Preview
fun LemonadeApp() {
    ButtonImageWithText(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
}

