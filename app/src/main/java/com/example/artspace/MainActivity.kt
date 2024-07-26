package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier){
    var pageNum by remember {
        mutableStateOf(1)
    }

    when(pageNum){
        1 -> {
            ArtSpace(
                title = R.string.at,
                description = R.string.ad,
                img = R.drawable._3876287721_0c73a04b63_q,
                onClickNext = {pageNum = 2},
                onClickPrevious = {pageNum = 5}
            )
        }
        2 -> {
            ArtSpace(
                title = R.string.bt,
                description = R.string.bd,
                img = R.drawable._3876457898_ece189fd0e_q,
                onClickNext = {pageNum = 3},
                onClickPrevious = {pageNum = 1}
            )
        }
        3 -> {
            ArtSpace(
                title = R.string.ct,
                description = R.string.cd,
                img = R.drawable._3876484333_3e2b02ba9e_q,
                onClickNext = {pageNum = 4},
                onClickPrevious = {pageNum = 2}
            )
        }
        4 -> {
            ArtSpace(
                title = R.string.dt,
                description = R.string.dd,
                img = R.drawable._3876623114_052fa9a51b_q,
                onClickNext = {pageNum = 5},
                onClickPrevious = {pageNum = 3}
            )
        }
        5 -> {
            ArtSpace(
                title = R.string.et,
                description = R.string.ed,
                img = R.drawable._3876628304_36c1324083_q,
                onClickNext = {pageNum = 1},
                onClickPrevious = {pageNum = 4}
            )
        }
    }
}


@Composable
fun ArtSpace(@StringRes title: Int,
             @StringRes description: Int,
             @DrawableRes img: Int,
             onClickNext: ()->Unit,
             onClickPrevious: ()->Unit,
             modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = Modifier
            .weight(0.6f)
            .fillMaxWidth()
            .padding(top = 80.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)
            .shadow(15.dp, RoundedCornerShape(2.dp))
            .border(width = 2.dp, shape = RoundedCornerShape(4.dp), color = Color.White)
            .background(Color.White)){
            Image(painter = painterResource(id = img), contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp))
        }
        Column(modifier = Modifier
            .weight(0.3f)
            .fillMaxWidth()
            .padding(top = 20.dp, start = 30.dp, end = 30.dp, bottom = 20.dp)
            .background(Color(0xffECEBF4))) {
            Text(text = stringResource(id = title),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .align(Alignment.CenterHorizontally))
            Text(text = stringResource(id = description),
                fontSize = 15.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .verticalScroll(rememberScrollState())
                )
        }
        Row(modifier = Modifier
            .weight(0.1f)
            .padding(top = 10.dp)
            .align(alignment = Alignment.CenterHorizontally)) {
            Button(onClick = onClickPrevious,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.padding(5.dp))

            Button(onClick = onClickNext,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}