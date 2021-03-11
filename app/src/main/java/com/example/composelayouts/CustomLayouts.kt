package com.example.composelayouts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelayouts.ui.theme.ComposeLayoutsTheme

class CustomLayouts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

//@Composable
//fun StaggeredGrid(
//    modifier: Modifier = Modifier,
//    rows: Int = 3, content:
//    @Composable () -> Unit
//) {
//    Layout(modifier = modifier, content = content) { measurables, constraints ->
//
//    }
//}

