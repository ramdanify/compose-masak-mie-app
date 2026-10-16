package com.ramdani.masakmie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.ramdani.masakmie.ui.theme.MasakMieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MasakMieAppTheme {
                MasakMieApp()
            }
        }
    }
}

@Composable
fun MasakMieTextImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding)),
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MasakMieApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableIntStateOf(1) }
    var tapCount by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Masak Mie",
                        fontWeight = FontWeight.Bold,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
            )
        },
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background,
        ) {
            when (currentStep) {
                1 -> {
                    MasakMieTextImage(
                        textLabelResourceId = R.string.warung_madura_text,
                        drawableResourceId = R.drawable.warung_madura,
                        contentDescriptionResourceId = R.string.warung_madura_desc,
                        onImageClick = {
                            currentStep = 2
                        },
                    )
                }

                2 -> {
                    MasakMieTextImage(
                        textLabelResourceId = R.string.indomie_goreng_text,
                        drawableResourceId = R.drawable.indomie_goreng,
                        contentDescriptionResourceId = R.string.indomie_goreng_desc,
                        onImageClick = {
                            currentStep = 3
                        },
                    )
                }

                3 -> {
                    MasakMieTextImage(
                        textLabelResourceId = R.string.indomie_goreng_dibuka_text,
                        drawableResourceId = R.drawable.indomie_goreng_dibuka,
                        contentDescriptionResourceId = R.string.indomie_goreng_dibuka_desc,
                        onImageClick = {
                            currentStep = 4
                            tapCount = (2..5).random()
                        },
                    )
                }

                4 -> {
                    MasakMieTextImage(
                        textLabelResourceId = R.string.lagi_dimasak_text,
                        drawableResourceId = R.drawable.lagi_dimasak,
                        contentDescriptionResourceId = R.string.lagi_dimasak_desc,
                        onImageClick = {
                            tapCount--
                            if (tapCount <= 0) {
                                currentStep = 5
                            }
                        },
                    )
                }

                5 -> {
                    MasakMieTextImage(
                        textLabelResourceId = R.string.lagi_ditiriskan_text,
                        drawableResourceId = R.drawable.lagi_ditiriskan,
                        contentDescriptionResourceId = R.string.lagi_ditiriskan_desc,
                        onImageClick = {
                            currentStep = 6
                        },
                    )
                }

                6 -> {
                    MasakMieTextImage(
                        textLabelResourceId = R.string.mie_dipiring_text,
                        drawableResourceId = R.drawable.mie_dipiring,
                        contentDescriptionResourceId = R.string.mie_dipiring_desc,
                        onImageClick = {
                            currentStep = 7
                        },
                    )
                }

                7 -> {
                    MasakMieTextImage(
                        textLabelResourceId = R.string.mie_belum_dibumbuin_text,
                        drawableResourceId = R.drawable.mie_belum_dibumbuin,
                        contentDescriptionResourceId = R.string.mie_belum_dibumbuin_desc,
                        onImageClick = {
                            currentStep = 8
                        },
                    )
                }

                8 -> {
                    MasakMieTextImage(
                        textLabelResourceId = R.string.mie_sudah_jadi_text,
                        drawableResourceId = R.drawable.mie_sudah_jadi,
                        contentDescriptionResourceId = R.string.mie_sudah_jadi_desc,
                        onImageClick = {
                            currentStep = 1
                        },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MasakMieAppTheme {
        MasakMieApp()
    }
}