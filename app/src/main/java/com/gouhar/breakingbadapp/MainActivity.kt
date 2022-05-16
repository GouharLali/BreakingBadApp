package com.gouhar.breakingbadapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.gouhar.breakingbadapp.ui.theme.BreakingBadAppTheme
import mainscreen.CharacterListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BreakingBadAppTheme {

                val viewModel = CharacterListViewModel()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 32.dp,
                            vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        CharacterCard(Color.Red, viewModel.actor.value?.name ?: "")
                        CharacterCard(Color.Green, "Angelina Jolie")
                        CharacterCard(Color.Magenta, "Margot Robbie")
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterCard(color:Color, actorName: String){
    Card(
        elevation = 10.dp,
        modifier = Modifier.fillMaxWidth()
    ){
        Row (modifier = Modifier
            .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = color)
                    .size(70.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                    imageVector = (Icons.Rounded.Person),
                    contentDescription = "",
                    tint = Color.White
                )
            }
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically),
                text = actorName
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    val viewModel = CharacterListViewModel()

    BreakingBadAppTheme() {
        Column(
            modifier = Modifier.padding(horizontal = 32.dp,
                vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CharacterCard(Color.Red, viewModel.actor.value?.name ?: "")
            CharacterCard(Color.Green, "Angelina Jolie")
            CharacterCard(Color.Magenta, "Margot Robbie")
        }
    }
}


