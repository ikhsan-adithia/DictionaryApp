package com.example.dictionaryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dictionaryapp.presentation.DictionaryScreen
import com.example.dictionaryapp.ui.components.ImageCard
import com.example.dictionaryapp.ui.components.ImageCardWithAnnotatedString
import com.example.dictionaryapp.ui.theme.DictionaryAppTheme
import com.example.dictionaryapp.ui.theme.fontFamily
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DictionaryScreen()
            // TODO: Delete unused code
//            val scaffoldState = rememberScaffoldState()
//
//            var textValue by remember {
//                mutableStateOf("")
//            }
//
//            val scope = rememberCoroutineScope()
//
//            DictionaryAppTheme {
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    scaffoldState = scaffoldState
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center,
//                    ) {
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(10.dp)
//                        ) {
//                            ImageCard(
//                                modifier = Modifier.weight(1f),
//                                painter = painterResource(id = R.drawable.crab),
//                                contentDescription = "Mr. Krab",
//                                title = "Mr. Krab"
//                            ) {
//                                scope.launch {
//                                    scaffoldState.snackbarHostState.showSnackbar(
//                                        message = "ImageCard",
//                                        duration = SnackbarDuration.Short
//                                    )
//                                }
//                            }
//
//                            Spacer(modifier = Modifier.width(10.dp))
//
//                            ImageCardWithAnnotatedString(
//                                modifier = Modifier.weight(1f),
//                                painter = painterResource(id = R.drawable.crab),
//                                contentDescription = "Mr. Krab",
//                                onClick = {
//                                    scope.launch {
//                                        scaffoldState.snackbarHostState.showSnackbar(
//                                            message = "ImageCardWithAnnotatedString",
//                                            duration = SnackbarDuration.Short
//                                        )
//                                    }
//                                },
//                                titleContent = {
//                                    Box(modifier = Modifier.fillMaxSize()) {
//                                        Text(
//                                            modifier = Modifier
//                                                .align(Alignment.BottomStart)
//                                                .padding(10.dp),
//                                            text = buildAnnotatedString {
//                                                withStyle(
//                                                    style = SpanStyle(
//                                                        fontSize = 20.sp,
//                                                        fontFamily = fontFamily,
//                                                        fontWeight = FontWeight.Bold
//                                                    )
//                                                ) {
//                                                    append("Mr. ")
//                                                }
//                                                withStyle(
//                                                    style = SpanStyle(
//                                                        fontSize = 16.sp,
//                                                        fontFamily = fontFamily,
//                                                        fontWeight = FontWeight.Normal
//                                                    )
//                                                ) {
//                                                    append("Krab")
//                                                }
//                                            },
//                                            color = Color.White,
//                                        )
//                                    }
//                                }
//                            )
//                        }
//
//                        Column(
//                            modifier = Modifier
//                                .padding(20.dp)
//                        ) {
//                            OutlinedTextField(
//                                modifier = Modifier
//                                    .fillMaxWidth(),
//                                value = textValue,
//                                onValueChange = { textValue = it },
//                                label = {
//                                    Text(text = "Enter your name")
//                                },
//                                singleLine = true
//                            )
//
//                            Spacer(modifier = Modifier.height(10.dp))
//
//                            Button(
//                                modifier = Modifier.align(Alignment.End),
//                                onClick = { scope.launch {
//                                    if (textValue.isNotBlank()) {
//                                        scaffoldState.snackbarHostState.showSnackbar(
//                                            message = "Heyo $textValue",
//                                            duration = SnackbarDuration.Short
//                                        )
//                                    }
//                                } }
//                            ) {
//                                Text(text = "Press me hard")
//                            }
//                        }
//                    }
//                }
//            }
        }
    }
}

//@Composable
//fun TransformableSample() {
//    // set up all transformation states
//    var scale by remember { mutableStateOf(1f) }
//    var rotation by remember { mutableStateOf(0f) }
//    var offset by remember { mutableStateOf(Offset.Zero) }
//    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
//        scale *= zoomChange
//        rotation += rotationChange
//        offset += offsetChange
//    }
//    Box(
//        Modifier
//            // apply other transformations like rotation and zoom
//            // on the pizza slice emoji
//            .graphicsLayer(
//                scaleX = scale,
//                scaleY = scale,
//                rotationZ = rotation,
//                translationX = offset.x,
//                translationY = offset.y
//            )
//            // add transformable to listen to multitouch transformation events
//            // after offset
//            .transformable(state = state)
//            .background(Color.Blue)
//            .fillMaxSize()
//    )
//}