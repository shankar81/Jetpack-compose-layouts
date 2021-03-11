package com.example.composelayouts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.composelayouts.ui.theme.ComposeLayoutsTheme

class ConstraintLayoutDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    // ConstraintLayoutContent()
                    DecoupledConstraintLayout()
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {

        val (button, button2, text) = createRefs()
        val guideLine = createGuidelineFromStart(fraction = 0.5f)

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 15.dp)
//                linkTo(start = parent.start, end = parent.end)
//                width= Dimension.fillToConstraints
            }) {
            Text("This is Button")
        }
        Text(
            "This is a very very very very very very very long text",
            Modifier.constrainAs(text) {
                linkTo(start = guideLine, end = parent.end)
                top.linkTo(button.bottom, margin = 15.dp)
//                centerHorizontallyTo(parent)
                width = Dimension.preferredWrapContent
            })

        val barrier = createEndBarrier(button, text)

        Button(onClick = { }, modifier = Modifier.constrainAs(button2) {
            top.linkTo(parent.top, margin = 15.dp)
            start.linkTo(barrier)
        }) {
            Text("Button 2")
        }
    }
}

@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints() {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(16.dp) // Portrait
        } else {
            decoupledConstraints(32.dp) // Landscape
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin = margin)
        }
    }
}