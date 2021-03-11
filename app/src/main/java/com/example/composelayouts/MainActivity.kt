package com.example.composelayouts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.composelayouts.ui.theme.ComposeLayoutsTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutsTheme {
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text("Compose Layouts")
                    }, actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Outlined.Search, contentDescription = null)
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.MoreVert, contentDescription = null)
                        }
                    }, navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    })
                }) { innerPadding ->
                    // PhotographyCard()
                    // SimpleList()
                    // LazyColumnList()
                    MyOwnColumn(modifier = Modifier.padding(15.dp)) {
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                        Text("Hello World!", Modifier.customLayoutModifier(32.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun PhotographyCard(modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colors.surface)
            .clickable(onClick = {})
            .padding(16.dp)
    ) {
        Surface(
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
            modifier = Modifier.size(50.dp),
            shape = CircleShape
        ) {
            // ...Image goes here
            CoilImage(
                data = "https://picsum.photos/300/300",
                contentDescription = "My content description",
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
                fadeIn = true
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()

    Column(Modifier.verticalScroll(scrollState)) {
        repeat(1000) {
            Text("Sample Text $it")
        }
    }
}

@Composable
fun LazyColumnList() {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(Modifier.fillMaxWidth()) {
        ButtonList(
            onTop = { coroutineScope.launch { scrollState.animateScrollToItem(0) } },
            onBottom = { coroutineScope.launch { scrollState.animateScrollToItem(999) } }
        )
        LazyColumn(state = scrollState) {
            items(1000) {
                PhotographyCard()
            }
        }
    }
}

@Composable
fun ButtonList(onTop: () -> Unit, onBottom: () -> Unit) {
    Row(Modifier.fillMaxWidth()) {
        Button(onClick = onTop, Modifier.width(180.dp)) {
            Text("Scroll to Top")
        }
        Button(onClick = onBottom, Modifier.width(180.dp)) {
            Text("Scroll to Bottom")
        }
    }
}

// Custom single layout
fun Modifier.customLayoutModifier(firstBaselineToTop: Dp) =
    Modifier.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        // Check
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseLine = placeable[FirstBaseline]

        val placeableY = firstBaselineToTop.roundToPx() - firstBaseLine
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            // Here the composable gets placed
            placeable.placeRelative(0, placeableY)
        }
    }

// Custom parent layout like Column, Rows ...
@Composable
fun MyOwnColumn(modifier: Modifier, content: @Composable () -> Unit) {
    Layout(content, modifier = modifier) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        // Track the y co-ord we have placed children up to
        var yPosition = 0

        // Set the size of layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place children in the parent layout
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = yPosition)

                // Record yPosition
                yPosition += placeable.height
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLayoutsTheme {
        PhotographyCard()
    }
}